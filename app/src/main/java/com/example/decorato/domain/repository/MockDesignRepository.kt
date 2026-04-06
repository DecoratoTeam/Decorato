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
            description = "Contemporary kitchen with minimalist style and smart storage solutions",
            imageUrl = "https://images.unsplash.com/photo-1502005097973-6a7082348e28?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTd8fEludGVyaW9yJTIwRGVzaWdufGVufDB8fDB8fHww",
            category = "Kitchen"
        ),
        Design(
            id = "2",
            title = "Elegant Living Room",
            description = "Sophisticated living space with luxury furniture and warm lighting",
            imageUrl = "https://plus.unsplash.com/premium_photo-1664300969611-f3745a737234?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1yZWxhdGVkfDV8fHxlbnwwfHx8fHw%3D",
            category = "Living Room"
        ),
        Design(
            id = "3",
            title = "Cozy Bedroom",
            description = "Warm and inviting bedroom design with comfortable textures",
            imageUrl = "https://plus.unsplash.com/premium_photo-1661963239507-7bdf41a5e66b?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8SW50ZXJpb3IlMjBEZXNpZ24lMjBCZWRyb29tfGVufDB8fDB8fHww",
            category = "Bedroom"
        ),
        Design(
            id = "pop4",
            title = "Luxurious Bathroom",
            description = "Spa-like bathroom with premium fixtures and elegant tiles",
            imageUrl = "https://plus.unsplash.com/premium_photo-1661963215502-dc2bc471ab2a?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8THV4dXJpb3VzJTIwQmF0aHJvb218ZW58MHx8MHx8fDA%3D",
            category = "Bathroom"
        ),
        Design(
            id = "pop5",
            title = "Industrial Office Space",
            description = "Professional workspace with exposed brick and modern furniture",
            imageUrl = "https://plus.unsplash.com/premium_photo-1664304082823-035775a3c141?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8SW5kdXN0cmlhbCUyME9mZmljZSUyMFNwYWNlfGVufDB8fDB8fHww",
            category = "Office"
        ),
        Design(
            id = "pop6",
            title = "Scandinavian Dining Room",
            description = "Minimalist dining with natural wood and clean lines",
            imageUrl = "https://images.unsplash.com/photo-1723750290151-164cb19ebab7?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8U2NhbmRpbmF2aWFuJTIwRGluaW5nJTIwUm9vbXxlbnwwfHwwfHx8MA%3D%3D",
            category = "Dining Room"
        ),
        Design(
            id = "pop7",
            title = "Mediterranean Living Space",
            description = "Warm terracotta and natural stone create an inviting atmosphere",
            imageUrl = "https://images.unsplash.com/photo-1757439402190-99b73ac8e807?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8TWVkaXRlcnJhbmVhbiUyMExpdmluZyUyMFNwYWNlfGVufDB8fDB8fHww",
            category = "Living Room"
        ),
        Design(
            id = "pop8",
            title = "Modern Master Bedroom",
            description = "Luxury bedroom with contemporary design and premium finishes",
            imageUrl = "https://plus.unsplash.com/premium_photo-1661877303180-19a028c21048?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8TW9kZXJuJTIwTWFzdGVyJTIwQmVkcm9vbXxlbnwwfHwwfHx8MA%3D%3D",
            category = "Bedroom"
        ),
        Design(
            id = "pop9",
            title = "Bright Minimalist Kitchen",
            description = "White and natural wood kitchen with perfect storage solutions",
            imageUrl = "https://images.unsplash.com/photo-1669046222569-a7672da06e12?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8QnJpZ2h0JTIwTWluaW1hbGlzdCUyMEtpdGNoZW58ZW58MHx8MHx8fDA%3D",
            category = "Kitchen"
        ),
        Design(
            id = "pop10",
            title = "Zen Bathroom Retreat",
            description = "Peaceful bathroom with natural stone and soft lighting",
            imageUrl = "https://media.istockphoto.com/id/2216890622/photo/modern-boho-bathroom-with-soft-lighting.webp?a=1&b=1&s=612x612&w=0&k=20&c=uwVVl1cvbADZ3f1YAuSP0gK9Jxfa_eMGAN3F2xu9pfo=",
            category = "Bathroom"
        ),
        Design(
            id = "pop11",
            title = "Contemporary Home Office",
            description = "Productive workspace with modern furniture and natural light",
            imageUrl = "https://plus.unsplash.com/premium_photo-1676823552727-89722eb5f72e?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8Q29udGVtcG9yYXJ5JTIwSG9tZSUyME9mZmljZXxlbnwwfHwwfHx8MA%3D%3D",
            category = "Office"
        ),
        Design(
            id = "pop12",
            title = "Luxury Penthouse Living",
            description = "High-end design with panoramic views and modern art",
            imageUrl = "https://plus.unsplash.com/premium_photo-1733320822557-e4ccfb5f20d1?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8THV4dXJ5JTIwUGVudGhvdXNlJTIwTGl2aW5nfGVufDB8fDB8fHww",
            category = "Living Room"
        ),
        Design(
            id = "pop13",
            title = "Industrial Chic Bedroom",
            description = "Raw materials meet comfort in this trendy bedroom design",
            imageUrl = "https://media.istockphoto.com/id/2219306327/photo/urban-loft-bedroom-with-exposed-brick-and-concrete-walls.jpg?s=1024x1024&w=is&k=20&c=Q8T4kIMFZ2yhXgmL7PH0graG8-FxCnbc_cf_wBtLzmU=",
            category = "Bedroom"
        ),
        Design(
            id = "pop14",
            title = "Gourmet Kitchen Island",
            description = "Chef's kitchen with professional appliances and granite counters",
            imageUrl = "https://media.istockphoto.com/id/1337181547/photo/vaulted-ceiling-in-modern-kitchen.webp?a=1&b=1&s=612x612&w=0&k=20&c=r0oKCgHxKUg3PPkPHtQMPiNVMxCST6P8jgDtQmFQefI=",
            category = "Kitchen"
        ),
        Design(
            id = "pop15",
            title = "Artistic Living Gallery",
            description = "Showcase your art collection in this gallery-style living room",
            imageUrl = "https://images.unsplash.com/photo-1764010533326-c6916f3d6252?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8QXJ0aXN0aWMlMjBMaXZpbmclMjBHYWxsZXJ5fGVufDB8fDB8fHww",
            category = "Living Room"
        ),
        Design(
            id = "pop16",
            title = "Scandinavian Nursery",
            description = "Soft colors and natural materials create a safe nursery space",
            imageUrl = "https://images.unsplash.com/photo-1588854337127-a7cdcabfd7ac?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8TnVyc2VyeXxlbnwwfHwwfHx8MA%3D%3D",
            category = "Nursery"
        )
    )

    fun getRecentlyWatchedDesigns(): List<RecentlyWatchedDesign> = listOf(
        RecentlyWatchedDesign(
            id = "4",
            title = "Modern Kitchen Design",
            location = "Cairo, Egypt",
            imageUrl = "https://images.unsplash.com/photo-1502005097973-6a7082348e28?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTd8fEludGVyaW9yJTIwRGVzaWdufGVufDB8fDB8fHww",
            category = "Kitchen"
        ),
        RecentlyWatchedDesign(
            id = "5",
            title = "Elegant Living Room",
            location = "Alexandria, Egypt",
            imageUrl = "https://plus.unsplash.com/premium_photo-1664300969611-f3745a737234?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1yZWxhdGVkfDV8fHxlbnwwfHx8fHw%3D",
            category = "Living Room"
        ),
        RecentlyWatchedDesign(
            id = "6",
            title = "Cozy Bedroom",
            location = "Giza, Egypt",
            imageUrl = "https://plus.unsplash.com/premium_photo-1661963239507-7bdf41a5e66b?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8SW50ZXJpb3IlMjBEZXNpZ24lMjBCZWRyb29tfGVufDB8fDB8fHww",
            category = "Bedroom"
        ),
        RecentlyWatchedDesign(
            id = "rec7",
            title = "Luxurious Bathroom",
            location = "New Cairo, Egypt",
            imageUrl = "https://plus.unsplash.com/premium_photo-1661963215502-dc2bc471ab2a?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8THV4dXJpb3VzJTIwQmF0aHJvb218ZW58MHx8MHx8fDA%3D",
            category = "Bathroom"
        ),
        RecentlyWatchedDesign(
            id = "rec8",
            title = "Industrial Office Space",
            location = "6th of October, Egypt",
            imageUrl = "https://plus.unsplash.com/premium_photo-1664304082823-035775a3c141?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8SW5kdXN0cmlhbCUyME9mZmljZSUyMFNwYWNlfGVufDB8fDB8fHww",
            category = "Office"
        ),
        RecentlyWatchedDesign(
            id = "rec9",
            title = "Scandinavian Dining Room",
            location = "Heliopolis, Egypt",
            imageUrl = "https://images.unsplash.com/photo-1723750290151-164cb19ebab7?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8U2NhbmRpbmF2aWFuJTIwRGluaW5nJTIwUm9vbXxlbnwwfHwwfHx8MA%3D%3D",
            category = "Dining Room"
        ),
        RecentlyWatchedDesign(
            id = "rec10",
            title = "Mediterranean Living Space",
            location = "Cairo, Egypt",
            imageUrl = "https://images.unsplash.com/photo-1757439402190-99b73ac8e807?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8TWVkaXRlcnJhbmVhbiUyMExpdmluZyUyMFNwYWNlfGVufDB8fDB8fHww",
            category = "Living Room"
        ),
        RecentlyWatchedDesign(
            id = "rec11",
            title = "Modern Master Bedroom",
            location = "New Cairo, Egypt",
            imageUrl = "https://plus.unsplash.com/premium_photo-1661877303180-19a028c21048?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8TW9kZXJuJTIwTWFzdGVyJTIwQmVkcm9vbXxlbnwwfHwwfHx8MA%3D%3D",
            category = "Bedroom"
        ),
        RecentlyWatchedDesign(
            id = "rec12",
            title = "Bright Minimalist Kitchen",
            location = "Alexandria, Egypt",
            imageUrl = "https://images.unsplash.com/photo-1669046222569-a7672da06e12?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8QnJpZ2h0JTIwTWluaW1hbGlzdCUyMEtpdGNoZW58ZW58MHx8MHx8fDA%3D",
            category = "Kitchen"
        ),
        RecentlyWatchedDesign(
            id = "rec13",
            title = "Zen Bathroom Retreat",
            location = "Giza, Egypt",
            imageUrl = "https://media.istockphoto.com/id/2216890622/photo/modern-boho-bathroom-with-soft-lighting.webp?a=1&b=1&s=612x612&w=0&k=20&c=uwVVl1cvbADZ3f1YAuSP0gK9Jxfa_eMGAN3F2xu9pfo=",
            category = "Bathroom"
        ),
        RecentlyWatchedDesign(
            id = "rec14",
            title = "Contemporary Home Office",
            location = "6th of October, Egypt",
            imageUrl = "https://plus.unsplash.com/premium_photo-1676823552727-89722eb5f72e?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8Q29udGVtcG9yYXJ5JTIwSG9tZSUyME9mZmljZXxlbnwwfHwwfHx8MA%3D%3D",
            category = "Office"
        ),
        RecentlyWatchedDesign(
            id = "rec15",
            title = "Luxury Penthouse Living",
            location = "New Cairo, Egypt",
            imageUrl = "https://plus.unsplash.com/premium_photo-1733320822557-e4ccfb5f20d1?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8THV4dXJ5JTIwUGVudGhvdXNlJTIwTGl2aW5nfGVufDB8fDB8fHww",
            category = "Living Room"
        ),
        RecentlyWatchedDesign(
            id = "rec16",
            title = "Industrial Chic Bedroom",
            location = "Heliopolis, Egypt",
            imageUrl = "https://media.istockphoto.com/id/2219306327/photo/urban-loft-bedroom-with-exposed-brick-and-concrete-walls.jpg?s=1024x1024&w=is&k=20&c=Q8T4kIMFZ2yhXgmL7PH0graG8-FxCnbc_cf_wBtLzmU=",
            category = "Bedroom"
        ),
        RecentlyWatchedDesign(
            id = "rec17",
            title = "Gourmet Kitchen Island",
            location = "Cairo, Egypt",
            imageUrl = "https://media.istockphoto.com/id/1337181547/photo/vaulted-ceiling-in-modern-kitchen.webp?a=1&b=1&s=612x612&w=0&k=20&c=r0oKCgHxKUg3PPkPHtQMPiNVMxCST6P8jgDtQmFQefI=",
            category = "Kitchen"
        ),
        RecentlyWatchedDesign(
            id = "rec18",
            title = "Artistic Living Gallery",
            location = "Alexandria, Egypt",
            imageUrl = "https://images.unsplash.com/photo-1764010533326-c6916f3d6252?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8QXJ0aXN0aWMlMjBMaXZpbmclMjBHYWxsZXJ5fGVufDB8fDB8fHww",
            category = "Living Room"
        ),
        RecentlyWatchedDesign(
            id = "rec19",
            title = "Scandinavian Nursery",
            location = "Giza, Egypt",
            imageUrl = "https://images.unsplash.com/photo-1588854337127-a7cdcabfd7ac?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8TnVyc2VyeXxlbnwwfHwwfHx8MA%3D%3D",
            category = "Nursery"
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

    fun getRoomDesignsByType(roomTypeId: String): List<RoomDesign> = when (roomTypeId) {
        "1" -> listOf(  // All 
            RoomDesign(
                id = "lr1",
                title = "Modern Living Room",
                imageUrl = "https://plus.unsplash.com/premium_photo-1664300969611-f3745a737234?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1yZWxhdGVkfDV8fHxlbnwwfHx8fHw%3D",
                category = "Living Room"
            ),
            RoomDesign(
                id = "bd1",
                title = "Cozy Bedroom",
                imageUrl = "https://plus.unsplash.com/premium_photo-1661963239507-7bdf41a5e66b?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8SW50ZXJpb3IlMjBEZXNpZ24lMjBCZWRyb29tfGVufDB8fDB8fHww",
                category = "Bedroom"
            ),
            RoomDesign(
                id = "k1",
                title = "Contemporary Kitchen",
                imageUrl = "https://images.unsplash.com/photo-1502005097973-6a7082348e28?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTd8fEludGVyaW9yJTIwRGVzaWdufGVufDB8fDB8fHww",
                category = "Kitchen"
            ),
            RoomDesign(
                id = "ba1",
                title = "Luxurious Bathroom",
                imageUrl = "https://plus.unsplash.com/premium_photo-1661963215502-dc2bc471ab2a?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8THV4dXJpb3VzJTIwQmF0aHJvb208ZW58MHx8MHx8fDA%3D",
                category = "Bathroom"
            ),
            RoomDesign(
                id = "dr1",
                title = "Elegant Dining",
                imageUrl = "https://images.unsplash.com/photo-1723750290151-164cb19ebab7?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8U2NhbmRpbmF2aWFuJTIwRGluaW5nJTIwUm9vbXxlbnwwfHwwfHx8MA%3D%3D",
                category = "Dining Room"
            ),
            RoomDesign(
                id = "nu1",
                title = "Scandinavian Nursery",
                imageUrl = "https://images.unsplash.com/photo-1588854337127-a7cdcabfd7ac?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8TnVyc2VyeXxlbnwwfHwwfHx8MA%3D%3D",
                category = "Nursery"
            ),
            RoomDesign(
                id = "of1",
                title = "Professional Office",
                imageUrl = "https://plus.unsplash.com/premium_photo-1664304082823-035775a3c141?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8SW5kdXN0cmlhbCUyME9mZmljZSUyMFNwYWNlfGVufDB8fDB8fHww",
                category = "Office"
            ),
            RoomDesign(
                id = "lr2",
                title = "Mediterranean Living Space",
                imageUrl = "https://images.unsplash.com/photo-1757439402190-99b73ac8e807?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8TWVkaXRlcnJhbmVhbiUyMExpdmluZyUyMFNwYWNlfGVufDB8fDB8fHww",
                category = "Living Room"
            ),
            RoomDesign(
                id = "bd2",
                title = "Luxury Master Suite",
                imageUrl = "https://plus.unsplash.com/premium_photo-1661877303180-19a028c21048?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8TW9kZXJuJTIwTWFzdGVyJTIwQmVkcm9vbXxlbnwwfHwwfHx8MA%3D%3D",
                category = "Bedroom"
            ),
            RoomDesign(
                id = "k2",
                title = "Bright Minimalist Kitchen",
                imageUrl = "https://images.unsplash.com/photo-1669046222569-a7672da06e12?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8QnJpZ2h0JTIwTWluaW1hbGlzdCUyMEtpdGNoZW58ZW58MHx8MHx8fDA%3D",
                category = "Kitchen"
            ),
            RoomDesign(
                id = "ba2",
                title = "Zen Bathroom Retreat",
                imageUrl = "https://media.istockphoto.com/id/2216890622/photo/modern-boho-bathroom-with-soft-lighting.webp?a=1&b=1&s=612x612&w=0&k=20&c=uwVVl1cvbADZ3f1YAuSP0gK9Jxfa_eMGAN3F2xu9pfo=",
                category = "Bathroom"
            ),
            RoomDesign(
                id = "dr2",
                title = "Modern Dining Space",
                imageUrl = "https://images.unsplash.com/photo-1760431194370-48fe900d09f7?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8TW9kZXJuJTIwRGluaW5nJTIwU3BhY2V8ZW58MHx8MHx8fDA%3D",
                category = "Dining Room"
            ),
            RoomDesign(
                id = "nu2",
                title = "Modern Baby Room",
                imageUrl = "https://media.istockphoto.com/id/1938954118/photo/modern-baby-room-interior-with-messy-crib-cabinet-armchair-toys-and-plants.webp?a=1&b=1&s=612x612&w=0&k=20&c=9aBy6rW4r8eRYvonDnmMmYQn3k_aokHTHq08o6fbSjc=",
                category = "Nursery"
            ),
            RoomDesign(
                id = "of2",
                title = "Contemporary Home Office",
                imageUrl = "https://plus.unsplash.com/premium_photo-1676823552727-89722eb5f72e?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8Q29udGVtcG9yYXJ5JTIwSG9tZSUyME9mZmljZXxlbnwwfHwwfHx8MA%3D%3D",
                category = "Office"
            ),
            RoomDesign(
                id = "lr3",
                title = "Luxury Penthouse Living",
                imageUrl = "https://plus.unsplash.com/premium_photo-1733320822557-e4ccfb5f20d1?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8THV4dXJ5JTIwUGVudGhvdXNlJTIwTGl2aW5nfGVufDB8fDB8fHww",
                category = "Living Room"
            ),
            RoomDesign(
                id = "bd3",
                title = "Industrial Chic Bedroom",
                imageUrl = "https://media.istockphoto.com/id/2219306327/photo/urban-loft-bedroom-with-exposed-brick-and-concrete-walls.jpg?s=1024x1024&w=is&k=20&c=Q8T4kIMFZ2yhXgmL7PH0graG8-FxCnbc_cf_wBtLzmU=",
                category = "Bedroom"
            ),
            RoomDesign(
                id = "k3",
                title = "Gourmet Kitchen Island",
                imageUrl = "https://media.istockphoto.com/id/1337181547/photo/vaulted-ceiling-in-modern-kitchen.webp?a=1&b=1&s=612x612&w=0&k=20&c=r0oKCgHxKUg3PPkPHtQMPiNVMxCST6P8jgDtQmFQefI=",
                category = "Kitchen"
            ),
            RoomDesign(
                id = "ba3",
                title = "Modern Spa Bathroom",
                imageUrl = "https://images.unsplash.com/photo-1771239048293-72abf673adb2?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8TW9kZXJuJTIwU3BhJTIwQmF0aHJvb218ZW58MHx8MHx8fDA%3D",
                category = "Bathroom"
            ),
            RoomDesign(
                id = "dr3",
                title = "Luxury Dining Room",
                imageUrl = "https://plus.unsplash.com/premium_photo-1661962461938-b3a74097d946?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8THV4dXJ5JTIwRGluaW5nJTIwUm9vbXxlbnwwfHwwfHx8MA%3D%3D",
                category = "Dining Room"
            ),
            RoomDesign(
                id = "nu3",
                title = "Minimalist Nursery",
                imageUrl = "https://plus.unsplash.com/premium_photo-1684779979840-0285cb45ea71?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTN8fE1pbmltYWxpc3QlMjBOdXJzZXJ5fGVufDB8fDB8fHww",
                category = "Nursery"
            ),
            RoomDesign(
                id = "of3",
                title = "Minimalist Office",
                imageUrl = "https://images.unsplash.com/photo-1718220216044-006f43e3a9b1?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8N3x8TWluaW1hbGlzdCUyME9mZmljZXxlbnwwfHwwfHx8MA%3D%3D",
                category = "Office"
            ),
            RoomDesign(
                id = "lr4",
                title = "Artistic Living Gallery",
                imageUrl = "https://images.unsplash.com/photo-1764010533326-c6916f3d6252?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8QXJ0aXN0aWMlMjBMaXZpbmclMjBHYWxsZXJ5fGVufDB8fDB8fHww",
                category = "Living Room"
            ),
            RoomDesign(
                id = "bd4",
                title = "Minimalist Zen Bedroom",
                imageUrl = "https://images.unsplash.com/photo-1765862835193-3c37388a409e?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8TWluaW1hbGlzdCUyMFplbiUyMEJlZHJvb218ZW58MHx8MHx8fDA%3D",
                category = "Bedroom"
            ),
            RoomDesign(
                id = "k4",
                title = "Modern Kitchen Design",
                imageUrl = "https://plus.unsplash.com/premium_photo-1661779601614-9206e0451077?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8TW9kZXJuJTIwS2l0Y2hlbiUyMERlc2lnbnxlbnwwfHwwfHx8MA%3D%3D",
                category = "Kitchen"
            ),
            RoomDesign(
                id = "ba4",
                title = "Minimalist Bathroom",
                imageUrl = "https://plus.unsplash.com/premium_photo-1721274105657-0751a5f42eb8?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8TWluaW1hbGlzdCUyMEJhdGhyb29tfGVufDB8fDB8fHww",
                category = "Bathroom"
            ),
            RoomDesign(
                id = "dr4",
                title = "Industrial Dining",
                imageUrl = "https://plus.unsplash.com/premium_photo-1661962305366-0c62646fd249?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTd8fEluZHVzdHJpYWwlMjBEaW5pbmd8ZW58MHx8MHx8fDA%3D",
                category = "Dining Room"
            ),
            RoomDesign(
                id = "nu4",
                title = "Colorful Playroom",
                imageUrl = "https://media.istockphoto.com/id/940134520/photo/pastel-kids-playroom-interior.webp?a=1&b=1&s=612x612&w=0&k=20&c=qSNn_9fzSif5W2F5DAcQoRQTnoRJyokMOreF-HbD3Us=",
                category = "Nursery"
            ),
            RoomDesign(
                id = "of4",
                title = "Creative Workspace",
                imageUrl = "https://images.unsplash.com/photo-1693159682618-074078ed271e?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8Q3JlYXRpdmUlMjBXb3Jrc3BhY2V8ZW58MHx8MHx8fDA%3D",
                category = "Office"
            ),
            RoomDesign(
                id = "lr5",
                title = "Elegant Coastal Living",
                imageUrl = "https://images.unsplash.com/photo-1493857671505-72967e2e2760?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8Q29hc3RhbCUyMExpdmluZXxlbnwwfHwwfHx8MA%3D%3D",
                category = "Living Room"
            ),
            RoomDesign(
                id = "bd5",
                title = "Bohemian Dream Bedroom",
                imageUrl = "https://images.unsplash.com/photo-1583845112203-29329902332e?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OHx8Qm9oZW1pYW4lMjBEcmVhbSUyMEJlZHJvb218ZW58MHx8MHx8fDA%3D",
                category = "Bedroom"
            ),
            RoomDesign(
                id = "k5",
                title = "Industrial Kitchen",
                imageUrl = "https://images.unsplash.com/photo-1589109807644-924edf14ee09?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8SW5kdXN0cmlhbCUyMEtpdGNoZW58ZW58MHx8MHx8fDA%3D",
                category = "Kitchen"
            ),
            RoomDesign(
                id = "ba5",
                title = "Scandinavian Bath",
                imageUrl = "https://media.istockphoto.com/id/1082345206/photo/interior-design-of-a-bathroom-3d-illustration-in-a-scandinavian-style.webp?a=1&b=1&s=612x612&w=0&k=20&c=lPz1Lit04QuScHSyL3zm__epywU61pbzpbhfZsOvxpY=",
                category = "Bathroom"
            ),
            RoomDesign(
                id = "dr5",
                title = "Scandinavian Dining",
                imageUrl = "https://media.istockphoto.com/id/2213976761/photo/compact-black-kitchen-and-dining-area-in-scandinavian-log-cabin-with-sea-view.webp?a=1&b=1&s=612x612&w=0&k=20&c=kkTZnWqyAJ_n0Rw8x4GWwj8duGh2FFKGbPOJHlMiT20=",
                category = "Dining Room"
            ),
            RoomDesign(
                id = "nu5",
                title = "Soft Nursery Design",
                imageUrl = "https://media.istockphoto.com/id/1345191888/photo/cute-baby-room-interior-with-crib-and-big-window.webp?a=1&b=1&s=612x612&w=0&k=20&c=ECIWD3kepDvHXvimS62eyhRW-K9PXSD1Q_GZ4YLLoss=",
                category = "Nursery"
            ),
            RoomDesign(
                id = "of5",
                title = "Modern Startup Office",
                imageUrl = "https://images.unsplash.com/photo-1558959356-2f36c7322d3b?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTF8fE1vZGVybiUyMFN0YXJ0dXAlMjBPZmZpY2V8ZW58MHx8MHx8fDA%3D",
                category = "Office"
            ),
            RoomDesign(
                id = "lr6",
                title = "Contemporary Living Space",
                imageUrl = "https://plus.unsplash.com/premium_photo-1744839107780-2eefa443f4a8?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8Q29udGVtcG9yYXJ5JTIwTGl2aW5nJTIwU3BhY2V8ZW58MHx8MHx8fDA%3D",
                category = "Living Room"
            ),
            RoomDesign(
                id = "bd6",
                title = "Scandinavian Bedroom",
                imageUrl = "https://images.unsplash.com/photo-1610307522657-8c0304960189?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8U2NhbmRpbmF2aWFuJTIwQmVkcm9vbXxlbnwwfHwwfHx8MA%3D%3D",
                category = "Bedroom"
            ),
            RoomDesign(
                id = "k6",
                title = "Luxury Chef's Kitchen",
                imageUrl = "https://images.unsplash.com/photo-1658280911730-467b4764c09c?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTV8fEx1eHVyeSUyMENoZWYncyUyMEtpdGNoZW58ZW58MHx8MHx8fDA%3D",
                category = "Kitchen"
            ),
            RoomDesign(
                id = "ba6",
                title = "Contemporary Bathroom Design",
                imageUrl = "https://media.istockphoto.com/id/1152076563/photo/luxurious-bathroom.webp?a=1&b=1&s=612x612&w=0&k=20&c=NtM5hqCYBbauVKT8did24VG27fsrTKkmku8wh5EsA2o=",
                category = "Bathroom"
            ),
            RoomDesign(
                id = "dr6",
                title = "Contemporary Dining Space",
                imageUrl = "https://images.unsplash.com/photo-1771371639198-6c044fed1941?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8Q29udGVtcG9yYXJ5JTIwRGluaW5nJTIwU3BhY2V8ZW58MHx8MHx8fDA%3D",
                category = "Dining Room"
            ),
            RoomDesign(
                id = "nu6",
                title = "Peaceful Baby Room",
                imageUrl = "https://media.istockphoto.com/id/1174243995/photo/this-room-will-be-filled-with-laughter-and-cries-soon.webp?a=1&b=1&s=612x612&w=0&k=20&c=ZxX60iOK9jsZsL_zdMCfgMoITkfRCPTnLMdbg9ullmc=",
                category = "Nursery"
            ),
            RoomDesign(
                id = "of6",
                title = "Productive Home Desk",
                imageUrl = "https://images.unsplash.com/photo-1623916799434-114e844becc2?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8UHJvZHVjdGl2ZSUyMEhvbWUlMjBEZXNrfGVufDB8fDB8fHww",
                category = "Office"
            ),
            RoomDesign(
                id = "lr7",
                title = "Scandinavian Living Room",
                imageUrl = "https://plus.unsplash.com/premium_photo-1723901830004-3012de1ed13d?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8U2NhbmRpbmF2aWFuJTIwTGl2aW5nJTIwUm9vbXxlbnwwfHwwfHx8MA%3D%3D",
                category = "Living Room"
            ),
            RoomDesign(
                id = "lr8",
                title = "Industrial Modern Living",
                imageUrl = "https://plus.unsplash.com/premium_photo-1661963118331-26a530ed4637?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8SW5kdXN0cmlhbCUyME1vZGVybiUyMExpdmluZ3xlbnwwfHwwfHx8MA%3D%3D",
                category = "Living Room"
            ),
            RoomDesign(
                id = "lr9",
                title = "Minimalist Living Room",
                imageUrl = "https://images.unsplash.com/photo-1593696140826-c58b021acf8b?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTV8fE1pbmltYWxpc3QlMjBMaXZpbmclMjBSb29tfGVufDB8fDB8fHww",
                category = "Living Room"
            ),
            RoomDesign(
                id = "lr10",
                title = "Bohemian Living Space",
                imageUrl = "https://media.istockphoto.com/id/2161509009/photo/warm-and-inviting-bohemian-living-room-interior-design.webp?a=1&b=1&s=612x612&w=0&k=20&c=Cp6a9zyOIknuTIrzfWyTgSPjO80xwgN_4LYUZ-2tPJ8=",
                category = "Living Room"
            ),
            RoomDesign(
                id = "lr11",
                title = "Rustic Cozy Living",
                imageUrl = "https://images.unsplash.com/photo-1761662826410-3218852da3bf?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8UnVzdGljJTIwQ296eSUyMExpdmluZ3xlbnwwfHwwfHx8MA%3D%3D",
                category = "Living Room"
            ),
            RoomDesign(
                id = "lr12",
                title = "Eclectic Living Room",
                imageUrl = "https://plus.unsplash.com/premium_photo-1661879463320-27174a27d668?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8RWNsZWN0aWMlMjBMaXZpbmclMjBSb29tfGVufDB8fDB8fHww",
                category = "Living Room"
            )
        )
        "2" -> listOf(  // Living Room
            RoomDesign(
                id = "lr1",
                title = "Modern Living Room",
                imageUrl = "https://plus.unsplash.com/premium_photo-1664300969611-f3745a737234?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1yZWxhdGVkfDV8fHxlbnwwfHx8fHw%3D",
                category = "Living Room"
            ),
            RoomDesign(
                id = "lr2",
                title = "Mediterranean Living Space",
                imageUrl = "https://images.unsplash.com/photo-1757439402190-99b73ac8e807?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8TWVkaXRlcnJhbmVhbiUyMExpdmluZyUyMFNwYWNlfGVufDB8fDB8fHww",
                category = "Living Room"
            ),
            RoomDesign(
                id = "lr3",
                title = "Luxury Penthouse Living",
                imageUrl = "https://plus.unsplash.com/premium_photo-1733320822557-e4ccfb5f20d1?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8THV4dXJ5JTIwUGVudGhvdXNlJTIwTGl2aW5nfGVufDB8fDB8fHww",
                category = "Living Room"
            ),
            RoomDesign(
                id = "lr4",
                title = "Artistic Living Gallery",
                imageUrl = "https://images.unsplash.com/photo-1764010533326-c6916f3d6252?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8QXJ0aXN0aWMlMjBMaXZpbmclMjBHYWxsZXJ5fGVufDB8fDB8fHww",
                category = "Living Room"
            ),
            RoomDesign(
                id = "lr5",
                title = "Elegant Coastal Living",
                imageUrl = "https://images.unsplash.com/photo-1493857671505-72967e2e2760?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8Q29hc3RhbCUyMExpdmluZXxlbnwwfHwwfHx8MA%3D%3D",
                category = "Living Room"
            ),
            RoomDesign(
                id = "lr6",
                title = "Contemporary Living Space",
                imageUrl = "https://plus.unsplash.com/premium_photo-1744839107780-2eefa443f4a8?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8Q29udGVtcG9yYXJ5JTIwTGl2aW5nJTIwU3BhY2V8ZW58MHx8MHx8fDA%3D",
                category = "Living Room"
            ),
            RoomDesign(
                id = "lr7",
                title = "Scandinavian Living Room",
                imageUrl = "https://plus.unsplash.com/premium_photo-1723901830004-3012de1ed13d?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8U2NhbmRpbmF2aWFuJTIwTGl2aW5nJTIwUm9vbXxlbnwwfHwwfHx8MA%3D%3D",
                category = "Living Room"
            ),
            RoomDesign(
                id = "lr8",
                title = "Industrial Modern Living",
                imageUrl = "https://plus.unsplash.com/premium_photo-1661963118331-26a530ed4637?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8SW5kdXN0cmlhbCUyME1vZGVybiUyMExpdmluZ3xlbnwwfHwwfHx8MA%3D%3D",
                category = "Living Room"
            ),
            RoomDesign(
                id = "lr9",
                title = "Minimalist Living Room",
                imageUrl = "https://images.unsplash.com/photo-1593696140826-c58b021acf8b?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTV8fE1pbmltYWxpc3QlMjBMaXZpbmclMjBSb29tfGVufDB8fDB8fHww",
                category = "Living Room"
            ),
            RoomDesign(
                id = "lr10",
                title = "Bohemian Living Space",
                imageUrl = "https://media.istockphoto.com/id/2161509009/photo/warm-and-inviting-bohemian-living-room-interior-design.webp?a=1&b=1&s=612x612&w=0&k=20&c=Cp6a9zyOIknuTIrzfWyTgSPjO80xwgN_4LYUZ-2tPJ8=",
                category = "Living Room"
            ),
            RoomDesign(
                id = "lr11",
                title = "Rustic Cozy Living",
                imageUrl = "https://images.unsplash.com/photo-1761662826410-3218852da3bf?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8UnVzdGljJTIwQ296eSUyMExpdmluZ3xlbnwwfHwwfHx8MA%3D%3D",
                category = "Living Room"
            ),
            RoomDesign(
                id = "lr12",
                title = "Eclectic Living Room",
                imageUrl = "https://plus.unsplash.com/premium_photo-1661879463320-27174a27d668?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8RWNsZWN0aWMlMjBMaXZpbmclMjBSb29tfGVufDB8fDB8fHww",
                category = "Living Room"
            )
        )
        "3" -> listOf(  // Bedroom
            RoomDesign(
                id = "bd1",
                title = "Cozy Bedroom",
                imageUrl = "https://plus.unsplash.com/premium_photo-1661963239507-7bdf41a5e66b?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8SW50ZXJpb3IlMjBEZXNpZ24lMjBCZWRyb29tfGVufDB8fDB8fHww",
                category = "Bedroom"
            ),
            RoomDesign(
                id = "bd2",
                title = "Luxury Master Suite",
                imageUrl = "https://plus.unsplash.com/premium_photo-1661877303180-19a028c21048?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8TW9kZXJuJTIwTWFzdGVyJTIwQmVkcm9vbXxlbnwwfHwwfHx8MA%3D%3D",
                category = "Bedroom"
            ),
            RoomDesign(
                id = "bd3",
                title = "Industrial Chic Bedroom",
                imageUrl = "https://media.istockphoto.com/id/2219306327/photo/urban-loft-bedroom-with-exposed-brick-and-concrete-walls.jpg?s=1024x1024&w=is&k=20&c=Q8T4kIMFZ2yhXgmL7PH0graG8-FxCnbc_cf_wBtLzmU=",
                category = "Bedroom"
            ),
            RoomDesign(
                id = "bd4",
                title = "Minimalist Zen Bedroom",
                imageUrl = "https://images.unsplash.com/photo-1765862835193-3c37388a409e?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8TWluaW1hbGlzdCUyMFplbiUyMEJlZHJvb218ZW58MHx8MHx8fDA%3D",
                category = "Bedroom"
            ),
            RoomDesign(
                id = "bd5",
                title = "Bohemian Dream Bedroom",
                imageUrl = "https://images.unsplash.com/photo-1583845112203-29329902332e?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OHx8Qm9oZW1pYW4lMjBEcmVhbSUyMEJlZHJvb218ZW58MHx8MHx8fDA%3D",
                category = "Bedroom"
            ),
            RoomDesign(
                id = "bd6",
                title = "Scandinavian Bedroom",
                imageUrl = "https://images.unsplash.com/photo-1610307522657-8c0304960189?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8U2NhbmRpbmF2aWFuJTIwQmVkcm9vbXxlbnwwfHwwfHx8MA%3D%3D",
                category = "Bedroom"
            )
        )
        "4" -> listOf(  // Kitchen
            RoomDesign(
                id = "k1",
                title = "Contemporary Kitchen",
                imageUrl = "https://images.unsplash.com/photo-1502005097973-6a7082348e28?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTd8fEludGVyaW9yJTIwRGVzaWdufGVufDB8fDB8fHww",
                category = "Kitchen"
            ),
            RoomDesign(
                id = "k2",
                title = "Bright Minimalist Kitchen",
                imageUrl = "https://images.unsplash.com/photo-1669046222569-a7672da06e12?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8QnJpZ2h0JTIwTWluaW1hbGlzdCUyMEtpdGNoZW58ZW58MHx8MHx8fDA%3D",
                category = "Kitchen"
            ),
            RoomDesign(
                id = "k3",
                title = "Gourmet Kitchen Island",
                imageUrl = "https://media.istockphoto.com/id/1337181547/photo/vaulted-ceiling-in-modern-kitchen.webp?a=1&b=1&s=612x612&w=0&k=20&c=r0oKCgHxKUg3PPkPHtQMPiNVMxCST6P8jgDtQmFQefI=",
                category = "Kitchen"
            ),
            RoomDesign(
                id = "k4",
                title = "Modern Kitchen Design",
                imageUrl = "https://plus.unsplash.com/premium_photo-1661779601614-9206e0451077?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8TW9kZXJuJTIwS2l0Y2hlbiUyMERlc2lnbnxlbnwwfHwwfHx8MA%3D%3D",
                category = "Kitchen"
            ),
            RoomDesign(
                id = "k5",
                title = "Industrial Kitchen",
                imageUrl = "https://images.unsplash.com/photo-1589109807644-924edf14ee09?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8SW5kdXN0cmlhbCUyMEtpdGNoZW58ZW58MHx8MHx8fDA%3D",
                category = "Kitchen"
            ),
            RoomDesign(
                id = "k6",
                title = "Luxury Chef's Kitchen",
                imageUrl = "https://images.unsplash.com/photo-1658280911730-467b4764c09c?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTV8fEx1eHVyeSUyMENoZWYncyUyMEtpdGNoZW58ZW58MHx8MHx8fDA%3D",
                category = "Kitchen"
            )
        )
        "5" -> listOf(  // Bathroom
            RoomDesign(
                id = "ba1",
                title = "Luxurious Bathroom",
                imageUrl = "https://plus.unsplash.com/premium_photo-1661963215502-dc2bc471ab2a?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8THV4dXJpb3VzJTIwQmF0aHJvb218ZW58MHx8MHx8fDA%3D",
                category = "Bathroom"
            ),
            RoomDesign(
                id = "ba2",
                title = "Zen Bathroom Retreat",
                imageUrl = "https://media.istockphoto.com/id/2216890622/photo/modern-boho-bathroom-with-soft-lighting.webp?a=1&b=1&s=612x612&w=0&k=20&c=uwVVl1cvbADZ3f1YAuSP0gK9Jxfa_eMGAN3F2xu9pfo=",
                category = "Bathroom"
            ),
            RoomDesign(
                id = "ba3",
                title = "Modern Spa Bathroom",
                imageUrl = "https://images.unsplash.com/photo-1771239048293-72abf673adb2?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8TW9kZXJuJTIwU3BhJTIwQmF0aHJvb218ZW58MHx8MHx8fDA%3D",
                category = "Bathroom"
            ),
            RoomDesign(
                id = "ba4",
                title = "Minimalist Bathroom",
                imageUrl = "https://plus.unsplash.com/premium_photo-1721274105657-0751a5f42eb8?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8TWluaW1hbGlzdCUyMEJhdGhyb29tfGVufDB8fDB8fHww",
                category = "Bathroom"
            ),
            RoomDesign(
                id = "ba5",
                title = "Scandinavian Bath",
                imageUrl = "https://media.istockphoto.com/id/1082345206/photo/interior-design-of-a-bathroom-3d-illustration-in-a-scandinavian-style.webp?a=1&b=1&s=612x612&w=0&k=20&c=lPz1Lit04QuScHSyL3zm__epywU61pbzpbhfZsOvxpY=",
                category = "Bathroom"
            ),
            RoomDesign(
                id = "ba6",
                title = "Contemporary Bathroom Design",
                imageUrl = "https://media.istockphoto.com/id/1152076563/photo/luxurious-bathroom.webp?a=1&b=1&s=612x612&w=0&k=20&c=NtM5hqCYBbauVKT8did24VG27fsrTKkmku8wh5EsA2o=",
                category = "Bathroom"
            )
        )
        "6" -> listOf(  // Dining Room
            RoomDesign(
                id = "dr1",
                title = "Elegant Dining",
                imageUrl = "https://images.unsplash.com/photo-1723750290151-164cb19ebab7?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8U2NhbmRpbmF2aWFuJTIwRGluaW5nJTIwUm9vbXxlbnwwfHwwfHx8MA%3D%3D",
                category = "Dining Room"
            ),
            RoomDesign(
                id = "dr2",
                title = "Modern Dining Space",
                imageUrl = "https://images.unsplash.com/photo-1760431194370-48fe900d09f7?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8TW9kZXJuJTIwRGluaW5nJTIwU3BhY2V8ZW58MHx8MHx8fDA%3D",
                category = "Dining Room"
            ),
            RoomDesign(
                id = "dr3",
                title = "Luxury Dining Room",
                imageUrl = "https://plus.unsplash.com/premium_photo-1661962461938-b3a74097d946?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8THV4dXJ5JTIwRGluaW5nJTIwUm9vbXxlbnwwfHwwfHx8MA%3D%3D",
                category = "Dining Room"
            ),
            RoomDesign(
                id = "dr4",
                title = "Industrial Dining",
                imageUrl = "https://plus.unsplash.com/premium_photo-1661962305366-0c62646fd249?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTd8fEluZHVzdHJpYWwlMjBEaW5pbmd8ZW58MHx8MHx8fDA%3D",
                category = "Dining Room"
            ),
            RoomDesign(
                id = "dr5",
                title = "Scandinavian Dining",
                imageUrl = "https://media.istockphoto.com/id/2213976761/photo/compact-black-kitchen-and-dining-area-in-scandinavian-log-cabin-with-sea-view.webp?a=1&b=1&s=612x612&w=0&k=20&c=kkTZnWqyAJ_n0Rw8x4GWwj8duGh2FFKGbPOJHlMiT20=",
                category = "Dining Room"
            ),
            RoomDesign(
                id = "dr6",
                title = "Contemporary Dining Space",
                imageUrl = "https://images.unsplash.com/photo-1771371639198-6c044fed1941?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8Q29udGVtcG9yYXJ5JTIwRGluaW5nJTIwU3BhY2V8ZW58MHx8MHx8fDA%3D",
                category = "Dining Room"
            )
        )
        "7" -> listOf(  // Nursery
            RoomDesign(
                id = "nu1",
                title = "Scandinavian Nursery",
                imageUrl = "https://images.unsplash.com/photo-1588854337127-a7cdcabfd7ac?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8TnVyc2VyeXxlbnwwfHwwfHx8MA%3D%3D",
                category = "Nursery"
            ),
            RoomDesign(
                id = "nu2",
                title = "Modern Baby Room",
                imageUrl = "https://media.istockphoto.com/id/1938954118/photo/modern-baby-room-interior-with-messy-crib-cabinet-armchair-toys-and-plants.webp?a=1&b=1&s=612x612&w=0&k=20&c=9aBy6rW4r8eRYvonDnmMmYQn3k_aokHTHq08o6fbSjc=",
                category = "Nursery"
            ),
            RoomDesign(
                id = "nu3",
                title = "Minimalist Nursery",
                imageUrl = "https://plus.unsplash.com/premium_photo-1684779979840-0285cb45ea71?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTN8fE1pbmltYWxpc3QlMjBOdXJzZXJ5fGVufDB8fDB8fHww",
                category = "Nursery"
            ),
            RoomDesign(
                id = "nu4",
                title = "Colorful Playroom",
                imageUrl = "https://media.istockphoto.com/id/940134520/photo/pastel-kids-playroom-interior.webp?a=1&b=1&s=612x612&w=0&k=20&c=qSNn_9fzSif5W2F5DAcQoRQTnoRJyokMOreF-HbD3Us=",
                category = "Nursery"
            ),
            RoomDesign(
                id = "nu5",
                title = "Soft Nursery Design",
                imageUrl = "https://media.istockphoto.com/id/1345191888/photo/cute-baby-room-interior-with-crib-and-big-window.webp?a=1&b=1&s=612x612&w=0&k=20&c=ECIWD3kepDvHXvimS62eyhRW-K9PXSD1Q_GZ4YLLoss=",
                category = "Nursery"
            ),
            RoomDesign(
                id = "nu6",
                title = "Peaceful Baby Room",
                imageUrl = "https://media.istockphoto.com/id/1174243995/photo/this-room-will-be-filled-with-laughter-and-cries-soon.webp?a=1&b=1&s=612x612&w=0&k=20&c=ZxX60iOK9jsZsL_zdMCfgMoITkfRCPTnLMdbg9ullmc=",
                category = "Nursery"
            )
        )
        "8" -> listOf(  // Office
            RoomDesign(
                id = "of1",
                title = "Professional Office",
                imageUrl = "https://plus.unsplash.com/premium_photo-1664304082823-035775a3c141?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8SW5kdXN0cmlhbCUyME9mZmljZSUyMFNwYWNlfGVufDB8fDB8fHww",
                category = "Office"
            ),
            RoomDesign(
                id = "of2",
                title = "Contemporary Home Office",
                imageUrl = "https://plus.unsplash.com/premium_photo-1676823552727-89722eb5f72e?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8Q29udGVtcG9yYXJ5JTIwSG9tZSUyME9mZmljZXxlbnwwfHwwfHx8MA%3D%3D",
                category = "Office"
            ),
            RoomDesign(
                id = "of3",
                title = "Minimalist Office",
                imageUrl = "https://images.unsplash.com/photo-1718220216044-006f43e3a9b1?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8N3x8TWluaW1hbGlzdCUyME9mZmljZXxlbnwwfHwwfHx8MA%3D%3D",
                category = "Office"
            ),
            RoomDesign(
                id = "of4",
                title = "Creative Workspace",
                imageUrl = "https://images.unsplash.com/photo-1693159682618-074078ed271e?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8Q3JlYXRpdmUlMjBXb3Jrc3BhY2V8ZW58MHx8MHx8fDA%3D",
                category = "Office"
            ),
            RoomDesign(
                id = "of5",
                title = "Modern Startup Office",
                imageUrl = "https://images.unsplash.com/photo-1558959356-2f36c7322d3b?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTF8fE1vZGVybiUyMFN0YXJ0dXAlMjBPZmZpY2V8ZW58MHx8MHx8fDA%3D",
                category = "Office"
            ),
            RoomDesign(
                id = "of6",
                title = "Productive Home Desk",
                imageUrl = "https://images.unsplash.com/photo-1623916799434-114e844becc2?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8UHJvZHVjdGl2ZSUyMEhvbWUlMjBEZXNrfGVufDB8fDB8fHww",
                category = "Office"
            )
        )
        else -> listOf(
            RoomDesign(
                id = "default",
                title = "Design",
                imageUrl = "https://plus.unsplash.com/premium_photo-1664300969611-f3745a737234?w=500&auto=format&fit=crop&q=60",
                category = "Design"
            )
        )
    }

    fun getMockDesignById(designId: String): Design {
        return when (designId) {
            "d1" -> Design(
                id = "d1",
                title = "Transitional Living Room",
                description = "A perfect blend of traditional and modern styles. Features comfortable seating, elegant lighting fixtures, and a sophisticated color palette that creates a welcoming atmosphere.",
                imageUrl = "https://images.unsplash.com/photo-1555041469-a586c61ea9bc?w=500&h=500&fit=crop",
                category = "Serenba, Georgia"
            )
            "d2" -> Design(
                id = "d2",
                title = "Minimalist Kitchen",
                description = "A sleek and modern kitchen design with clean lines and minimalist aesthetics. Perfect for contemporary homes looking for functionality and style. Features white cabinetry and stainless steel appliances.",
                imageUrl = "https://images.unsplash.com/photo-1556909114-f6e7ad7d3136?w=500&h=500&fit=crop",
                category = "Cairo, Egypt"
            )
            "d3" -> Design(
                id = "d3",
                title = "Modern Bedroom",
                description = "Experience luxury and comfort with this modern bedroom design. Features contemporary furniture and sophisticated color palette with neutral tones and natural textures.",
                imageUrl = "https://images.unsplash.com/photo-1540932239986-310128078ceb?w=500&h=500&fit=crop",
                category = "Alexandria, Egypt"
            )
            "d4" -> Design(
                id = "d4",
                title = "Contemporary Office",
                description = "Professional workspace designed for productivity. Modern office setup with ergonomic furniture, inspiring atmosphere, and natural lighting.",
                imageUrl = "https://images.unsplash.com/photo-1497366216548-37526070297c?w=500&h=500&fit=crop",
                category = "Giza, Egypt"
            )
            "d5" -> Design(
                id = "d5",
                title = "Elegant Living Room",
                description = "Timeless elegance meets comfort in this beautifully designed living room. Perfect for entertaining guests with premium furniture and sophisticated decor.",
                imageUrl = "https://images.unsplash.com/photo-1555041469-a586c61ea9bc?w=500&h=500&fit=crop",
                category = "Serenba, Georgia"
            )
            "d6" -> Design(
                id = "d6",
                title = "Classic Bedroom",
                description = "Traditional design with a contemporary twist. This bedroom combines classic elements with modern comfort and neutral color schemes.",
                imageUrl = "https://images.unsplash.com/photo-1540932239986-310128078ceb?w=500&h=500&fit=crop",
                category = "Alexandria, Egypt"
            )
            "d7" -> Design(
                id = "d7",
                title = "Bohemian Bedroom",
                description = "Free-spirited and colorful bedroom design with eclectic furniture and artistic touches. Features unique textures, vibrant colors, and global-inspired decor.",
                imageUrl = "https://images.unsplash.com/photo-1486312338219-ce68d2c6f44d?w=500&h=500&fit=crop",
                category = "Alexandria, Egypt"
            )
            "d8" -> Design(
                id = "d8",
                title = "Eclectic Living Room",
                description = "A unique blend of different styles and colors creating a vibrant and welcoming living space. Mix of vintage and modern elements with artistic flair.",
                imageUrl = "https://images.unsplash.com/photo-1555041469-a586c61ea9bc?w=500&h=500&fit=crop",
                category = "Serenba, Georgia"
            )
            "d9" -> Design(
                id = "d9",
                title = "Zen Bedroom",
                description = "Calm and peaceful bedroom design promoting relaxation and tranquility. Perfect for a good night's sleep with minimalist aesthetics and natural materials.",
                imageUrl = "https://images.unsplash.com/photo-1540932239986-310128078ceb?w=500&h=500&fit=crop",
                category = "Alexandria, Egypt"
            )
            "d10" -> Design(
                id = "d10",
                title = "Minimalist Living",
                description = "Simplified living space with essential furniture only. Clean, organized, and visually appealing design emphasizing negative space and simplicity.",
                imageUrl = "https://images.unsplash.com/photo-1555041469-a586c61ea9bc?w=500&h=500&fit=crop",
                category = "Serenba, Georgia"
            )
            "d11" -> Design(
                id = "d11",
                title = "Mediterranean Kitchen",
                description = "Warm and inviting kitchen with terracotta accents, natural wood, and rustic charm. Features traditional styling with modern convenience.",
                imageUrl = "https://images.unsplash.com/photo-1556909114-f6e7ad7d3136?w=500&h=500&fit=crop",
                category = "Cairo, Egypt"
            )
            "d12" -> Design(
                id = "d12",
                title = "Industrial Loft",
                description = "Trendy industrial design with exposed brick, metal accents, and concrete floors. Perfect for creative professionals and modern living.",
                imageUrl = "https://images.unsplash.com/photo-1497366216548-37526070297c?w=500&h=500&fit=crop",
                category = "New Cairo, Egypt"
            )
            else -> Design(
                id = "default",
                title = "Design Details",
                description = "Beautiful interior design that brings together style and functionality",
                imageUrl = "https://images.unsplash.com/photo-1555041469-a586c61ea9bc?w=500&h=500&fit=crop",
                category = "Unknown"
            )
        }
    }
}