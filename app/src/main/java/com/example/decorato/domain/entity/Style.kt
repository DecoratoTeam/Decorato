package com.example.decorato.domain.entity

import androidx.annotation.DrawableRes

data class Style(
    val id: String,
    val name: String,
    val imageUrl: String,
    @DrawableRes val imageRes: Int = 0,
    val description: String = ""
)