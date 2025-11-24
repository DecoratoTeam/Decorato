package com.example.decorato.presentation.viewModel

import com.example.decorato.domain.useCase.preferences.ManageLocaleLanguageUseCase
import com.example.decorato.domain.utils.RestrictionLevel


data class ApplicationUiState(
    val startDestination: StartDestinations? = null,
    val restrictionLevel: RestrictionLevel = RestrictionLevel.STRICT,
    val isDarkTheme: Boolean = true,
    val isThemeLoaded: Boolean = false,
    val isDestinationLoaded: Boolean = false,
    val language: ManageLocaleLanguageUseCase.Language = ManageLocaleLanguageUseCase.Language.ENGLISH

){
    enum class StartDestinations{
        HOME,
        LOGIN,
        ON_BOARDING
    }
}
