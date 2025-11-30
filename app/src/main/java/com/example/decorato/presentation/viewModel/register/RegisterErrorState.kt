package com.example.decorato.presentation.viewModel.register

sealed interface RegisterErrorState {
    // Registration Specific Errors
    data object EmailAlreadyRegisteredError : RegisterErrorState
    data object WeakPasswordError : RegisterErrorState
    data object VerificationRequiredError : RegisterErrorState

    // Network Errors
    data object NoInternetError : RegisterErrorState
    data object ServerError : RegisterErrorState

    // Authentication Errors
    data object AccountDisabledError : RegisterErrorState
    data object InvalidCredentialsError : RegisterErrorState
    data object InvalidSessionError : RegisterErrorState
    data object AccessDeniedError : RegisterErrorState
    data object AccessRestrictedError : RegisterErrorState

    // Generic Errors
    data object UnknownError : RegisterErrorState
}