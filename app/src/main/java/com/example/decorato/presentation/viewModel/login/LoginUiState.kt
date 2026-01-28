package com.example.decorato.presentation.viewModel.login

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isPasswordVisible: Boolean = false,
    val isLoading: Boolean = false,

    val emailError: String? = null,
    val passwordError: String? = null,
    val error: String? = null
) {
    val isLoginButtonEnabled: Boolean
        get() = email.isNotBlank() && password.isNotBlank() && !isLoading

    val isContinueAsGuestButtonEnabled: Boolean
        get() = !isLoading
}


