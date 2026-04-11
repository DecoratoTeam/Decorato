package com.example.decorato.presentation.viewModel

import com.example.decorato.domain.useCase.preferences.ManageLocaleLanguageUseCase
import com.example.decorato.domain.utils.RestrictionLevel


data class ApplicationUiState(
    val startDestination: StartDestinations? = null,
    val restrictionLevel: RestrictionLevel = RestrictionLevel.STRICT,
    val isDarkTheme: Boolean = false,
    val isThemeLoaded: Boolean = false,
    val isDestinationLoaded: Boolean = false,
    val language: com.example.decorato.domain.model.AppLanguage = com.example.decorato.domain.model.AppLanguage.ENGLISH
){
    enum class StartDestinations{
        HOME,
        REGISTER,
        ON_BOARDING,
        LOGIN
    }
}
