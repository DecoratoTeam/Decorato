package com.example.decorato.presentation.viewModel.login

interface LoginInteractionListener {
    fun onEmailUpdated(email: String)
    fun onPasswordUpdated(password: String)
    fun onShowPasswordClicked()
    fun onLoginClicked()
    fun onContinueAsGuestClicked()
    fun onNavigateToRegisterClicked()

    fun onForgotPasswordClicked()

    fun onCreateAccountClicked()
}
