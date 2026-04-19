package com.example.decorato.presentation.navigation

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object CreatePost : Route
    sealed interface Tab : Route {
        @Serializable
        data object Home : Tab
        @Serializable
        data object Generate : Tab
        @Serializable
        data object Community : Tab

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

    @Serializable
    data object RecentlyWatched : Route

    @Serializable
    data class StyleDetails(val styleId: String) : Route

    @Serializable
    data class DesignDetails(val designId: String) : Route

    @Serializable
    data object GenerateChat : Route
}