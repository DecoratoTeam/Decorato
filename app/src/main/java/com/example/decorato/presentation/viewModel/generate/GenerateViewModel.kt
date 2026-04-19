package com.example.decorato.presentation.viewModel.generate

import com.example.decorato.presentation.viewModel.shared.BaseViewModel
import com.example.decorato.presentation.viewModel.utils.dispatcher.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GenerateViewModel @Inject constructor(
    dispatcherProvider: DispatcherProvider
) : BaseViewModel<GenerateUiState, GenerateEffect>(
    initialState = GenerateUiState(),
    dispatcherProvider = dispatcherProvider
), GenerateInteractionListener {

    override fun onStartChatClick() {
        sendNewEffect(GenerateEffect.NavigateToChat)
    }
}