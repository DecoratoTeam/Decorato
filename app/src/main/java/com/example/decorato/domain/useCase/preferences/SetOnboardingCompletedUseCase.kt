package com.example.decorato.domain.useCase.preferences

import com.example.decorato.domain.repository.AppPreferencesRepository
import javax.inject.Inject

class SetOnboardingCompletedUseCase @Inject constructor(
    private val preferencesRepository: AppPreferencesRepository,
) {
    suspend operator fun invoke(isCompleted: Boolean) {
        preferencesRepository.setOnboardingCompleted(isCompleted)
    }
}