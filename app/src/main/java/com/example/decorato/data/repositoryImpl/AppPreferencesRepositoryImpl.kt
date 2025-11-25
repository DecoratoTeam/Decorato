package com.example.decorato.data.repositoryImpl

import com.example.decorato.data.local.datastore.AppLocalPreferences
import com.example.decorato.data.mapper.stringToRestrictionLevelEntity
import com.example.decorato.data.mapper.toLocalDto
import com.example.decorato.domain.repository.AppPreferencesRepository
import com.example.decorato.domain.utils.RestrictionLevel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppPreferencesRepositoryImpl @Inject constructor(
    private val preferences: AppLocalPreferences,
) : AppPreferencesRepository {

    override suspend fun setOnboardingCompleted(isCompleted: Boolean) {
        preferences.setOnboardingCompleted(isCompleted)
    }

    override suspend fun isOnboardingCompleted(): Boolean {
        return preferences.isOnboardingCompleted()
    }

    override fun getRestrictionLevel(): Flow<RestrictionLevel> {
        return stringToRestrictionLevelEntity(preferences.getRestrictionLevel())
    }

    override suspend fun setRestrictionLevel(restrictionLevel: RestrictionLevel) {
        preferences.setRestrictionLevel(restrictionLevel.toLocalDto())
    }

    override fun getAppLanguage(): Flow<String> = preferences.getAppLanguage()

    override suspend fun setAppLanguage(language: String) {
        preferences.setAppLanguage(language)
    }

    override fun getAppTheme(): Flow<Boolean> {
        return preferences.getAppTheme()
    }

    override suspend fun setAppTheme(isDarkTheme: Boolean) {
        preferences.setAppTheme(isDarkTheme)
    }


}