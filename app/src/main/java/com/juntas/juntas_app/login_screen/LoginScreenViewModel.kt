package com.juntas.juntas_app.login_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.juntas.juntas_app.login_screen.domain.LoginData
import com.juntas.juntas_app.login_screen.domain.LoginError
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
        error = LoginError.NONE
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