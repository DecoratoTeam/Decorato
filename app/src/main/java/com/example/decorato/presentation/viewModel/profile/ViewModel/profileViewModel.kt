//package com.example.decorato.presentation.screens.profile
//
//import ProfileEffect
//import ProfileInteractionListener
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.decorato.domain.model.AppLanguage
//import dagger.hilt.android.lifecycle.HiltViewModel
//import javax.inject.Inject // أو jakarta.inject حسب الـ setup عندك
//import kotlinx.coroutines.flow.MutableSharedFlow
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.asSharedFlow
//import kotlinx.coroutines.flow.asStateFlow
//import kotlinx.coroutines.flow.update
//import kotlinx.coroutines.launch
//
//@HiltViewModel
//class ProfileViewModel @Inject constructor() : ViewModel(), ProfileInteractionListener {
//
//    private val _uiState = MutableStateFlow(ProfileUiState())
//    val uiState = _uiState.asStateFlow()
//
//    private val _effect = MutableSharedFlow<ProfileEffect>()
//    val effect = _effect.asSharedFlow()
//
//    override fun onClickLogin() {
//        viewModelScope.launch {
//            _effect.emit(ProfileEffect.NavigationToLogin)
//        }
//    }
//
//    override fun onClickLogout() {
//        _uiState.update {
//            it.copy(settingsState = it.settingsState.copy(showLogoutDialog = true))
//        }
//    }
//
//    override fun onConfirmLogout() {
//        _uiState.update {
//            it.copy(
//                isLoggedIN = false,
//                settingsState = it.settingsState.copy(showLogoutDialog = false)
//            )
//        }
//        viewModelScope.launch {
//            _effect.emit(ProfileEffect.NavigationToLogin)
//        }
//    }
//
//    override fun onDismissLogoutDialog() {
//        _uiState.update {
//            it.copy(settingsState = it.settingsState.copy(showLogoutDialog = false))
//        }
//    }
//
//    override fun onClickLanguage() {
//        _uiState.update {
//            it.copy(settingsState = it.settingsState.copy(showLanguageDialog = true))
//        }
//    }
//
//    override fun onSelectLanguage(language: AppLanguage) {
//        _uiState.update {
//            it.copy(settingsState = it.settingsState.copy(selectedLanguage = language))
//        }
//    }
//
//    override fun onConfirmLanguage() {
//        _uiState.update {
//            it.copy(settingsState = it.settingsState.copy(showLanguageDialog = false))
//        }
//    }
//
//    override fun onDismissLanguageDialog() {
//        _uiState.update {
//            it.copy(settingsState = it.settingsState.copy(showLanguageDialog = false))
//        }
//    }
//
//    override fun onClickEditProfile() {
//        viewModelScope.launch {
//            _effect.emit(ProfileEffect.NavigationToEditProfile)
//        }
//    }
//
//    override fun onClickMyPosts() {
//        viewModelScope.launch {
//            _effect.emit(ProfileEffect.NavigationToMyPosts)
//        }
//    }
//
//    override fun onClickMyRating() {
//        viewModelScope.launch {
//            _effect.emit(ProfileEffect.NavigationToMyRating)
//        }
//    }
//
//    override fun onToggleDarkMode(isDark: Boolean) {
//        _uiState.update {
//            it.copy(settingsState = it.settingsState.copy(isDarkTheme = isDark))
//        }
//    }
//}



package com.example.decorato.presentation.screens.profile

import ProfileEffect
import ProfileInteractionListener
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.decorato.domain.model.AppLanguage
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class ProfileViewModel @Inject constructor() : ViewModel(), ProfileInteractionListener {

    // --- MOCK CODE (CURRENTLY ACTIVE FOR TESTING) ---
    private val _uiState = MutableStateFlow(
        ProfileUiState(
            isLoggedIN = true,
            userInfo = UserInfoUiState(
                userName = "Eng. Decorato",
                userPostCount = 26,
                userRating = 4.9
            ),
            settingsState = SettingState(
                isDarkTheme = false,
                selectedLanguage = AppLanguage.ENGLISH
            )
        )
    )
    val uiState = _uiState.asStateFlow()

    private val _effect = MutableSharedFlow<ProfileEffect>()
    val effect = _effect.asSharedFlow()

    override fun onClickLogin() {
        viewModelScope.launch {
            _effect.emit(ProfileEffect.NavigationToLogin)
        }
    }

    override fun onClickLogout() {
        _uiState.update {
            it.copy(settingsState = it.settingsState.copy(showLogoutDialog = true))
        }
    }

    override fun onConfirmLogout() {
        _uiState.update {
            it.copy(
                isLoggedIN = false,
                settingsState = it.settingsState.copy(showLogoutDialog = false)
            )
        }
        viewModelScope.launch {
            _effect.emit(ProfileEffect.NavigationToLogin)
        }
    }

    override fun onDismissLogoutDialog() {
        _uiState.update {
            it.copy(settingsState = it.settingsState.copy(showLogoutDialog = false))
        }
    }

    override fun onClickEditProfile() {
        viewModelScope.launch { _effect.emit(ProfileEffect.NavigationToEditProfile) }
    }

    override fun onClickMyPosts() {
        viewModelScope.launch { _effect.emit(ProfileEffect.NavigationToMyPosts) }
    }

    override fun onClickMyRating() {
        viewModelScope.launch { _effect.emit(ProfileEffect.NavigationToMyRating) }
    }

    override fun onClickLanguage() {
        _uiState.update {
            it.copy(settingsState = it.settingsState.copy(showLanguageDialog = true))
        }
    }

    override fun onSelectLanguage(language: AppLanguage) {
        _uiState.update {
            it.copy(settingsState = it.settingsState.copy(selectedLanguage = language))
        }
    }

//    override fun onConfirmLanguage() {
//        _uiState.update {
//            it.copy(settingsState = it.settingsState.copy(showLanguageDialog = false))
//        }
//    }

    override fun onConfirmLanguage() {
        val selectedLang = _uiState.value.settingsState.selectedLanguage // اللغة اللي اختارتيها
        _uiState.update {
            it.copy(settingsState = it.settingsState.copy(showLanguageDialog = false))
        }

        // الزيتونة: ابعتي الإشارة هنا
        viewModelScope.launch {
            _effect.emit(ProfileEffect.ChangeLanguage(selectedLang))
        }
    }

    override fun onDismissLanguageDialog() {
        _uiState.update {
            it.copy(settingsState = it.settingsState.copy(showLanguageDialog = false))
        }
    }

    override fun onToggleDarkMode(isDark: Boolean) {
        _uiState.update {
            it.copy(settingsState = it.settingsState.copy(isDarkTheme = isDark))
        }
    }
}