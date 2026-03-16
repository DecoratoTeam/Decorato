package com.example.decorato.presentation.viewModel.home.detailsScreen

import com.example.decorato.presentation.viewModel.shared.BaseViewModel

sealed interface DesignDetailsEffect : BaseViewModel.BaseUiEffect {
    data object NavigateBack : DesignDetailsEffect
}