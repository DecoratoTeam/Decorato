package com.example.decorato.data.repository.mock

import com.example.decorato.R
import com.example.decorato.domain.entity.Design
import com.example.decorato.domain.entity.RecentlyWatchedDesign
import com.example.decorato.domain.entity.RoomDesign
import com.example.decorato.domain.entity.RoomType
import com.example.decorato.domain.entity.Style

object MockDesignRepository {

    fun getPopularDesigns(): List<Design> = listOf(
        Design(
            id = "1",
            title = "Modern Kitchen Design",
            description = "Contemporary kitchen with minimalist style",
            imageUrl = "https://images.unsplash.com/photo-1556909114-f6e7ad7d3136?w=500&h=500&fit=crop",
            category = "Kitchen"
        ),
        Design(
            id = "2",
            title = "Elegant Living Room",
            description = "Sophisticated living space with luxury furniture",
            imageUrl = "https://images.unsplash.com/photo-1555041469-a586c61ea9bc?w=500&h=500&fit=crop",
            category = "Living Room"
        ),
        Design(
            id = "3",
            title = "Cozy Bedroom",
            description = "Warm and inviting bedroom design",
            imageUrl = "https://images.unsplash.com/photo-1540932239986-310128078ceb?w=500&h=500&fit=crop",
            category = "Bedroom"
        )
    )

    fun getRecentlyWatchedDesigns(): List<RecentlyWatchedDesign> = listOf(
        RecentlyWatchedDesign(
            id = "4",
            title = "Minimalist Bathroom",
            location = "Cairo, Egypt",
            imageUrl = "https://images.unsplash.com/photo-1552321554-5fefe8c9ef14?w=500&h=500&fit=crop",
            category = "Bathroom"
        ),
        RecentlyWatchedDesign(
            id = "5",
            title = "Bohemian Bedroom",
            location = "Alexandria, Egypt",
            imageUrl = "https://images.unsplash.com/photo-1486312338219-ce68d2c6f44d?w=500&h=500&fit=crop",
            category = "Bedroom"
        ),
        RecentlyWatchedDesign(
            id = "6",
            title = "Industrial Office Space",
            location = "Giza, Egypt",
            imageUrl = "https://images.unsplash.com/photo-1497366216548-37526070297c?w=500&h=500&fit=crop",
            category = "Office"
        )
    )

    fun getStyles(): List<Style> = listOf(
        Style(
            id = "s1",
            name = "Modern",
            imageUrl = "",
            imageRes = R.drawable.style_modern,
            description = "Modern style"
        ),
        Style(
            id = "s2",
            name = "Classic",
            imageUrl = "",
            imageRes = R.drawable.style_classic,
            description = "Classic style"
        ),
        Style(
            id = "s3",
            name = "Bohemian",
            imageUrl = "",
            imageRes = R.drawable.style_bohemian,
            description = "Bohemian style"
        ),
        Style(
            id = "s4",
            name = "Minimalist",
            imageUrl = "",
            imageRes = R.drawable.style_minimalist,
            description = "Minimalist style"
        )
    )

    fun getRoomTypes(): List<RoomType> = listOf(
        RoomType(id = "1", name = "All", isSelected = true),
        RoomType(id = "2", name = "Living Room"),
        RoomType(id = "3", name = "Bedroom"),
        RoomType(id = "4", name = "Kitchen"),
        RoomType(id = "5", name = "Bathroom"),
        RoomType(id = "6", name = "Dining Room"),
        RoomType(id = "7", name = "Nursery"),
        RoomType(id = "8", name = "Office")
    )

    fun getRoomDesignsByType(roomTypeId: String): List<RoomDesign> = listOf(
        RoomDesign(
            id = "rd1",
            title = "Craftsman Bathroom",
            imageUrl = "https://images.unsplash.com/photo-1552321554-5fefe8c9ef14?w=500&h=500&fit=crop",
            category = "Bathroom"
        ),
        RoomDesign(
            id = "rd2",
            title = "Modern Living Room",
            imageUrl = "https://images.unsplash.com/photo-1555041469-a586c61ea9bc?w=500&h=500&fit=crop",
            category = "Living Room"
        ),
        RoomDesign(
            id = "rd3",
            title = "Cozy Bedroom",
            imageUrl = "https://images.unsplash.com/photo-1540932239986-310128078ceb?w=500&h=500&fit=crop",
            category = "Bedroom"
        )
    )

    fun getMockDesignById(designId: String): Design {
        return when (designId) {
            "d1" -> Design(
                id = "d1",
                title = "Transitional Living Room",
                description = "Lorem ipsum dolor sit amet consectetur. Scelerisque mauris egestas ornare elementum. Lacus velit cursus sed purus. Dignissim nibh sed luctus nulla nullam mattis. Volutpat ut volutpat tempor, volutpat blandit facilisis ut sed volutpat. Lectus nibh auctor ultricies sit amet. Quis cursus viverra eros suspendisse odio. Rhoncus sit interdum nam sed consectetur, eget tristique lobortis. Donec nisl interdum, interdum gravida tincidunt.",
                imageUrl = "https://images.unsplash.com/photo-1555041469-a586c61ea9bc?w=500&h=500&fit=crop",
                category = "Serenba, Georgia"
            )
            "d2" -> Design(
                id = "d2",
                title = "Minimalist Kitchen",
                description = "A sleek and modern kitchen design with clean lines and minimalist aesthetics. Perfect for contemporary homes looking for functionality and style.",
                imageUrl = "https://images.unsplash.com/photo-1556909114-f6e7ad7d3136?w=500&h=500&fit=crop",
                category = "Cairo, Egypt"
            )
            "d3" -> Design(
                id = "d3",
                title = "Modern Bedroom",
                description = "Experience luxury and comfort with this modern bedroom design. Features contemporary furniture and sophisticated color palette.",
                imageUrl = "https://images.unsplash.com/photo-1540932239986-310128078ceb?w=500&h=500&fit=crop",
                category = "Alexandria, Egypt"
            )
            "d4" -> Design(
                id = "d4",
                title = "Contemporary Office",
                description = "Professional workspace designed for productivity. Modern office setup with ergonomic furniture and inspiring atmosphere.",
                imageUrl = "https://images.unsplash.com/photo-1497366216548-37526070297c?w=500&h=500&fit=crop",
                category = "Giza, Egypt"
            )
            "d5" -> Design(
                id = "d5",
                title = "Elegant Living Room",
                description = "Timeless elegance meets comfort in this beautifully designed living room. Perfect for entertaining guests.",
                imageUrl = "https://images.unsplash.com/photo-1555041469-a586c61ea9bc?w=500&h=500&fit=crop",
                category = "Serenba, Georgia"
            )
            "d6" -> Design(
                id = "d6",
                title = "Classic Bedroom",
                description = "Traditional design with a contemporary twist. This bedroom combines classic elements with modern comfort.",
                imageUrl = "https://images.unsplash.com/photo-1540932239986-310128078ceb?w=500&h=500&fit=crop",
                category = "Alexandria, Egypt"
            )
            "d7" -> Design(
                id = "d7",
                title = "Bohemian Bedroom",
                description = "Free-spirited and colorful bedroom design with eclectic furniture and artistic touches.",
                imageUrl = "https://images.unsplash.com/photo-1486312338219-ce68d2c6f44d?w=500&h=500&fit=crop",
                category = "Alexandria, Egypt"
            )
            "d8" -> Design(
                id = "d8",
                title = "Eclectic Living Room",
                description = "A unique blend of different styles and colors creating a vibrant and welcoming living space.",
                imageUrl = "https://images.unsplash.com/photo-1555041469-a586c61ea9bc?w=500&h=500&fit=crop",
                category = "Serenba, Georgia"
            )
            "d9" -> Design(
                id = "d9",
                title = "Zen Bedroom",
                description = "Calm and peaceful bedroom design promoting relaxation and tranquility. Perfect for a good night's sleep.",
                imageUrl = "https://images.unsplash.com/photo-1540932239986-310128078ceb?w=500&h=500&fit=crop",
                category = "Alexandria, Egypt"
            )
            "d10" -> Design(
                id = "d10",
                title = "Minimalist Living",
                description = "Simplified living space with essential furniture only. Clean, organized, and visually appealing.",
                imageUrl = "https://images.unsplash.com/photo-1555041469-a586c61ea9bc?w=500&h=500&fit=crop",
                category = "Serenba, Georgia"
            )
            else -> Design(
                id = "default",
                title = "Design Details",
                description = "Beautiful interior design",
                imageUrl = "https://images.unsplash.com/photo-1555041469-a586c61ea9bc?w=500&h=500&fit=crop",
                category = "Unknown"
            )
        }
    }
}