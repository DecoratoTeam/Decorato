package com.example.decorato.data.repositoryImpl

import com.example.decorato.domain.repository.AppPreferencesRepository
import com.example.decorato.domain.utils.RestrictionLevel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppPreferencesRepositoryImpl @Inject constructor() : AppPreferencesRepository {

    override suspend fun setOnboardingCompleted(isCompleted: Boolean) {
       // preferences.setOnboardingCompleted(isCompleted)
    }

    override suspend fun isOnboardingCompleted(): Boolean {
        return true
        //preferences.isOnboardingCompleted()
    }

    override fun getRestrictionLevel(): Flow<RestrictionLevel> {
        TODO("Not yet implemented")
    }

    override suspend fun setRestrictionLevel(restrictionLevel: RestrictionLevel) {
        TODO("Not yet implemented")
    }

    override suspend fun setAppLanguage(language: String) {
        TODO("Not yet implemented")
    }

    override fun getAppLanguage(): Flow<String> {
        TODO("Not yet implemented")
    }

    override suspend fun setAppTheme(isDarkTheme: Boolean) {
        TODO("Not yet implemented")
    }

    override fun getAppTheme(): Flow<Boolean> {
        TODO("Not yet implemented")
    }

}