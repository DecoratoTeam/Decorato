package com.example.decorato.presentation.viewModel.profile.UiState
data class RatingItemUiState(
    val id: Int = 0,
    val title: String = "",
    val location: String = "",
    val rating: Double = 0.0,
    val imageUrl: String = ""
)


data class MyRatingUiState(
    val ratings: List<RatingItemUiState> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
