package com.example.decorato.presentation.viewModel.community.create_post

data class CreatePostUiState(
    val postText: String = "",
    val selectedImageUris: List<String> = emptyList(), // مسار الصورة اللي هيختارها
    val isPublishing: Boolean = false,
    val profileImageUrl: String = "", // صورة اليوزر الحالي
    val userName: String = "",

)