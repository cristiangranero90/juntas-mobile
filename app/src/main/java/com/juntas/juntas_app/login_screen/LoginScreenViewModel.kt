package com.juntas.juntas_app.login_screen

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.juntas.juntas_app.login_screen.domain.LoginData
import com.juntas.juntas_app.login_screen.domain.LoginError
import com.juntas.juntas_app.login_screen.domain.UserRegister
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    val auth: FirebaseAuth,
    val signInOptions: GoogleSignInOptions
) : ViewModel(){

    var state by mutableStateOf(LoginData(
        email = "",
        password = "",
        isLogin = false,
        ready = false,
        error = LoginError.NONE,
        register = false,
        emailSend = false,
        registerComplete = false
        )
    )
    private set

    init {
        try {
            if(auth.currentUser != null) {
                state = state.copy(
                    isLogin = true,
                    ready = true
                )
            }
        } catch (e: Exception){
            state = state.copy(
                error = LoginError.CREDENTIALS
            )
            e.printStackTrace()
        }
    }

    private fun logIn(){
        viewModelScope.launch {
            try {
                auth.signInWithEmailAndPassword(state.email, state.password).await()
                state = state.copy(
                    isLogin = true,
                    ready = true
                )
            } catch (e: Exception){
                state = state.copy(
                    error = LoginError.CREDENTIALS
                )
            }
        }
    }
    fun register(user: UserRegister) {
        viewModelScope.launch {
            state = state.copy(
                register = true
            )
            try {
                auth.createUserWithEmailAndPassword(
                    user.email,
                    user.password
                ).addOnCompleteListener {
                    state = state.copy(
                        registerComplete = true
                    )
                    sendEmailVerification()
                }.addOnFailureListener {
                    state = state.copy(
                        error = LoginError.SIGNUP
                    )
                }.await()
            } catch (e: Exception){
                state = state.copy(
                    error = LoginError.SIGNUP
                )
                print(e.stackTrace)
            }
            state = state.copy(
                register = false
            )
        }
    }

    private fun sendEmailVerification(){
        state = state.copy(
            register = true
        )
        viewModelScope.launch {
            try {
                auth.currentUser!!
                    .sendEmailVerification()
                    .addOnCompleteListener {
                        state = state.copy(
                            emailSend = true
                        )
                    }.addOnFailureListener {
                        state = state.copy(
                            error = LoginError.SEND
                        )
                    }.await()
            } catch (e: Exception) {
                state = state.copy(
                    error = LoginError.SEND
                )
                e.printStackTrace()
            }
        }
        state = state.copy(
            register = false
        )
    }
    private fun updateUser(name: String, photoUrl: String){
        state = state.copy(
            register = true
        )
        viewModelScope.launch {
            try {
                auth.currentUser!!.updateProfile(
                    UserProfileChangeRequest.Builder()
                        .setPhotoUri(Uri.parse(photoUrl))
                        .setDisplayName(name)
                        .build()
                ).await()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        state = state.copy(
            register = false
        )
    }

    fun changeEmail(it: String) {
    state = state.copy(
            email = it
        )
    }

    fun changePass(it: String) {
    state = state.copy(
        password = it
        )
    }

    fun verify() {
        if (state.email.isNotBlank() && state.email.isNotBlank()){
            logIn()
        } else {
            state = state.copy(
                error = LoginError.EMPTY
            )
        }
    }

    fun forgotPass(email: String) {
        print("FORMAT:" + email)
        viewModelScope.launch {
            try {
                auth.sendPasswordResetEmail(email).await()
                resetError()
            } catch (e: Exception) {
                state = state.copy(
                    error = LoginError.EMAIL
                )
                print("ERROR EMAIL:" + e.stackTrace)
            }
        }
    }

    fun resetError() {
        state = state.copy(
            error = LoginError.NONE
        )
    }

    fun recoveryPass() {
        state = state.copy(
            error = LoginError.FORGOT
        )
    }

    fun googleSignIn() {
        state = state.copy(
            isLogin = true,
            ready = true
        )
    }

    fun getImage() : String {
        return if (auth.currentUser != null) {
            auth.currentUser!!.photoUrl.toString()
        } else {
            "https://newprofilepic2.photo-cdn.net//assets/images/article/profile.jpg"
        }
    }
}