package com.juntas.juntas_app.login_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.juntas.juntas_app.login_screen.domain.LoginData
import com.juntas.juntas_app.login_screen.domain.LoginError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(

) : ViewModel(){

    var state by mutableStateOf(LoginData(
        email = "",
        password = "",
        isLogin = false,
        ready = false,
        error = LoginError.NONE
        )
    )

    private fun logIn(){
        viewModelScope.launch {
            try {
                Firebase.auth.signInWithEmailAndPassword(state.email, state.password).await()
                state = state.copy(
                    isLogin = true
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
                Firebase.auth.sendPasswordResetEmail(email).await()
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


}