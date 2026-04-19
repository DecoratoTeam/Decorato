package com.example.decorato.presentation.viewModel

import androidx.lifecycle.viewModelScope
import com.example.decorato.domain.useCase.preferences.ManageLocaleLanguageUseCase
import com.example.decorato.domain.useCase.preferences.ManageAppThemeUseCase
import com.example.decorato.domain.useCase.authentication.GetsSessionTypeUseCase
import com.example.decorato.domain.useCase.preferences.GetOnboardingStatusUseCase
import com.example.decorato.domain.utils.SessionType
import com.example.decorato.presentation.viewModel.shared.BaseViewModel
import com.example.decorato.presentation.viewModel.utils.dispatcher.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class ApplicationViewModel @Inject constructor(
    private val dispatcherProvider: DispatcherProvider,
    private val getOnboardingStatusUseCase: GetOnboardingStatusUseCase,
    private val getsSessionTypeUseCase: GetsSessionTypeUseCase,
    private val manageAppThemeUseCase: ManageAppThemeUseCase,
    private val manageLocaleLanguageUseCase: ManageLocaleLanguageUseCase,
) : BaseViewModel<ApplicationUiState, Unit>(ApplicationUiState(), dispatcherProvider) {

    init {
        // "الزيتونة": ربط كافة الإعدادات عند تشغيل التطبيق
        listenToAppSettings()
        listenToLanguageSettings()
        setStartDestination()
    }

    // --- إدارة الوجهة الافتتاحية (Navigation) ---

    private fun setStartDestination() {
        viewModelScope.launch(dispatcherProvider.IO) {
            val isOnboardingCompleted = getOnboardingStatusUseCase()

            if (!isOnboardingCompleted) {
                updateState {
                    it.copy(
                        startDestination = ApplicationUiState.StartDestinations.ON_BOARDING,
                        isDestinationLoaded = true
                    )
                }
            } else {
                setNonOnboardingStartDestination()
            }
        }
    }

    private suspend fun setNonOnboardingStartDestination() {
        val sessionType = getsSessionTypeUseCase()
        val destination = when (sessionType) {
            SessionType.USER,
            SessionType.LOGGED_IN,
            SessionType.GUEST -> ApplicationUiState.StartDestinations.HOME
            else -> ApplicationUiState.StartDestinations.REGISTER
        }
        updateState {
            it.copy(
                startDestination = destination,
                isDestinationLoaded = true
            )
        }
    }

    // --- إدارة اللغة (Language) ---

    fun initAppSettings(locale: Locale) {
        viewModelScope.launch(dispatcherProvider.IO) {
            manageLocaleLanguageUseCase.initAppLanguage(locale.language)
        }
    }

    // --- إدارة اللغة ---
    fun onChangeLanguage(language: com.example.decorato.domain.model.AppLanguage) {
        android.util.Log.d("DECORATO_TEST", "وصلت إشارة تغيير اللغة: $language")
        updateState { it.copy(language = language) }
        viewModelScope.launch(dispatcherProvider.IO) {
            val useCaseLang = if (language == com.example.decorato.domain.model.AppLanguage.ARABIC) {
                ManageLocaleLanguageUseCase.Language.ARABIC
            } else {
                ManageLocaleLanguageUseCase.Language.ENGLISH
            }
            manageLocaleLanguageUseCase.setAppLanguage(useCaseLang)
        }
    }

    // --- إدارة الثيم ---
    fun onChangeTheme(isDark: Boolean) {
        android.util.Log.d("DECORATO_TEST", "وصلت إشارة الدارك مود: $isDark")
        updateState { it.copy(isDarkTheme = isDark) }
        viewModelScope.launch(dispatcherProvider.IO) {
            manageAppThemeUseCase.setAppTheme(isDark)
        }
    }

    // 1. حل مشكلة الـ Operator في اللغة
    private fun listenToLanguageSettings() {
        viewModelScope.launch(dispatcherProvider.IO) {
            manageLocaleLanguageUseCase.getAppLanguage().collect { languageEnum ->
                // الزيتونة: languageEnum هنا نوعه ManageLocaleLanguageUseCase.Language
                val currentLang = if (languageEnum == ManageLocaleLanguageUseCase.Language.ARABIC) {
                    com.example.decorato.domain.model.AppLanguage.ARABIC
                } else {
                    com.example.decorato.domain.model.AppLanguage.ENGLISH
                }
                updateState { it.copy(language = currentLang) }
            }
        }
    }


    private fun listenToAppSettings() {
        viewModelScope.launch(dispatcherProvider.IO) {
            manageAppThemeUseCase.getAppTheme().collect { isDarkTheme ->
                updateState {
                    it.copy(
                        isDarkTheme = false,
                        isThemeLoaded = true
                    )
                }
            }
        }
    }
}