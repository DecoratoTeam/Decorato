package com.example.decorato.presentation.viewModel.application

import androidx.lifecycle.viewModelScope
import com.example.decorato.domain.useCase.authentication.GetsSessionTypeUseCase
import com.example.decorato.presentation.viewModel.utils.dispatcher.DispatcherProvider
import com.example.decorato.domain.useCase.preferences.GetOnboardingStatusUseCase
import com.example.decorato.domain.utils.SessionType
import com.example.decorato.presentation.viewModel.shared.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ApplicationViewModel @Inject constructor(
    private val dispatcherProvider: DispatcherProvider,
    private val getOnboardingStatusUseCase: GetOnboardingStatusUseCase,
    private val getsSessionType: GetsSessionTypeUseCase,
) : BaseViewModel<ApplicationUiState, Unit>(ApplicationUiState(), dispatcherProvider) {

    init {
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



    private suspend fun setNonOnboardingStartDestination(){
        val sessionType = getsSessionType()
        val destination = when (sessionType) {
            SessionType.LOGGED_IN -> ApplicationUiState.StartDestinations.HOME
            SessionType.GUEST -> ApplicationUiState.StartDestinations.HOME
            else  -> ApplicationUiState.StartDestinations.REGISTER
        }
        updateState {
            it.copy(
                startDestination = destination,
                isDestinationLoaded = true
            )
        }
    }

}