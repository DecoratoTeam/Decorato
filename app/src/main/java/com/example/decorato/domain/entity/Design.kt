package com.example.decorato.domain.entity

data class Design(
    val id: String,
    val title: String,
    val description: String,
    val imageUrl: String,
    val category: String,
    val createdAt: Long = 0L
)