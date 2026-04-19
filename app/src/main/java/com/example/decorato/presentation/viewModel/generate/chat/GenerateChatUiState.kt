package com.example.decorato.presentation.viewModel.generate.chat

data class GenerateChatUiState(
    val message: String = "",
    val isSending: Boolean = false,
    val messages: List<GenerateChatMessageUiState> = emptyList(),
    val showAttachmentSheet: Boolean = false,
    val selectedAttachmentName: String? = null,
    val selectedAttachmentUri: String? = null
)