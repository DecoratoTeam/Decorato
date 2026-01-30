package com.example.decorato.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class RecentlyWatchedDesignDto(
    @SerialName("id")
    val id: String,

    @SerialName("title")
    val title: String,

    @SerialName("location")
    val location: String,

    @SerialName("image_url")
    val imageUrl: String,

    @SerialName("category")
    val category: String,

    @SerialName("watched_at")
    val watchedAt: Long = 0L
)