package com.example.decorato.presentation.viewModel.home.detailsScreen

import com.example.decorato.presentation.viewModel.home.section.RoomDesignItemUiState

data class StyleDetailsUiState(
    val styleName: String = "",
    val designs: List<RoomDesignItemUiState> = emptyList(),
    val isLoading: Boolean = false
)