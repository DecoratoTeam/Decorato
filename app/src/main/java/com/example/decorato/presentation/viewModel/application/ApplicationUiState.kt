package com.example.decorato.presentation.viewModel.application
import com.example.decorato.domain.model.AppLanguage // ✅ اتأكدي من الـ import ده
import com.example.decorato.domain.utils.RestrictionLevel

data class ApplicationUiState(
    val startDestination: StartDestinations? = null,
    val isDestinationLoaded: Boolean = false,
    val language: AppLanguage = AppLanguage.ENGLISH,
    val isDarkTheme: Boolean = false,
    val isThemeLoaded: Boolean = false,
    val restrictionLevel: RestrictionLevel = RestrictionLevel.GUEST
){
    enum class StartDestinations{
        HOME,
        LOGIN,
        REGISTER,
        ON_BOARDING,


    }
}
