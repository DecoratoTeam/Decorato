package com.example.decorato.presentation.viewModel.home.section

import androidx.annotation.DrawableRes

data class StyleSectionUiState(
    val items: List<StyleItemUiState> = emptyList(),
    val isLoading: Boolean = false
)

data class StyleItemUiState(
    val id: String,
    val name: String,
    val imageUrl: String,
    @DrawableRes val imageRes: Int = 0
)