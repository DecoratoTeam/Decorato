package com.example.decorato.presentation.viewModel.profile.UiState

data class EditProfileUiState(
    val userName: String = "Ali H",
    val email: String = "ali@gmail.com",
    val password: String = "12345678",
    val userImage: String = "",
    val isPasswordVisible: Boolean = false, // لإظهار/إخفاء الباسورد
    val isLoading: Boolean = false,
    val error: String? = null
)