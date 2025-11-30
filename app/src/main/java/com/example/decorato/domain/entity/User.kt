package com.example.decorato.domain.entity

data class User(
    val id: String,
    val name: String,
    val email: String,
    val fullName: String?  = null,
    val profileImage: String? = null,
    val token: String? = null,
    val refreshToken: String? = null
)