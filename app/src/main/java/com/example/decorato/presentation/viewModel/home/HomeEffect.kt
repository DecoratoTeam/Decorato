package com.example.decorato.presentation.viewModel.home

import com.example.decorato.presentation.viewModel.shared.BaseViewModel

sealed interface HomeEffect : BaseViewModel.BaseUiEffect {
    data class NavigateToDesignDetails(val designId: String) : HomeEffect
    data object NavigateToAllRecentlyWatched : HomeEffect
    data class NavigateToTab(val tabIndex: Int) : HomeEffect
    data object ShowErrorMessage : HomeEffect
    data class ShowErrorSnackBar(val message: String) : HomeEffect
}