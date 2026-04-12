package com.example.decorato.presentation.screens.profile

import ProfileEffect
import ProfileInteractionListener
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.decorato.domain.model.AppLanguage
import com.example.decorato.domain.repository.AuthenticationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val authRepository: AuthenticationRepository
) : ViewModel(), ProfileInteractionListener {

    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState = _uiState.asStateFlow()

    private val _effect = MutableSharedFlow<ProfileEffect>()
    val effect = _effect.asSharedFlow()

    init {
        // الزيتونة: بنحمل داتا اليوزر أول ما نفتح
        loadUserData()
    }

    private fun loadUserData() {
        viewModelScope.launch {
            // ملاحظة: لو زميلك لسه مخلصش getUserProfile في الريبوزيتوري،
            // هنحط داتا مؤقتة هنا بس مربوطة بالـ Entity
            _uiState.update {
                it.copy(
                    isLoggedIN = true,
                    userInfo = UserInfoUiState(
                        userName = "Eng. Decorato", // هنا هينزل user.name لما يجهز
                        userPostCount = 0,
                        userRating = 0.0
                    )
                )
            }
        }
    }

    override fun onClickEditProfile() { viewModelScope.launch { _effect.emit(ProfileEffect.NavigationToEditProfile) } }
    override fun onClickMyPosts() { viewModelScope.launch { _effect.emit(ProfileEffect.NavigationToMyPosts) } }
    override fun onClickMyRating() { viewModelScope.launch { _effect.emit(ProfileEffect.NavigationToMyRating) } }

    override fun onClickLogout() {
        _uiState.update { it.copy(settingsState = it.settingsState.copy(showLogoutDialog = true)) }
    }

    override fun onConfirmLogout() {
        viewModelScope.launch {
            authRepository.logout() // بننادي الـ logout الحقيقي
            _effect.emit(ProfileEffect.NavigationToLogin)
        }
    }

    override fun onDismissLogoutDialog() {
        _uiState.update { it.copy(settingsState = it.settingsState.copy(showLogoutDialog = false)) }
    }

    override fun onClickLanguage() {
        _uiState.update { it.copy(settingsState = it.settingsState.copy(showLanguageDialog = true)) }
    }

    override fun onSelectLanguage(language: AppLanguage) {
        _uiState.update { it.copy(settingsState = it.settingsState.copy(selectedLanguage = language)) }
    }


    override fun onDismissLanguageDialog() {
        _uiState.update { it.copy(settingsState = it.settingsState.copy(showLanguageDialog = false)) }
    }



    override fun onClickLogin() {
        viewModelScope.launch { _effect.emit(ProfileEffect.NavigationToLogin) }
    }

    override fun onConfirmLanguage() {
        val selectedLang = _uiState.value.settingsState.selectedLanguage
        _uiState.update { it.copy(settingsState = it.settingsState.copy(showLanguageDialog = false)) }
        viewModelScope.launch {
            // الإشارة دي هتروح للـ Screen ومنها للـ ApplicationViewModel
            _effect.emit(ProfileEffect.ChangeLanguage(selectedLang))
        }
    }

    override fun onToggleDarkMode(isDark: Boolean) {
        // 1. نحدث الحالة جوه شاشة البروفايل فوراً عشان الزرار يقلب
        _uiState.update {
            it.copy(settingsState = it.settingsState.copy(isDarkTheme = isDark))
        }

        // 2. "الزيتونة": نبعت Effect عشان التطبيق كله يقلب دارك مود
        viewModelScope.launch {
            _effect.emit(ProfileEffect.ChangeTheme(isDark))
        }
    }
}