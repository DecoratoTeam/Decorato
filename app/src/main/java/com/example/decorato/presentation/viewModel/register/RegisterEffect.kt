package com.example.decorato.presentation.viewModel.register

sealed interface RegisterEffect {
    data object NavigateToHome : RegisterEffect
    data object NavigateToLogin : RegisterEffect
    data object RegistrationSuccess : RegisterEffect
}