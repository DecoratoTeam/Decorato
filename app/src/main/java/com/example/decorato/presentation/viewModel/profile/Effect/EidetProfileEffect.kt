package com.example.decorato.presentation.viewModel.profile

sealed class EditProfileEffect {
    object NavigateBack : EditProfileEffect()
    data class ShowToast(val message: String) : EditProfileEffect()
}