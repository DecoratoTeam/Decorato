package com.example.decorato.presentation.viewModel.community.create_post

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

//@HiltViewModel
class CreatePostViewModel  : ViewModel(), CreatePostInteractionListener {

    private val _state = MutableStateFlow(CreatePostUiState())
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<CreatePostEffect>()
    val effect = _effect.asSharedFlow()

    init {
        _state.update { it.copy(
            userName = "Sara Ashraf",
            profileImageUrl = "https://media.istockphoto.com/id/474001966/photo/female-portrait-icon-as-avatar-or-profile-picture.webp?a=1&b=1&s=612x612&w=0&k=20&c=9GKRXt0EXhESvwJgRg-__xIYom3qMwkLQA-TpGmScfc="
        )}
    }

    override fun onTextChange(newText: String) {
        _state.update { it.copy(postText = newText) }
    }

    override fun onClickAddImage() {
        viewModelScope.launch {
            _effect.emit(CreatePostEffect.PickImageFromGallery)
        }
    }

    override fun onClickUserAvatar(userId: String) {
        viewModelScope.launch {
            _effect.emit(CreatePostEffect.NavigateToUserProfile(userId))
        }
    }
    fun onImagePicked(uri: String) {
        _state.update {
            it.copy(selectedImageUris = it.selectedImageUris + uri)
        }
    }

    override fun onClickBack() {
        viewModelScope.launch {
            _effect.emit(CreatePostEffect.NavigateBack)
        }
    }

    override fun onClickPublish() {
        // الزتونة 2: التحقق من اللستة بدل المتغير القديم
        if (_state.value.postText.isBlank() && _state.value.selectedImageUris.isEmpty()) return

        _state.update { it.copy(isPublishing = true) }

        viewModelScope.launch {
            try {
                // هنا المفروض ننادي الـ UseCase مستقبلاً
                _effect.emit(CreatePostEffect.NavigateBack)
            } catch (e: Exception) {
                _state.update { it.copy(isPublishing = false) }
                _effect.emit(CreatePostEffect.ShowSnackBar("Error: ${e.message}"))
            }
        }
    }
}