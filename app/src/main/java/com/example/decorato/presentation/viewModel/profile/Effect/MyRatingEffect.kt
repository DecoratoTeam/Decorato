package com.example.decorato.presentation.viewModel.profile.Effect

sealed interface MyRatingEffect {
    object NavigateBack : MyRatingEffect
    data class NavigateToRatingDetails(val id: Int) : MyRatingEffect
}