package com.example.decorato.presentation.viewModel.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.decorato.presentation.viewModel.profile.InteractionListener.EditProfileInteractionListener
import com.example.decorato.presentation.viewModel.profile.UiState.EditProfileUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditProfileViewModel @Inject constructor() : ViewModel(), EditProfileInteractionListener {

    private val _state = MutableStateFlow(EditProfileUiState())
    val state = _state.asStateFlow()

    // تعريف الـ Effect يدوي بدون Base
    private val _effect = MutableSharedFlow<EditProfileEffect>()
    val effect = _effect.asSharedFlow()

    override fun onNameChange(newName: String) {
        _state.update { it.copy(userName = newName) }
    }

    override fun onEmailChange(newEmail: String) {
        _state.update { it.copy(email = newEmail) }
    }

    override fun onPasswordChange(newPassword: String) {
        _state.update { it.copy(password = newPassword) }
    }

    // تبديل رؤية الباسورد (زرار العين)
    fun onPasswordVisibilityChange() {
        _state.update { it.copy(isPasswordVisible = !it.isPasswordVisible) }
    }

    override fun onSaveClick() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            // محاكاة عملية الحفظ
            _effect.emit(EditProfileEffect.ShowToast("Profile Updated Successfully!"))
            _effect.emit(EditProfileEffect.NavigateBack)
            _state.update { it.copy(isLoading = false) }
        }
    }

    override fun onBackClick() {
        viewModelScope.launch {
            _effect.emit(EditProfileEffect.NavigateBack)
        }
    }

    override fun onUpdateImageClick() {
        // منطق اختيار صورة
    }

    override fun onPasswordVisibilityClick() {
        _state.update { it.copy(isPasswordVisible = !it.isPasswordVisible) }
    }
}