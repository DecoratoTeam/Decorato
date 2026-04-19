package com.example.decorato.presentation.viewModel.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.decorato.presentation.viewModel.profile.InteractionListener.EditProfileInteractionListener
import com.example.decorato.presentation.viewModel.profile.UiState.EditProfileUiState
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
class EditProfileViewModel @Inject constructor(
    private val authRepository: AuthenticationRepository
) : ViewModel(), EditProfileInteractionListener {

    private val _state = MutableStateFlow(EditProfileUiState())
    val state = _state.asStateFlow()

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

    override fun onSaveClick() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            // الزيتونة: هنا هننده الـ Update لما زميلك يزودها في الـ Repository
            // حالياً هنكتفي بإننا نطلع Toast ونرجع
            _effect.emit(EditProfileEffect.ShowToast("Profile Updated Locally!"))
            _effect.emit(EditProfileEffect.NavigateBack)
            _state.update { it.copy(isLoading = false) }
        }
    }

    override fun onBackClick() {
        viewModelScope.launch { _effect.emit(EditProfileEffect.NavigateBack) }
    }

    override fun onUpdateImageClick() { /* لفتح الجاليري */ }

    override fun onPasswordVisibilityClick() {
        _state.update { it.copy(isPasswordVisible = !it.isPasswordVisible) }
    }

    override fun onClickEditProfile() {
        // مؤقتًا أو حسب تصميمك
    }
}