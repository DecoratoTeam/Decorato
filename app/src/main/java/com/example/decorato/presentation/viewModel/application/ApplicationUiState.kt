package com.example.decorato.presentation.viewModel.application

data class ApplicationUiState(
    val startDestination: StartDestinations? = null,
    val isDestinationLoaded: Boolean = false,

){
    enum class StartDestinations{
        HOME,
        LOGIN,
        ON_BOARDING
    }
}
