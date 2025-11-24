package com.example.decorato.presentation.navigation

import kotlinx.serialization.Serializable

sealed interface Route {
    sealed interface Tab : Route {
        @Serializable
        data object Home : Tab


        @Serializable
        data object Profile : Tab
    }

    @Serializable
    data object Login : Route

    @Serializable
    data object Register : Route

    @Serializable
    data object ResetPassword : Route


    @Serializable
    data object Onboarding : Route

}