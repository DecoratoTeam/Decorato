package com.example.decorato.presentation.viewmodel.community.community_screen

import com.example.decorato.domain.entity.Post

data class CommunityUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessages: String? = null,

    // سكشن البوستات (الـ Feed)
    val posts: List<Post> = emptyList(),

    // حالة اليوزر (عشان الـ GuestSection اللي في الفيجما)
    val isGuest: Boolean = false,

    // البيانات الخاصة بالـ Header (Share Post Section)
    val userProfileImageUrl: String = "",
    val sharePostPlaceholder: String = "Share your design...",

    // حالات الـ Refresh (لو اليوزر سحب الشاشة لتحت)
    val isRefreshing: Boolean = false
)

