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
        listenToAppSettings()
        setStartDestination()
    }

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

    fun initAppSettings(locale: Locale) {
        viewModelScope.launch(dispatcherProvider.IO) {
            manageLocaleLanguageUseCase.initAppLanguage(locale.language)
        }
    }

    private suspend fun setNonOnboardingStartDestination() {
        val sessionType = getsSessionTypeUseCase()
        val destination = when (sessionType) {
            SessionType.LOGGED_IN -> ApplicationUiState.StartDestinations.HOME
            SessionType.GUEST -> ApplicationUiState.StartDestinations.HOME
            null -> ApplicationUiState.StartDestinations.LOGIN
        }
        updateState {
            it.copy(
                startDestination = destination,
                isDestinationLoaded = true
            )
        }
    }

    private fun listenToAppSettings() {
        viewModelScope.launch(dispatcherProvider.IO) {
            manageAppThemeUseCase.getAppTheme().collect { isDarkTheme ->

                updateState { state ->
                    state.copy(
                        isDarkTheme = isDarkTheme,
                        isThemeLoaded = true
                    )
                }
            }
        }


    }

}