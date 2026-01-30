package com.example.decorato.domain.entity

data class RecentlyWatchedDesign(
    val id: String,
    val title: String,
    val location: String,
    val imageUrl: String,
    val category: String,
    val watchedAt: Long = 0L
)