package com.example.decorato.presentation.viewModel.login

sealed interface LoginErrorState {
    data object InvalidCredentials : LoginErrorState
    data object NoInternet : LoginErrorState
    data object ServerError : LoginErrorState
    data object AccountDisabled : LoginErrorState
    data object InvalidSession : LoginErrorState
    data object UnknownError : LoginErrorState
}
