package com.example.decorato.domain.useCase.preferences


import com.example.decorato.domain.repository.AppPreferencesRepository
import com.example.decorato.domain.utils.RestrictionLevel
import kotlinx.coroutines.flow.Flow

class ManageRestrictionLevelUseCase(
    private val preferencesRepository: AppPreferencesRepository
) {
    suspend fun setRestrictionLevel(restrictionLevel: RestrictionLevel){
        preferencesRepository.setRestrictionLevel(restrictionLevel)
    }

    fun getRestrictionLevel(): Flow<RestrictionLevel> {
        return preferencesRepository.getRestrictionLevel()
    }
}