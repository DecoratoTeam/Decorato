package com.example.decorato.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DesignDto(
    @SerialName("id")
    val id: String,

    @SerialName("title")
    val title: String,

    @SerialName("description")
    val description: String,

    @SerialName("image_url")
    val imageUrl: String,

    @SerialName("category")
    val category: String,

    @SerialName("created_at")
    val createdAt: Long = 0L
)