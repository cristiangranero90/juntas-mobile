package com.juntas.juntas_app.login_screen.domain

data class LoginData(
    val email: String,
    val password: String,
    val isLogin: Boolean,
    val ready: Boolean,
    val error: LoginError
)

enum class LoginError {
    NONE,
    EMPTY,
    SIGNUP,
    CREDENTIALS,
    FORGOT,
    EMAIL
}
