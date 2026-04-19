package com.example.decorato.presentation.viewModel.generate.chat

import androidx.lifecycle.viewModelScope
import com.example.decorato.presentation.viewModel.shared.BaseViewModel
import com.example.decorato.presentation.viewModel.utils.dispatcher.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GenerateChatViewModel @Inject constructor(
    dispatcherProvider: DispatcherProvider
) : BaseViewModel<GenerateChatUiState, GenerateChatEffect>(
    initialState = GenerateChatUiState(),
    dispatcherProvider = dispatcherProvider
), GenerateChatInteractionListener {

    override fun onMessageChanged(value: String) {
        updateState { it.copy(message = value) }
    }

    override fun onSendClick() {
        val prompt = state.value.message.trim()
        if (prompt.isBlank() || state.value.isSending) return

        val userMessage = GenerateChatMessageUiState(
            id = System.currentTimeMillis(),
            type = GenerateChatMessageType.USER_TEXT,
            text = prompt
        )

        updateState {
            it.copy(
                message = "",
                isSending = true,
                messages = it.messages + userMessage
            )
        }

        viewModelScope.launch {
            delay(700)

            val botText = GenerateChatMessageUiState(
                id = System.currentTimeMillis() + 1,
                type = GenerateChatMessageType.BOT_TEXT,
                text = buildReply(prompt)
            )

            val botImage = GenerateChatMessageUiState(
                id = System.currentTimeMillis() + 2,
                type = GenerateChatMessageType.BOT_IMAGE,
                imageUrl = pickLocalImage(prompt)
            )

            updateState {
                it.copy(
                    isSending = false,
                    messages = it.messages + botText + botImage
                )
            }
        }
    }

    private fun buildReply(prompt: String): String {
        return "Hello! I understand your request perfectly. I will generate a design for \"$prompt\" with suitable colors and style. Generating..."
    }

    private fun pickLocalImage(prompt: String): String {
        val p = prompt.lowercase()
        return when {
            "bedroom" in p -> "https://images.unsplash.com/photo-1616594039964-3d5d6e9f6f8f?auto=format&fit=crop&w=900&q=80"
            "kitchen" in p -> "https://images.unsplash.com/photo-1556911220-bff31c812dba?auto=format&fit=crop&w=900&q=80"
            "living" in p -> "https://images.unsplash.com/photo-1505693416388-ac5ce068fe85?auto=format&fit=crop&w=900&q=80"
            else -> "https://images.unsplash.com/photo-1616046229478-9901c5536a45?auto=format&fit=crop&w=900&q=80"
        }
    }

    override fun onMicClick() {
        updateState { it.copy(showAttachmentSheet = true) }
    }

    override fun onDismissAttachmentSheet() {
        updateState { it.copy(showAttachmentSheet = false) }
    }

    override fun onTakePhotographClick() {
        updateState { it.copy(showAttachmentSheet = false) }
        sendNewEffect(GenerateChatEffect.OpenCamera)
    }

    fun onCameraImageCaptured(uri: String) {
        updateState {
            it.copy(
                selectedAttachmentName = "Image.jpg",
                selectedAttachmentUri = uri
            )
        }
    }

    override fun onRemoveAttachmentClick() {
        updateState {
            it.copy(
                selectedAttachmentName = null,
                selectedAttachmentUri = null
            )
        }
    }

    override fun onAddFromAlbumClick() {
        updateState { it.copy(showAttachmentSheet = false) }
        // TODO: open gallery
    }

    override fun onBackClick() {
        sendNewEffect(GenerateChatEffect.NavigateBack)
    }
}