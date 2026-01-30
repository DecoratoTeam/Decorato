package com.example.decorato.domain.repository

import com.example.decorato.domain.entity.Style

interface StyleRepository {
    suspend fun getStyles(): List<Style>
    suspend fun getStyleById(styleId: String): Style
}