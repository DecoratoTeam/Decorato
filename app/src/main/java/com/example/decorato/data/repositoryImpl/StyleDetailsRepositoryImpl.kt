package com.example.decorato.data.repositoryImpl

import com.example.decorato.domain.entity.RoomDesign
import com.example.decorato.domain.repository.StyleDetailsRepository
import javax.inject.Inject

class StyleDetailsRepositoryImpl @Inject constructor() : StyleDetailsRepository {

    override suspend fun getDesignsByStyle(styleId: String): List<RoomDesign> {
        return when (styleId) {
            "s1" -> getMockModernDesigns()
            "s2" -> getMockClassicDesigns()
            "s3" -> getMockBohemianDesigns()
            "s4" -> getMockMinimalistDesigns()
            else -> emptyList()
        }
    }

    private fun getMockModernDesigns(): List<RoomDesign> = listOf(
        RoomDesign(
            id = "d1",
            title = "Living Room",
            imageUrl = "https://images.unsplash.com/photo-1555041469-a586c61ea9bc?w=500&h=500&fit=crop",
            category = "Serenba, Georgia"
        ),
        RoomDesign(
            id = "d2",
            title = "Minimalist Kitchen",
            imageUrl = "https://images.unsplash.com/photo-1556909114-f6e7ad7d3136?w=500&h=500&fit=crop",
            category = "Cairo, Egypt"
        ),
        RoomDesign(
            id = "d3",
            title = "Modern Bedroom",
            imageUrl = "https://images.unsplash.com/photo-1540932239986-310128078ceb?w=500&h=500&fit=crop",
            category = "Alexandria, Egypt"
        ),
        RoomDesign(
            id = "d4",
            title = "Contemporary Office",
            imageUrl = "https://images.unsplash.com/photo-1497366216548-37526070297c?w=500&h=500&fit=crop",
            category = "Giza, Egypt"
        ),
        RoomDesign(
            id = "d5",
            title = "Sleek Bathroom",
            imageUrl = "https://images.unsplash.com/photo-1552321554-5fefe8c9ef14?w=500&h=500&fit=crop",
            category = "Cairo, Egypt"
        ),
        RoomDesign(
            id = "d6",
            title = "Urban Studio",
            imageUrl = "https://images.unsplash.com/photo-1486312338219-ce68d2c6f44d?w=500&h=500&fit=crop",
            category = "New Cairo, Egypt"
        )
    )

    private fun getMockClassicDesigns(): List<RoomDesign> = listOf(
        RoomDesign(
            id = "d7",
            title = "Elegant Living Room",
            imageUrl = "https://images.unsplash.com/photo-1555041469-a586c61ea9bc?w=500&h=500&fit=crop",
            category = "Serenba, Georgia"
        ),
        RoomDesign(
            id = "d8",
            title = "Classic Bedroom",
            imageUrl = "https://images.unsplash.com/photo-1540932239986-310128078ceb?w=500&h=500&fit=crop",
            category = "Alexandria, Egypt"
        ),
        RoomDesign(
            id = "d9",
            title = "Traditional Dining",
            imageUrl = "https://images.unsplash.com/photo-1556909114-f6e7ad7d3136?w=500&h=500&fit=crop",
            category = "Cairo, Egypt"
        ),
        RoomDesign(
            id = "d10",
            title = "Vintage Office",
            imageUrl = "https://images.unsplash.com/photo-1497366216548-37526070297c?w=500&h=500&fit=crop",
            category = "Giza, Egypt"
        )
    )

    private fun getMockBohemianDesigns(): List<RoomDesign> = listOf(
        RoomDesign(
            id = "d11",
            title = "Bohemian Bedroom",
            imageUrl = "https://images.unsplash.com/photo-1486312338219-ce68d2c6f44d?w=500&h=500&fit=crop",
            category = "Alexandria, Egypt"
        ),
        RoomDesign(
            id = "d12",
            title = "Eclectic Living Room",
            imageUrl = "https://images.unsplash.com/photo-1555041469-a586c61ea9bc?w=500&h=500&fit=crop",
            category = "Serenba, Georgia"
        ),
        RoomDesign(
            id = "d13",
            title = "Artistic Studio",
            imageUrl = "https://images.unsplash.com/photo-1497366216548-37526070297c?w=500&h=500&fit=crop",
            category = "Cairo, Egypt"
        ),
        RoomDesign(
            id = "d14",
            title = "Colorful Kitchen",
            imageUrl = "https://images.unsplash.com/photo-1556909114-f6e7ad7d3136?w=500&h=500&fit=crop",
            category = "New Cairo, Egypt"
        )
    )

    private fun getMockMinimalistDesigns(): List<RoomDesign> = listOf(
        RoomDesign(
            id = "d15",
            title = "Zen Bedroom",
            imageUrl = "https://images.unsplash.com/photo-1540932239986-310128078ceb?w=500&h=500&fit=crop",
            category = "Alexandria, Egypt"
        ),
        RoomDesign(
            id = "d16",
            title = "Minimalist Living",
            imageUrl = "https://images.unsplash.com/photo-1555041469-a586c61ea9bc?w=500&h=500&fit=crop",
            category = "Serenba, Georgia"
        ),
        RoomDesign(
            id = "d17",
            title = "Clean Office",
            imageUrl = "https://images.unsplash.com/photo-1497366216548-37526070297c?w=500&h=500&fit=crop",
            category = "Cairo, Egypt"
        ),
        RoomDesign(
            id = "d18",
            title = "Simple Kitchen",
            imageUrl = "https://images.unsplash.com/photo-1556909114-f6e7ad7d3136?w=500&h=500&fit=crop",
            category = "Giza, Egypt"
        ),
        RoomDesign(
            id = "d19",
            title = "Calm Bathroom",
            imageUrl = "https://images.unsplash.com/photo-1552321554-5fefe8c9ef14?w=500&h=500&fit=crop",
            category = "New Cairo, Egypt"
        )
    )
}