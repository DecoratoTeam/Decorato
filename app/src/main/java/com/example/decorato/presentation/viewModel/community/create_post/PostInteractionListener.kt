package com.example.decorato.presentation.viewmodel.community.create_post

interface CreatePostInteractionListener {
    fun onTextChange(newText: String)
    fun onClickAddImage()
    fun onClickPublish()
    fun onClickUserAvatar(userId: String)
    fun onClickBack()
}