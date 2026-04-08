package com.example.decorato.presentation.viewModel.profile.UiState

data class MyPostsUiState(
    val isLoading: Boolean = false,
    val posts: List<PostItemUiState> = emptyList()
)

data class PostItemUiState(
    val id: Int,
    val userName: String = "Mohammed Ali",
    val userImage: String = "",
    val timeAgo: String = "2 Hours ago", // قيمة افتراضية
    val description: String = "No description provided", // قيمة افتراضية
    val postImage: String = "",
    val likesCount: String = "0 likes" // قيمة افتراضية
)