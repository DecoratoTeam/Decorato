package com.example.decorato.presentation.viewModel.login

import com.example.decorato.domain.exceptions.*

fun DecoratoException.toLoginErrorUiState(): LoginErrorState {
    return when (this) {
        is NoInternetException -> LoginErrorState.NoInternet
        is ServerErrorException -> LoginErrorState.ServerError
        is UnknownException -> LoginErrorState.UnknownError
        is AccountDisabledException -> LoginErrorState.AccountDisabled
        is InvalidCredentialsException -> LoginErrorState.InvalidCredentials
        is InvalidSessionException -> LoginErrorState.InvalidSession
        else -> LoginErrorState.UnknownError
    }
}
