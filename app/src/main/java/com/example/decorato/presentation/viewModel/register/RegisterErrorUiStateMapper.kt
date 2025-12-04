package com.example.decorato.presentation.viewModel.register

import com.example. decorato.domain.exceptions.AccessDeniedException
import com.example.decorato.domain.exceptions. AccessRestrictedException
import com.example.decorato.domain.exceptions. AccountDisabledException
import com.example.decorato.domain.exceptions. DecoratoException
import com. example.decorato.domain.exceptions.EmailAlreadyExistsException
import com.example.decorato. domain.exceptions.InvalidCredentialsException
import com.example.decorato.domain.exceptions.InvalidSessionException
import com.example.decorato.domain.exceptions.NoInternetException
import com.example. decorato.domain.exceptions.ServerErrorException
import com.example. decorato.domain.exceptions.UnknownException
import com.example.decorato. domain.exceptions. VerificationRequiredException
import com.example.decorato.domain. exceptions.WeakPasswordException

fun DecoratoException.toRegisterErrorUiState(): RegisterErrorState {
    return when (this) {
        // Registration Specific Exceptions
        is EmailAlreadyExistsException -> RegisterErrorState. EmailAlreadyRegisteredError
        is WeakPasswordException -> RegisterErrorState.WeakPasswordError
        is VerificationRequiredException -> RegisterErrorState.VerificationRequiredError

        // Network Exceptions
        is NoInternetException -> RegisterErrorState.NoInternetError
        is ServerErrorException -> RegisterErrorState.ServerError
        is UnknownException -> RegisterErrorState.UnknownError

        // Authentication Exceptions
        is AccountDisabledException -> RegisterErrorState.AccountDisabledError
        is InvalidCredentialsException -> RegisterErrorState.InvalidCredentialsError
        is InvalidSessionException -> RegisterErrorState.InvalidSessionError
        is AccessDeniedException -> RegisterErrorState.AccessDeniedError
        is AccessRestrictedException -> RegisterErrorState.AccessRestrictedError

        // Default
        else -> RegisterErrorState. UnknownError
    }
}