package com.example.decorato.presentation.viewModel.application
import com.example.decorato.domain.model.AppLanguage // ✅ اتأكدي من الـ import ده
import com.example.decorato.domain.utils.RestrictionLevel

data class ApplicationUiState(
    val startDestination: StartDestinations? = null,
    val isDestinationLoaded: Boolean = false,
    val language: AppLanguage = AppLanguage.ENGLISH, // ✅ ضيفي السطر ده هنا
    val isDarkTheme: Boolean = false, // ✅ الضربة القاضية: ضيفي السطر ده هنا
    val isThemeLoaded: Boolean = false, // ✅ وضيفي ده كمان عشان الـ ViewModel بيستخدمه
    val restrictionLevel: RestrictionLevel = RestrictionLevel.GUEST // ✅ اتأكدي إن RestrictionLevel جواه GUEST
){
    enum class StartDestinations{
        HOME,
        LOGIN,
        REGISTER,
        ON_BOARDING,


    }
}
