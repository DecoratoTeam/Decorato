package com.example.decorato.presentation.viewModel.profile.InteractionListener

interface MyPostsInteractionListener {
    fun onClickPost(postId: Int)
    fun onClickDeletePost(postId: Int) // لو حبيتي تضيفي مسح للبوست مستقبلاً
    fun onBackClick()
}