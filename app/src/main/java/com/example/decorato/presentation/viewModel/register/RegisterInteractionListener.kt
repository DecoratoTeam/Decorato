package com.example.decorato.presentation.viewModel.register

interface RegisterInteractionListener {
    fun onNameUpdated(name: String)
    fun onEmailUpdated(email: String)
    fun onPasswordUpdated(password: String)
    fun onShowPasswordClicked()
    fun onSignUpClicked()
    fun onContinueWithGoogleClicked()
    fun onAlreadyHaveAccountClicked()
}