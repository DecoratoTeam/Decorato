package com.example.decorato.presentation.viewModel.community.create_post


sealed interface CreatePostEffect {
    // لما البوست يتنشر بنجاح أو يدوس رجوع
    object NavigateBack : CreatePostEffect

    // لما يحتاج يفتح الجاليري يختار صورة
    object PickImageFromGallery : CreatePostEffect
    data class NavigateToUserProfile(val userId: String) : CreatePostEffect

    // لإظهار رسايل لليوزر (نجاح/فشل)
    data class ShowSnackBar(val message: String) : CreatePostEffect
}