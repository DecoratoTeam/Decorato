package com.example.decorato.domain.useCase.authentication

import com.example.decorato.domain.entity.User
import com.example. decorato.domain.repository.AuthenticationRepository

class RegisterUseCase(
    private val authenticationRepository: AuthenticationRepository
) {
    suspend operator fun invoke(
        name: String,
        email: String,
        password: String
    ): Result<User> {
        if (name. isBlank()) {
            return Result.failure(Exception("Name is required"))
        }

        if (email.isBlank()) {
            return Result.failure(Exception("Email is required"))
        }

        if (! android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return Result.failure(Exception("Invalid email format"))
        }

        if (password.length < 6) {
            return Result.failure(Exception("Password must be at least 6 characters"))
        }

        return authenticationRepository.register(
            name = name,
            email = email,
            password = password
        )
    }
}