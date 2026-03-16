package com.example.decorato.presentation.viewModel.home.detailsScreen

import com.example.decorato.domain.useCase.GetStylesUseCase
import com.example.decorato.domain.useCase.GetDesignsByStyleUseCase
import com.example.decorato.presentation.viewModel.home.section.RoomDesignItemUiState
import com.example.decorato.presentation.viewModel.shared.BaseViewModel
import com.example.decorato.presentation.viewModel.utils.dispatcher.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StyleDetailsViewModel @Inject constructor(
    private val getStylesUseCase: GetStylesUseCase,
    private val getDesignsByStyleUseCase: GetDesignsByStyleUseCase,
    dispatcherProvider: DispatcherProvider
) : BaseViewModel<StyleDetailsUiState, StyleDetailsEffect>(
    initialState = StyleDetailsUiState(),
    dispatcherProvider = dispatcherProvider
) {

    fun loadStyleDesigns(styleId: String) {
        updateState { it.copy(isLoading = true) }

        tryToExecute(
            action = { getStylesUseCase() },
            onSuccess = { styles ->
                val styleName = styles.find { it.id == styleId }?.name ?: "Style"
                updateState { it.copy(styleName = styleName) }
                loadDesignsByStyle(styleId)
            },
            onError = { _ ->
                updateState { it.copy(isLoading = false) }
                sendNewEffect(StyleDetailsEffect.NavigateBack)
            },
            withAutoUpdateErrorState = true
        )
    }

    private fun loadDesignsByStyle(styleId: String) {
        tryToExecute(
            action = { getDesignsByStyleUseCase(styleId) },
            onSuccess = { designs ->
                val designItems = designs.map { design ->
                    RoomDesignItemUiState(
                        id = design.id,
                        title = design.title,
                        imageUrl = design.imageUrl,
                        category = design.category
                    )
                }
                updateState { currentState ->
                    currentState.copy(
                        designs = designItems,
                        isLoading = false
                    )
                }
            },
            onError = { _ ->
                updateState { it.copy(isLoading = false) }
            },
            withAutoUpdateErrorState = true
        )
    }

    fun onBackClick() {
        sendNewEffect(StyleDetailsEffect.NavigateBack)
    }

    fun onDesignClick(designId: String) {
        sendNewEffect(StyleDetailsEffect.NavigateToDesignDetails(designId))
    }
}