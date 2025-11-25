package com.example.decorato.presentation.components.bottomNavigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.decorato.presentation.navigation.Route
import com.example.decorato.R

enum class BottomBarItems(
    @DrawableRes val icon: Int,
    @StringRes val label: Int,
    val route: Route
) {
    HOME(
        icon = R.drawable.ic_nav_home,
        label = R.string.home,
        route = Route.Tab.Home
    ),

    Generate(
        icon = R.drawable.ic_nav_generate,
        label = R.string.home,
        route = Route.Tab.Home
    ),

    Community(
        icon = R.drawable.ic_nav_community,
        label = R.string.home,
        route = Route.Tab.Home
    ),

    PROFILE(
        icon = R.drawable.ic_nav_profile,
        label = R.string.profile,
        route = Route.Tab.Profile
    ),
}