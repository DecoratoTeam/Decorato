package com.example.decorato.presentation.viewModel.generate

sealed interface GenerateEffect {
    data object NavigateToChat : GenerateEffect
}