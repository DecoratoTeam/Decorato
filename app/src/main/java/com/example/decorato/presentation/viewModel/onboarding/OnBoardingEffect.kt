package com.example.decorato.presentation.viewModel.onboarding

sealed interface OnboardingEffect {
    data object NavigateToRegisterScreen : OnboardingEffect
    data object NavigateToLoginScreen : OnboardingEffect
    data object NavigateAsGuest : OnboardingEffect
}