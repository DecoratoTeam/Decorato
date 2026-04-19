package com.example.decorato.presentation.viewModel.generate.chat

enum class GenerateChatMessageType {
    USER_TEXT,
    BOT_TEXT,
    BOT_IMAGE,
    USER_IMAGE
}

data class GenerateChatMessageUiState(
    val id: Long,
    val type: GenerateChatMessageType,
    val text: String = "",
    val imageUrl: String = "",
    val localImageUri: String = "",
    val fileName: String = ""
)