package com.example.decorato.presentation.viewModel.home.detailsScreen

data class DesignDetailsUiState(
    val designId: String = "",
    val designTitle: String = "",
    val description: String = "",
    val imageUrl: String = "",
    val category: String = "",
    val isLoading: Boolean = false
)