package com.example.decorato.presentation.screens.register.component

import android.content.Context
import com.example.decorato.R
import com.example.decorato. presentation.viewModel.register.RegisterErrorState

fun getRegisterErrorMessage(error: String?, context: Context): String {
    return when {
        error == null -> ""
        error.contains("email", ignoreCase = true) -> context.getString(R.string.email_error)
        error.contains("password", ignoreCase = true) -> context.getString(R. string.password_error)
        error.contains("network", ignoreCase = true) -> context.getString(R.string. network_error)
        else -> error
    }
}

fun getRegisterErrorStateMessage(errorState: RegisterErrorState?, context: Context): String {
    return when (errorState) {
        // Registration Specific Errors
        is RegisterErrorState.EmailAlreadyRegisteredError ->
            context.getString(R. string.email_already_registered)
        is RegisterErrorState.WeakPasswordError ->
            context.getString(R.string.weak_password_error)
        is RegisterErrorState.VerificationRequiredError ->
            context. getString(R.string.verification_required)

        // Network Errors
        is RegisterErrorState.NoInternetError ->
            context.getString(R.string.no_internet_connection)
        is RegisterErrorState.ServerError ->
            context.getString(R.string.server_error)

        // Authentication Errors
        is RegisterErrorState.AccountDisabledError ->
            context.getString(R.string.account_disabled)
        is RegisterErrorState. InvalidCredentialsError ->
            context.getString(R.string.invalid_credentials)
        is RegisterErrorState.InvalidSessionError ->
            context.getString(R.string.invalid_session)
        is RegisterErrorState.AccessDeniedError ->
            context.getString(R.string.access_denied)
        is RegisterErrorState.AccessRestrictedError ->
            context.getString(R.string.access_restricted)

        // Generic Errors
        is RegisterErrorState.UnknownError ->
            context. getString(R.string.unknown_error)

        null -> ""
    }
}

fun getPasswordTextFieldIcon(isPasswordVisible: Boolean): Int {
    return if (isPasswordVisible) {
        R.drawable.ic_password_show
    } else {
        R.drawable.ic_password_hide
    }
}