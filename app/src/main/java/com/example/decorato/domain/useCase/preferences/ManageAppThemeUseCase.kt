package com.example.decorato.domain.useCase.preferences

import com.example.decorato.domain.repository.AppPreferencesRepository
import kotlinx.coroutines.flow.Flow

class ManageAppThemeUseCase(
    private val preferencesRepository: AppPreferencesRepository,
) {
    suspend fun setAppTheme(isDarkTheme: Boolean) {
        preferencesRepository.setAppTheme(isDarkTheme)
    }

    fun getAppTheme(): Flow<Boolean> {
        return preferencesRepository.getAppTheme()
    }
}