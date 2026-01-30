package com.example.decorato.domain.entity

data class Style(
    val id: String,
    val name: String,
    val imageUrl: String,
    val description: String = ""
)