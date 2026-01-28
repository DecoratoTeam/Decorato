package com.example.decorato.presentation.viewModel.login

sealed interface LoginEffect {
    data object NavigateToHome : LoginEffect
    data object NavigateToRegister : LoginEffect
    data object LoginSuccess : LoginEffect

    data object NavigateToResetPassword : LoginEffect

    data object NavigateToContinueAsGuest : LoginEffect
}
