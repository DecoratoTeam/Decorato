package com.example.decorato.presentation.viewModel.home.detailsScreen

import com.example.decorato.domain.useCase.GetDesignByIdUseCase
import com.example.decorato.presentation.viewModel.shared.BaseViewModel
import com.example.decorato.presentation.viewModel.utils.dispatcher.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DesignDetailsViewModel @Inject constructor(
    private val getDesignByIdUseCase: GetDesignByIdUseCase,
    dispatcherProvider: DispatcherProvider
) : BaseViewModel<DesignDetailsUiState, DesignDetailsEffect>(
    initialState = DesignDetailsUiState(),
    dispatcherProvider = dispatcherProvider
) {

    fun loadDesignDetails(designId: String) {
        updateState { it.copy(isLoading = true) }

        tryToExecute(
            action = { getDesignByIdUseCase(designId) },
            onSuccess = { design ->
                updateState { currentState ->
                    currentState.copy(
                        designId = design.id,
                        designTitle = design.title,
                        description = design.description,
                        imageUrl = design.imageUrl,
                        category = design.category,
                        isLoading = false
                    )
                }
            },
            onError = { _ ->
                updateState { it.copy(isLoading = false) }
                sendNewEffect(DesignDetailsEffect.NavigateBack)
            },
            withAutoUpdateErrorState = true
        )
    }

    fun onBackClick() {
        sendNewEffect(DesignDetailsEffect.NavigateBack)
    }
}