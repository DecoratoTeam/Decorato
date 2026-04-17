package com.example.decorato.presentation.viewModel.generate.chat

data class GenerateChatUiState(
    val message: String = "",
    val isSending: Boolean = false,
    val hintText: String = "",
    val resultText: String = ""
)