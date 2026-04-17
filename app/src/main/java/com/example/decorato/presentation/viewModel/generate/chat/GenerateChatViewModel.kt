package com.example.decorato.presentation.viewModel.generate.chat

import com.example.decorato.presentation.viewModel.shared.BaseViewModel
import com.example.decorato.presentation.viewModel.utils.dispatcher.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GenerateChatViewModel @Inject constructor(
    dispatcherProvider: DispatcherProvider
) : BaseViewModel<GenerateChatUiState, GenerateChatEffect>(
    initialState = GenerateChatUiState(
        hintText = "Type a description like 'modern bedroom' or upload a photo to turn into a design!",
        resultText = "Designs will appear here! Click to edit or save your design."
    ),
    dispatcherProvider = dispatcherProvider
), GenerateChatInteractionListener {

    override fun onMessageChanged(value: String) {
        updateState { it.copy(message = value) }
    }

    override fun onSendClick() {
        val prompt = state.value.message.trim()
        if (prompt.isEmpty()) return

        // TODO: اربطي هنا API الحقيقي للـ chatbot / generation
        updateState {
            it.copy(
                isSending = false,
                message = "",
                resultText = "Generated design for: $prompt\n(placeholder response)"
            )
        }
    }

    override fun onMicClick() {
        // TODO: voice input
    }

    override fun onBackClick() {
        sendNewEffect(GenerateChatEffect.NavigateBack)
    }
}