package com.example.decorato.domain.exceptions

open class DecoratoException : Exception()

open class NetworkException : DecoratoException()

class UnknownException : NetworkException()

class NoInternetException : NetworkException()

class ServerErrorException : NetworkException()

open class AuthenticationException : NetworkException()

class AccountDisabledException : AuthenticationException()

class InvalidCredentialsException : AuthenticationException()

class VerificationRequiredException : AuthenticationException()

class InvalidSessionException : AuthenticationException()

class AccessDeniedException : AuthenticationException()

class AccessRestrictedException : AuthenticationException()

class EmailAlreadyExistsException : AuthenticationException()

class WeakPasswordException : AuthenticationException()
