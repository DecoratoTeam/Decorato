package com.example.decorato.presentation.viewmodel.community.community_screen

sealed interface CommunityEffect {
    object NavigateToCreatePost : CommunityEffect
    data class NavigateToUserProfile(val userId: String) : CommunityEffect
    data class DownloadImage(val url: String) : CommunityEffect
    data class NavigateToPostDetails(val postId: String) : CommunityEffect // تأكدي من وجود هذا السطر
    data class ShowSnackBar(val message: String) : CommunityEffect

}