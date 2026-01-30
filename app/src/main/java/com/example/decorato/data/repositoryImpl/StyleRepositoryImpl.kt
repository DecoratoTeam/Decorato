package com.example.decorato.data.repositoryImpl

import com.example.decorato.R
import com.example.decorato.domain.entity.Style
import com.example.decorato.domain.repository.StyleRepository
import kotlinx.coroutines.delay
import javax.inject.Inject

class StyleRepositoryImpl @Inject constructor() : StyleRepository {

    override suspend fun getStyles(): List<Style> {
        // Mock Data مع الصور
        delay(800)
        return listOf(
            Style(
                id = "1",
                name = "Modern",
                imageUrl = "android.resource://com.example.decorato/${R.drawable.style_modern}",
                description = "Modern style"
            ),
            Style(
                id = "2",
                name = "Classic",
                imageUrl = "android.resource://com.example.decorato/${R.drawable.style_classic}",
                description = "Classic style"
            ),
            Style(
                id = "3",
                name = "Bohemian",
                imageUrl = "android.resource://com.example.decorato/${R.drawable.style_bohemian}",
                description = "Bohemian style"
            ),
            Style(
                id = "4",
                name = "Rustic",
                imageUrl = "android.resource://com.example.decorato/${R.drawable.style_rustic}",
                description = "Rustic style"
            ),
            Style(
                id = "5",
                name = "Contemporary",
                imageUrl = "android.resource://com.example.decorato/${R.drawable.style_contemporary}",
                description = "Contemporary style"
            ),
            Style(
                id = "6",
                name = "Minimalist",
                imageUrl = "android.resource://com.example.decorato/${R.drawable.style_minimalist}",
                description = "Minimalist style"
            )
        )
    }

    override suspend fun getStyleById(styleId: String): Style {
        delay(500)
        return Style(
            id = styleId,
            name = "Modern",
            imageUrl = "android.resource://com.example.decorato/${R.drawable.style_modern}",
            description = "Modern style description"
        )
    }
}