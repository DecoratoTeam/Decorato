package com.example.decorato.domain.useCase.preferences

import com.example.decorato.domain.repository.AppPreferencesRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

class ManageLocaleLanguageUseCase @Inject constructor(
    private val preferencesRepository: AppPreferencesRepository,
) {
    suspend fun initAppLanguage(language: String) {
        preferencesRepository.getAppLanguage().firstOrNull()
            ?.takeIf { it.isNotEmpty() }
            ?: setAppLanguage(Language.fromLanguage(language))
    }

    suspend fun setAppLanguage(language: Language) {
        preferencesRepository.setAppLanguage(language.value)
    }

    fun getAppLanguage(): Flow<Language> {
        return preferencesRepository.getAppLanguage().map {
            Language.fromLanguage(it)
        }
    }

    enum class Language(val value: String) {
        ENGLISH("en"),
        ARABIC("ar");

        companion object {
            fun fromLanguage(value: String): Language {
                return when (value) {
                    "en" -> ENGLISH
                    "ar" -> ARABIC
                    else -> ENGLISH
                }
            }
        }
    }
}