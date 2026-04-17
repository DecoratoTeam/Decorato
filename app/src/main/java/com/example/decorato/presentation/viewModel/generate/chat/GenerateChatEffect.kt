package com.example.decorato.presentation.viewModel.generate.chat

sealed interface GenerateChatEffect {
    data object NavigateBack : GenerateChatEffect
}