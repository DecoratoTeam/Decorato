package com.example.decorato.domain.useCase.authentication

import com.example.decorato.domain.entity.User
import com.example.decorato.domain.repository.AuthenticationRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) {
    suspend operator fun invoke(
        email: String,
        password: String
    ): Result<User> {

        if (email.isBlank()) {
            return Result.failure(Exception("Email is required"))
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return Result.failure(Exception("Invalid email format"))
        }

        if (password.isBlank()) {
            return Result.failure(Exception("Password is required"))
        }

        return authenticationRepository.login(
            email = email,
            password = password
        )
    }
}
