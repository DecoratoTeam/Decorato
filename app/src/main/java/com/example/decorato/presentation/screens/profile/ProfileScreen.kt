package com.example.decorato.presentation.screens.profile

import ProfileInteractionListener
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.decorato.domain.model.AppLanguage
import com.example.decorato.presentation.screens.profile.components.* // ده هيجيب الـ LogoutBottomSheet والـ LanguageBottomSheet

@Composable
fun ProfileScreen(
    state: ProfileUiState,
    listener: ProfileInteractionListener
) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
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
                    onLogoutClick = { listener.onClickLogout() }

                )
            } else {
                NotLoggedInContent(onLoginClick = { listener.onClickLogin() })
            }

            // --- 1. Language Bottom Sheet (Floating كما في الفيجما) ---
            if (state.settingsState.showLanguageDialog) {
                LanguageBottomSheet(
                    selectedLanguage = state.settingsState.selectedLanguage,
                    onLanguageSelected = { selectedLang ->
                        listener.onSelectLanguage(selectedLang)
                        listener.onConfirmLanguage() // بيقفل الشيت ويطبق التغيير
                    },
                    onDismiss = {
                        listener.onDismissLanguageDialog()
                    }
                )
            }

            // --- 2. Logout Bottom Sheet (Floating كما في الفيجما) ---
            if (state.settingsState.showLogoutDialog) {
                // تأكدي إننا سميناه LogoutBottomSheet عشان يطابق ملف الـ component الجديد
                LogoutBottomSheet(
                    onConfirm = {
                        listener.onConfirmLogout()
                    },
                    onDismiss = {
                        listener.onDismissLogoutDialog()
                    }
                )
            }
        }
    }
}