package com.example.decorato.domain.useCase.preferences

import com.example.decorato.domain.repository.AppPreferencesRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow

class ManageAppThemeUseCase @Inject constructor(
    private val preferencesRepository: AppPreferencesRepository,
) {
    suspend fun setAppTheme(isDarkTheme: Boolean) {
        preferencesRepository.setAppTheme(isDarkTheme)
    }

    fun getAppTheme(): Flow<Boolean> {
        return preferencesRepository.getAppTheme()
    }
}