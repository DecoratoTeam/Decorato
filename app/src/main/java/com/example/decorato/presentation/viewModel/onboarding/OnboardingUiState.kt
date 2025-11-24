package com.example.decorato.presentation.viewModel.onboarding

data class OnboardingUiState(
    val currentPageIndex: Int = 0,
    val totalPages: Int = 3,
    val isLastPage: Boolean = false
)