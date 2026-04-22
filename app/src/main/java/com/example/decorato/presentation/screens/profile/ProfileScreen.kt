package com.example.decorato.presentation.screens.profile

import ProfileInteractionListener
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.decorato.domain.model.AppLanguage
import com.example.decorato.presentation.screens.profile.components.*
import com.example.decorato.presentation.viewModel.profile.UiState.ProfileUiState

@Composable
fun ProfileScreen(
    state: ProfileUiState,
    listener: ProfileInteractionListener
) {
    val context = androidx.compose.ui.platform.LocalContext.current

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            if (state.isLoggedIN) {
                LoggedInContent(
                    userName = state.userInfo.userName,
                    userImage = state.userInfo.userImage,
                    postCount = state.userInfo.userPostCount,
                    rating = state.userInfo.userRating,
                    isDarkMode = state.settingsState.isDarkTheme,
                    currentLanguage = if (state.settingsState.selectedLanguage == AppLanguage.ARABIC) "العربية" else "English",
                    onEditClick = { listener.onClickEditProfile() },
                    onPostsClick = { listener.onClickMyPosts() },
                    onRatingClick = { listener.onClickMyRating() },
                    onDarkModeChange = { listener.onToggleDarkMode(it) },
                    onLanguageClick = { listener.onClickLanguage() },
                    onLogoutClick = { listener.onClickLogout() },
                    modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding())
                )
            } else {
                NotLoggedInContent(
                    onLoginClick = { listener.onClickLogin() },
                    modifier = Modifier.padding(paddingValues)
                )
            }

            // --- 1. Language Bottom Sheet ---
            if (state.settingsState.showLanguageDialog) {
                LanguageBottomSheet(
                    selectedLanguage = state.settingsState.selectedLanguage,
                    onLanguageSelected = { selectedLang ->
                        listener.onSelectLanguage(selectedLang)
                        listener.onConfirmLanguage()
                        (context as? android.app.Activity)?.recreate()
                    },
                    onDismiss = {
                        listener.onDismissLanguageDialog()
                    }
                )
            }

            // --- 2. Logout Bottom Sheet ---
            if (state.settingsState.showLogoutDialog) {
                LogoutBottomSheet(
                    onConfirm = { listener.onConfirmLogout() },
                    onDismiss = { listener.onDismissLogoutDialog() }
                )
            }
        }
    }
}