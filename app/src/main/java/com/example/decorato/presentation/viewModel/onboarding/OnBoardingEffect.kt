package com.example.decorato.presentation.viewModel.onboarding

sealed interface OnboardingEffect {
    data object NavigateToLoginScreen : OnboardingEffect
}