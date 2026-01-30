package com.example.decorato.presentation.viewModel.home.section

data class PopularSectionUiState(
    val items: List<PopularItemUiState> = emptyList(),
    val isLoading: Boolean = false
)

data class PopularItemUiState(
    val id: String,
    val title: String,
    val description: String,
    val imageUrl: String,
    val category: String = ""
)