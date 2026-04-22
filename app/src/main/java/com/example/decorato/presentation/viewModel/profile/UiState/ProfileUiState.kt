package com.example.decorato.presentation.viewModel.profile.UiState

import com.example.decorato.domain.model.AppLanguage

data class ProfileUiState(
    val isLoading: Boolean = false,
    val isLoggedIN: Boolean = false,
    val settingsState: SettingState = SettingState(),
    val userInfo: UserInfoUiState = UserInfoUiState(),
)

data class UserInfoUiState(
    val userName: String = "",
    val userImage: String = "",
    val userPostCount: Int = 0,
    val userRating: Double = 0.0,
)

data class SettingState(
    val isDarkTheme: Boolean = false,
    val selectedLanguage: AppLanguage = AppLanguage.ENGLISH,
    val showLogoutDialog: Boolean = false,
    val showLanguageDialog: Boolean = false,
    val isLogoutLoading: Boolean = false,
    val appVersion: String = ""
)