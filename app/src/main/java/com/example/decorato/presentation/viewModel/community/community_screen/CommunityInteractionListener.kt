package com.example.decorato.presentation.viewmodel.community.community_screen

interface CommunityInteractionListener {
    // لما يدوس على "Share your design" عشان يفتح شاشة النشر
    fun onClickSharePostSection()

    // لما يدوس لايك على بوست معين
    fun onClickLike(postId: String)

    // لما يدوس على صورة صاحب البوست عشان يفتح بروفايله
    fun onClickUserAvatar(userId: String)

    // لما يسحب الشاشة لتحت عشان يحدث البيانات
    fun onRefresh()

    // لو فيه زرار Login في الـ GuestSection
    fun onClickLogin()

    fun onClickDownload(imageUrl: String?)
}