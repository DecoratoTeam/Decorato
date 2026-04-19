package com.example.decorato.domain.entity

data class Post(
    val id: String,
    val user: User,
    val description: String,
    val postImageUrl: String? = null, // nullable عشان لو البوست كلام بس
    val postDate: String,
    val likesCount: Int = 0,
    val isLiked: Boolean = false
)