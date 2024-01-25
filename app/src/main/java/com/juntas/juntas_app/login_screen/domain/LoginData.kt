package com.juntas.juntas_app.login_screen.domain

data class LoginData(
    val email: String,
    val password: String,
    val isLogin: Boolean,
    val ready: Boolean,
    val error: LoginError,
    val register: Boolean,
    val emailSend: Boolean,
    val registerComplete: Boolean
)

enum class LoginError {
    NONE,
    EMPTY,
    SIGNUP,
    CREDENTIALS,
    FORGOT,
    EMAIL,
    SEND
}
