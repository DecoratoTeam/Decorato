package com.example.decorato.domain.entity

data class RoomType(
    val id: String,
    val name: String,
    val isSelected: Boolean = false
)

data class RoomDesign(
    val id: String,
    val title: String,
    val imageUrl: String,
    val category: String
)