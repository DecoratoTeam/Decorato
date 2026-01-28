package com.example.decorato.presentation.screens.login.component

import android.content.Context
import com.example.decorato.R
import com.example.decorato.presentation.viewModel.login.LoginErrorState

fun getLoginErrorStateMessage(errorState: LoginErrorState?, context: Context): String {
    return when (errorState) {
        LoginErrorState.InvalidCredentials -> context.getString(R.string.invalid_credentials)
        LoginErrorState.NoInternet -> context.getString(R.string.no_internet_connection)
        LoginErrorState.ServerError -> context.getString(R.string.server_error)
        LoginErrorState.AccountDisabled -> context.getString(R.string.account_disabled)
        LoginErrorState.InvalidSession -> context.getString(R.string.invalid_session)
        LoginErrorState.UnknownError -> context.getString(R.string.unknown_error)
        null -> ""
    }
}
