package com.example.decorato.domain.useCase.authentication

import com.example.decorato.domain.repository.AuthenticationRepository
import com.example.decorato.domain.utils.SessionType


class GetsSessionType (
    private val authenticationRepository: AuthenticationRepository
) {
    suspend operator fun invoke(): SessionType? {
        return authenticationRepository.getSessionType()
    }
}