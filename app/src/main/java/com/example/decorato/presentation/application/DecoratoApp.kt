//package com.example.decorato.presentation.application
//
//import androidx.activity.compose.LocalActivity
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.material3.Scaffold
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.CompositionLocalProvider
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.staticCompositionLocalOf
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.hilt.navigation.compose.hiltViewModel
//import androidx.navigation.compose.currentBackStackEntryAsState
//import androidx.navigation.compose.rememberNavController
//import com.example.decorato.domain.utils.RestrictionLevel
//import com.example.decorato.presentation.components.bottomNavigation.BottomNavigation
//import com.example.decorato.presentation.components.snackBar.SnackBarHost
//import com.example.decorato.presentation.navigation.NavGraph
//import com.example.decorato.presentation.navigation.NavigationManager
//import com.example.decorato.presentation.navigation.Route
//import com.example.decorato.presentation.theme.DecoratoTheme
//import com.example.decorato.presentation.viewModel.ApplicationViewModel
//import com.example.decorato.presentation.viewModel.application.ApplicationUiState
//import com.example.decorato.presentation.viewModel.login.LoginEffect
//import com.example.decorato.presentation.viewModel.onboarding.OnboardingEffect
//import com.example.decorato.presentation.viewModel.register.RegisterEffect
//
// //Convert StartDestinations to Route
//fun getStartDestination(startDestination: ApplicationUiState.StartDestinations?): Route? {
//    return when (startDestination) {
//        ApplicationUiState.StartDestinations.ON_BOARDING -> Route.Onboarding
//        ApplicationUiState.StartDestinations.LOGIN -> Route.Login
//        ApplicationUiState.StartDestinations.REGISTER -> Route.Register
//        ApplicationUiState.StartDestinations.HOME -> Route.Tab.Home
//        null -> null
//    }
//}
//
//
//
//
//
//
//val LocalNavManager = staticCompositionLocalOf<NavigationManager> {
//    error("NavController not found")
//}
//
//val LocalRestrictionLevel = staticCompositionLocalOf<RestrictionLevel> {
//    error("No Restriction Level")
//}
//
//val LocalScaffoldBottomPadding = staticCompositionLocalOf { 0.dp }
//
//@Composable
//fun DecoratoApp(
//    viewModel: ApplicationViewModel = hiltViewModel()
//) {
//    val navController = rememberNavController()
//    val navigationManager = NavigationManager(navController)
//    val state by viewModel.state.collectAsState()
//    val startDestination = getStartDestination(state.startDestination) ?: return
//
//    val activity = LocalActivity.current // nullable Activity
//
//    // Handle effects from all ViewModels
//    LaunchedEffect(Unit) {
//        viewModel.effect.collect { effect ->
//            when (effect) {
//                // --- Onboarding ---
//                is OnboardingEffect.NavigateToRegisterScreen -> navigationManager.toRegister()
//                is OnboardingEffect.NavigateToLoginScreen -> navigationManager.toLogin()
//                is OnboardingEffect.NavigateAsGuest -> navigationManager.toHome(clearBackStack = true)
//
//            }
//        }
//    }
//
//
//
//    val backStackEntry by navController.currentBackStackEntryAsState()
//    val currentDestination = backStackEntry?.destination
//
//    // 1. أولاً: بنعرف المتغير ونحوله (لازم السطر ده يكون فوق الـ DecoratoTheme)
//    val appLanguage = if (state.language.name == "ARABIC") {
//        com.example.decorato.domain.model.AppLanguage.ARABIC
//    } else {
//        com.example.decorato.domain.model.AppLanguage.ENGLISH
//    }
//
//    DecoratoTheme(isDarkTheme = state.isDarkTheme,
//        language = appLanguage) {
//        CompositionLocalProvider(
//            LocalNavManager provides navigationManager,
//            LocalRestrictionLevel provides state.restrictionLevel
//        ) {
//            Scaffold(
//                bottomBar = {
//                    BottomNavigation(
//                        currentDestination = currentDestination,
//                        onNavigate = { tab, selectedTab ->
//                            navigationManager.toTab(tab, selectedTab)
//                        }
//                    )
//                }
//            ) { paddingValues ->
//                CompositionLocalProvider(
//                    LocalScaffoldBottomPadding provides paddingValues.calculateBottomPadding()
//                ) {
//                    Box(modifier = Modifier.fillMaxSize()) {
//                        NavGraph(navController = navController,
//                            startDestination = startDestination,
//                            navigationManager = navigationManager)
//                        SnackBarHost()
//                    }
//                }
//            }
//        }
//    }
//}
//
//



package com.example.decorato.presentation.application

import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.decorato.domain.utils.RestrictionLevel
import com.example.decorato.presentation.components.bottomNavigation.BottomNavigation
import com.example.decorato.presentation.components.snackBar.SnackBarHost
import com.example.decorato.presentation.navigation.NavGraph
import com.example.decorato.presentation.navigation.NavigationManager
import com.example.decorato.presentation.navigation.Route
import com.example.decorato.presentation.viewModel.ApplicationViewModel
import com.example.decorato.presentation.viewModel.application.ApplicationUiState
import com.example.decorato.presentation.viewModel.onboarding.OnboardingEffect

// تحويل الوجهات لـ Route
fun getStartDestination(startDestination: ApplicationUiState.StartDestinations?): Route? {
    return when (startDestination) {
        ApplicationUiState.StartDestinations.ON_BOARDING -> Route.Onboarding
        ApplicationUiState.StartDestinations.LOGIN -> Route.Login
        ApplicationUiState.StartDestinations.REGISTER -> Route.Register
        ApplicationUiState.StartDestinations.HOME -> Route.Tab.Home
        null -> null
    }
}

val LocalNavManager = staticCompositionLocalOf<NavigationManager> {
    error("NavController not found")
}

val LocalRestrictionLevel = staticCompositionLocalOf<RestrictionLevel> {
    error("No Restriction Level")
}

val LocalScaffoldBottomPadding = staticCompositionLocalOf { 0.dp }

@Composable
fun DecoratoApp(
    viewModel: ApplicationViewModel = hiltViewModel()
) {
    val navController = rememberNavController()
    val navigationManager = NavigationManager(navController)
    val state by viewModel.state.collectAsState()
    val startDestination = getStartDestination(state.startDestination) ?: return

    val activity = LocalActivity.current

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is OnboardingEffect.NavigateToRegisterScreen -> navigationManager.toRegister()
                is OnboardingEffect.NavigateToLoginScreen -> navigationManager.toLogin()
                is OnboardingEffect.NavigateAsGuest -> navigationManager.toHome(clearBackStack = true)
            }
        }
    }

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = backStackEntry?.destination

    // "الزتونة": شيلنا الـ DecoratoTheme من هنا خالص لأن الـ MainActivity هي اللي مسؤولة عنها
    CompositionLocalProvider(
        LocalNavManager provides navigationManager,
        LocalRestrictionLevel provides state.restrictionLevel
    ) {
        Scaffold(
            bottomBar = {
                BottomNavigation(
                    currentDestination = currentDestination,
                    onNavigate = { tab, selectedTab ->
                        navigationManager.toTab(tab, selectedTab)
                    }
                )
            }
        ) { paddingValues ->
            CompositionLocalProvider(
                LocalScaffoldBottomPadding provides paddingValues.calculateBottomPadding()
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    NavGraph(
                        navController = navController,
                        startDestination = startDestination,
                        navigationManager = navigationManager
                    )
                    SnackBarHost()
                }
            }
        }
    }
}