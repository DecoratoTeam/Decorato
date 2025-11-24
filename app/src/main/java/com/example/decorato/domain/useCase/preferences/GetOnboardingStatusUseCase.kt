package com.example.decorato.domain.useCase.preferences

import com.example.decorato.domain.repository.AppPreferencesRepository


class GetOnboardingStatusUseCase(
    private val preferencesRepository: AppPreferencesRepository,
) {
    suspend operator fun invoke(): Boolean {
        return preferencesRepository.isOnboardingCompleted()
    }
}
