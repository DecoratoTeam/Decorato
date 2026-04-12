package com.example.decorato.presentation.viewModel.home.detailsScreen

import com.example.decorato.presentation.viewModel.shared.BaseViewModel

sealed interface StyleDetailsEffect : BaseViewModel.BaseUiEffect {
    data class NavigateToDesignDetails(val designId: String) : StyleDetailsEffect
    data object NavigateBack : StyleDetailsEffect
}