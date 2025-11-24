package com.example.decorato.presentation.viewModel.shared.errorUiState

sealed interface ErrorUiState {
    data object NoInternetError : ErrorUiState
    data object UnknownError : ErrorUiState
}