package com.example.decorato.presentation.viewModel.home

import com.example.decorato.presentation.viewModel.home.section.PopularSectionUiState
import com.example.decorato.presentation.viewModel.home.section.RecentlyWatchedSectionUiState
import com.example.decorato.presentation.viewModel.home.section.StyleSectionUiState


data class HomeUiState(
    val popularSectionUiState: PopularSectionUiState = PopularSectionUiState(),
    val recentlyWatchedSectionUiState: RecentlyWatchedSectionUiState = RecentlyWatchedSectionUiState(),
    val styleSectionUiState: StyleSectionUiState = StyleSectionUiState(),
    val isLoading: Boolean = true,
    val selectedBottomNavTab: Int = 0
)