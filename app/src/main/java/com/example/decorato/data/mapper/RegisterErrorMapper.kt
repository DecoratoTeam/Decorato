package com.example.decorato.data.mapper

import com.example.decorato.domain.exceptions.*

object RegisterErrorMapper {

    fun mapErrorCodeToException(errorCode: Int?): DecoratoException {
        return when (errorCode) {
            100 -> EmailAlreadyExistsException()
            101 -> InvalidCredentialsException()
            102 -> WeakPasswordException()
            103 -> AccountDisabledException()
            104 -> VerificationRequiredException()
            105 -> AccessDeniedException()
            106 -> AccessRestrictedException()
            500, 502, 503, 504 -> ServerErrorException()
            else -> UnknownException()
        }
    }

    fun mapMessageToException(message: String): DecoratoException {
        return when {
            // Email Errors
            message.contains("email", ignoreCase = true) &&
                    (message.contains("exist", ignoreCase = true) ||
                            message.contains("already", ignoreCase = true) ||
                            message.contains("registered", ignoreCase = true)) ->
                EmailAlreadyExistsException()

            // Password Errors
            message.contains("password", ignoreCase = true) &&
                    message.contains("weak", ignoreCase = true) ->
                WeakPasswordException()

            // Account Status Errors
            message.contains("disabled", ignoreCase = true) ->
                AccountDisabledException()

            message.contains("verification", ignoreCase = true) ||
                    message.contains("verify", ignoreCase = true) ->
                VerificationRequiredException()

            // Access Errors
            message.contains("access", ignoreCase = true) &&
                    message.contains("denied", ignoreCase = true) ->
                AccessDeniedException()

            message.contains("access", ignoreCase = true) &&
                    message.contains("restricted", ignoreCase = true) ->
                AccessRestrictedException()

            // Invalid Credentials
            message.contains("invalid", ignoreCase = true) &&
                    (message.contains("credentials", ignoreCase = true) ||
                            message.contains("username", ignoreCase = true) ||
                            message.contains("password", ignoreCase = true)) ->
                InvalidCredentialsException()

            // Network Errors
            message.contains("network", ignoreCase = true) ||
                    message.contains("connection", ignoreCase = true) ||
                    message.contains("timeout", ignoreCase = true) ->
                NoInternetException()

            message.contains("server", ignoreCase = true) ->
                ServerErrorException()

            // Default
            else -> UnknownException()
        }
    }

    fun mapToException(message: String?, errorCode: Int?): DecoratoException {
        if (errorCode != null && errorCode != 0) {
            val exception = mapErrorCodeToException(errorCode)
            if (exception !is UnknownException) {
                return exception
            }
        }

        if (!message.isNullOrEmpty()) {
            return mapMessageToException(message)
        }

        return UnknownException()
    }
}