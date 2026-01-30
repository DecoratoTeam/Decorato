package com.example.decorato.presentation.viewModel.home

import com.example.decorato.presentation.viewModel.home.section.PopularSectionUiState
import com.example.decorato.presentation.viewModel.home.section.RecentlyWatchedSectionUiState


data class HomeUiState(
    val popularSectionUiState: PopularSectionUiState = PopularSectionUiState(),
    val recentlyWatchedSectionUiState: RecentlyWatchedSectionUiState = RecentlyWatchedSectionUiState(),
    val isLoading: Boolean = true,
    val selectedBottomNavTab: Int = 0
)