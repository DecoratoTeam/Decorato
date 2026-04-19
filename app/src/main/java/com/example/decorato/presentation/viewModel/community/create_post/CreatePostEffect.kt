package com.example.decorato.presentation.viewmodel.community.create_post

import com.example.decorato.presentation.viewmodel.community.community_screen.CommunityEffect


sealed interface CreatePostEffect {
    // لما البوست يتنشر بنجاح أو يدوس رجوع
    object NavigateBack : CreatePostEffect

    // لما يحتاج يفتح الجاليري يختار صورة
    object PickImageFromGallery : CreatePostEffect
    data class NavigateToUserProfile(val userId: String) : CreatePostEffect

    // لإظهار رسايل لليوزر (نجاح/فشل)
    data class ShowSnackBar(val message: String) : CreatePostEffect
}