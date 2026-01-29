package com.example.decorato.presentation.viewModel.home.section

data class RecentlyWatchedSectionUiState(
    val items: List<RecentlyWatchedItemUiState> = emptyList(),
    val isLoading: Boolean = false
)

data class RecentlyWatchedItemUiState(
    val id: String,
    val title: String,
    val location: String,
    val imageUrl: String,
    val category: String = ""
)