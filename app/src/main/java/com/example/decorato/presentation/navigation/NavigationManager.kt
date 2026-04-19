package com.example.decorato.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.State
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Immutable
class NavigationManager(
    private val navController: NavController,
) {

    fun navigateUp() {
        navController.navigateUp()
    }

    fun navigateUpWithFlag(flagName: String, value: Boolean) {
        navController.previousBackStackEntry
            ?.savedStateHandle
            ?.set(flagName, value)

        this.navigateUp()
    }

    // --- Tabs ---
    fun toTab(tab: Route, selectedDestination: Route) {
        if (selectedDestination != tab) {
            navController.navigate(tab) {
                navController.popBackStack(
                    route = Route.Tab.Home,
                    inclusive = true,
                    saveState = true
                )

                launchSingleTop = true
                restoreState = true
            }
        }
    }



    fun toHome(clearBackStack: Boolean = false) {
        navController.navigate(Route.Tab.Home) {
            if (clearBackStack) popUpTo(0)
        }
    }

    fun toDesignDetails(designId: String) {
        navController.navigate("design_details/$designId")
    }

    fun toAllRecentlyWatched() {
        navController.navigate("recently_watched")
    }

    fun toStyleDetails(styleId: String) {
        navController.navigate(Route.StyleDetails(styleId))
    }

    fun navigateBack() {
        navController.navigateUp()
    }

    fun popBackStack() {
        navController.popBackStack()
    }

    // --- Auth & Onboarding ---
    fun toLogin(clearBackStack: Boolean = true) {
        navController.navigate(Route.Login) {
            if (clearBackStack) popUpTo(0)
        }
    }
    // جوه NavigationManager.kt
    fun toProfile() {
        navController.navigate(Route.Tab.Profile)
    }
    fun toEditProfile() {navController.navigate("edit_profile_route")}
    fun toMyPosts() { navController.navigate("my_posts_route") }
    fun toMyRating() { navController.navigate("my_rating_route") }

    fun toRegister() {
        navController.navigate(Route.Register)
    }

    fun toResetPassword() {
        navController.navigate(Route.ResetPassword)
    }

    fun toCreatePost() {
        navController.navigate(Route.CreatePost)
    }



    @Composable
    fun getCurrentBackStackEntryAsState(): State<NavBackStackEntry?> {
        return navController.currentBackStackEntryAsState()
    }
}
