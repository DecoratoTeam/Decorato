package com.example.decorato.domain.useCase.authentication

import com.example.decorato.domain.repository.AuthenticationRepository
import com.example.decorato.domain.utils.SessionType


class LoginAsGuestUseCase (
    private val authenticationRepository: AuthenticationRepository,
) {
    suspend operator fun invoke(){
        authenticationRepository.setSessionType(SessionType.GUEST)
    }
}