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
            title = "Modern Living Room",
            imageUrl = "https://plus.unsplash.com/premium_photo-1664300969611-f3745a737234?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1yZWxhdGVkfDV8fHxlbnwwfHx8fHw%3D",
            category = "Serenba, Georgia"
        ),
        RoomDesign(
            id = "d2",
            title = "Minimalist Kitchen",
            imageUrl = "https://images.unsplash.com/photo-1669046222569-a7672da06e12?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8QnJpZ2h0JTIwTWluaW1hbGlzdCUyMEtpdGNoZW58ZW58MHx8MHx8fDA%3D",
            category = "Cairo, Egypt"
        ),
        RoomDesign(
            id = "d3",
            title = "Modern Bedroom",
            imageUrl = "https://plus.unsplash.com/premium_photo-1661877303180-19a028c21048?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8TW9kZXJuJTIwTWFzdGVyJTIwQmVkcm9vbXxlbnwwfHwwfHx8MA%3D%3D",
            category = "Alexandria, Egypt"
        ),
        RoomDesign(
            id = "d4",
            title = "Contemporary Office",
            imageUrl = "https://plus.unsplash.com/premium_photo-1676823552727-89722eb5f72e?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8Q29udGVtcG9yYXJ5JTIwSG9tZSUyME9mZmljZXxlbnwwfHwwfHx8MA%3D%3D",
            category = "Giza, Egypt"
        ),
        RoomDesign(
            id = "d5",
            title = "Sleek Bathroom",
            imageUrl = "https://plus.unsplash.com/premium_photo-1661963215502-dc2bc471ab2a?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8THV4dXJpb3VzJTIwQmF0aHJvb208ZW58MHx8MHx8fDA%3D",
            category = "Cairo, Egypt"
        ),
        RoomDesign(
            id = "d6",
            title = "Industrial Modern Living",
            imageUrl = "https://plus.unsplash.com/premium_photo-1661963118331-26a530ed4637?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8SW5kdXN0cmlhbCUyME1vZGVybiUyMExpdmluZ3xlbnwwfHwwfHx8MA%3D%3D",
            category = "New Cairo, Egypt"
        ),
        RoomDesign(
            id = "d7",
            title = "Modern Dining Space",
            imageUrl = "https://images.unsplash.com/photo-1760431194370-48fe900d09f7?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8TW9kZXJuJTIwRGluaW5nJTIwU3BhY2V8ZW58MHx8MHx8fDA%3D",
            category = "Cairo, Egypt"
        ),
        RoomDesign(
            id = "d8",
            title = "Contemporary Kitchen Design",
            imageUrl = "https://plus.unsplash.com/premium_photo-1661779601614-9206e0451077?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8TW9kZXJuJTIwS2l0Y2hlbiUyMERlc2lnbnxlbnwwfHwwfHx8MA%3D%3D",
            category = "Alexandria, Egypt"
        ),
        RoomDesign(
            id = "d9",
            title = "Minimalist Living Room",
            imageUrl = "https://images.unsplash.com/photo-1593696140826-c58b021acf8b?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTV8fE1pbmltYWxpc3QlMjBMaXZpbmclMjBSb29tfGVufDB8fDB8fHww",
            category = "Giza, Egypt"
        )
    )

    private fun getMockClassicDesigns(): List<RoomDesign> = listOf(
        RoomDesign(
            id = "d10",
            title = "Elegant Living Room",
            imageUrl = "https://plus.unsplash.com/premium_photo-1733320822557-e4ccfb5f20d1?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8THV4dXJ5JTIwUGVudGhvdXNlJTIwTGl2aW5nfGVufDB8fDB8fHww",
            category = "Serenba, Georgia"
        ),
        RoomDesign(
            id = "d11",
            title = "Classic Bedroom",
            imageUrl = "https://images.unsplash.com/photo-1610307522657-8c0304960189?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8U2NhbmRpbmF2aWFuJTIwQmVkcm9vbXxlbnwwfHwwfHx8MA%3D%3D",
            category = "Alexandria, Egypt"
        ),
        RoomDesign(
            id = "d12",
            title = "Traditional Dining",
            imageUrl = "https://images.unsplash.com/photo-1723750290151-164cb19ebab7?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8U2NhbmRpbmF2aWFuJTIwRGluaW5nJTIwUm9vbXxlbnwwfHwwfHx8MA%3D%3D",
            category = "Cairo, Egypt"
        ),
        RoomDesign(
            id = "d13",
            title = "Vintage Office",
            imageUrl = "https://plus.unsplash.com/premium_photo-1664304082823-035775a3c141?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8SW5kdXN0cmlhbCUyME9mZmljZSUyMFNwYWNlfGVufDB8fDB8fHww",
            category = "Giza, Egypt"
        ),
        RoomDesign(
            id = "d14",
            title = "Luxury Dining Room",
            imageUrl = "https://plus.unsplash.com/premium_photo-1661962461938-b3a74097d946?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8THV4dXJ5JTIwRGluaW5nJTIwUm9vbXxlbnwwfHwwfHx8MA%3D%3D",
            category = "New Cairo, Egypt"
        ),
        RoomDesign(
            id = "d15",
            title = "Classic Kitchen",
            imageUrl = "https://images.unsplash.com/photo-1556909114-f6e7ad7d3136?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8Q2xhc3NpYyUyMEtpdGNoZW58ZW58MHx8MHx8fDA%3D",
            category = "Cairo, Egypt"
        ),
        RoomDesign(
            id = "d16",
            title = "Elegant Bathroom",
            imageUrl = "https://media.istockphoto.com/id/1152076563/photo/luxurious-bathroom.webp?a=1&b=1&s=612x612&w=0&k=20&c=NtM5hqCYBbauVKT8did24VG27fsrTKkmku8wh5EsA2o=",
            category = "Alexandria, Egypt"
        ),
        RoomDesign(
            id = "d17",
            title = "Formal Living Space",
            imageUrl = "https://images.unsplash.com/photo-1757439402190-99b73ac8e807?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8TWVkaXRlcnJhbmVhbiUyMExpdmluZyUyMFNwYWNlfGVufDB8fDB8fHww",
            category = "Giza, Egypt"
        )
    )

    private fun getMockBohemianDesigns(): List<RoomDesign> = listOf(
        RoomDesign(
            id = "d18",
            title = "Bohemian Bedroom",
            imageUrl = "https://images.unsplash.com/photo-1583845112203-29329902332e?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OHx8Qm9oZW1pYW4lMjBEcmVhbSUyMEJlZHJvb218ZW58MHx8MHx8fDA%3D",
            category = "Alexandria, Egypt"
        ),
        RoomDesign(
            id = "d19",
            title = "Eclectic Living Room",
            imageUrl = "https://media.istockphoto.com/id/2161509009/photo/warm-and-inviting-bohemian-living-room-interior-design.webp?a=1&b=1&s=612x612&w=0&k=20&c=Cp6a9zyOIknuTIrzfWyTgSPjO80xwgN_4LYUZ-2tPJ8=",
            category = "Serenba, Georgia"
        ),
        RoomDesign(
            id = "d20",
            title = "Artistic Studio",
            imageUrl = "https://images.unsplash.com/photo-1764010533326-c6916f3d6252?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8QXJ0aXN0aWMlMjBMaXZpbmclMjBHYWxsZXJ5fGVufDB8fDB8fHww",
            category = "Cairo, Egypt"
        ),
        RoomDesign(
            id = "d21",
            title = "Colorful Kitchen",
            imageUrl = "https://images.unsplash.com/photo-1656909925227-aaf71b0c8e5b?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8Q29sb3JmdWwlMjBLaXRjaGVufGVufDB8fDB8fHww",
            category = "New Cairo, Egypt"
        ),
        RoomDesign(
            id = "d22",
            title = "Bohemian Dining",
            imageUrl = "https://images.unsplash.com/photo-1495521821757-a1efb6729352?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8Qm9oZW1pYW58ZW58MHx8MHx8fDA%3D",
            category = "Cairo, Egypt"
        ),
        RoomDesign(
            id = "d23",
            title = "Vibrant Living Space",
            imageUrl = "https://images.unsplash.com/photo-1486312338219-ce68d2c6f44d?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8Qm9oZW1pYW4lMjBCZWRyb29tfGVufDB8fDB8fHww",
            category = "Alexandria, Egypt"
        ),
        RoomDesign(
            id = "d24",
            title = "Eclectic Office Space",
            imageUrl = "https://images.unsplash.com/photo-1693159682618-074078ed271e?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8Q3JlYXRpdmUlMjBXb3Jrc3BhY2V8ZW58MHx8MHx8fDA%3D",
            category = "Giza, Egypt"
        ),
        RoomDesign(
            id = "d25",
            title = "Bohemian Bathroom",
            imageUrl = "https://media.istockphoto.com/id/2216890622/photo/modern-boho-bathroom-with-soft-lighting.webp?a=1&b=1&s=612x612&w=0&k=20&c=uwVVl1cvbADZ3f1YAuSP0gK9Jxfa_eMGAN3F2xu9pfo=",
            category = "New Cairo, Egypt"
        )
    )

    private fun getMockMinimalistDesigns(): List<RoomDesign> = listOf(
        RoomDesign(
            id = "d26",
            title = "Zen Bedroom",
            imageUrl = "https://images.unsplash.com/photo-1765862835193-3c37388a409e?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8TWluaW1hbGlzdCUyMFplbiUyMEJlZHJvb218ZW58MHx8MHx8fDA%3D",
            category = "Alexandria, Egypt"
        ),
        RoomDesign(
            id = "d27",
            title = "Minimalist Living",
            imageUrl = "https://images.unsplash.com/photo-1593696140826-c58b021acf8b?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTV8fE1pbmltYWxpc3QlMjBMaXZpbmclMjBSb29tfGVufDB8fDB8fHww",
            category = "Serenba, Georgia"
        ),
        RoomDesign(
            id = "d28",
            title = "Clean Office",
            imageUrl = "https://images.unsplash.com/photo-1718220216044-006f43e3a9b1?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8N3x8TWluaW1hbGlzdCUyME9mZmljZXxlbnwwfHwwfHx8MA%3D%3D",
            category = "Cairo, Egypt"
        ),
        RoomDesign(
            id = "d29",
            title = "Simple Kitchen",
            imageUrl = "https://images.unsplash.com/photo-1669046222569-a7672da06e12?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8QnJpZ2h0JTIwTWluaW1hbGlzdCUyMEtpdGNoZW58ZW58MHx8MHx8fDA%3D",
            category = "Giza, Egypt"
        ),
        RoomDesign(
            id = "d30",
            title = "Calm Bathroom",
            imageUrl = "https://plus.unsplash.com/premium_photo-1721274105657-0751a5f42eb8?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8TWluaW1hbGlzdCUyMEJhdGhyb29tfGVufDB8fDB8fHww",
            category = "New Cairo, Egypt"
        ),
        RoomDesign(
            id = "d31",
            title = "Minimal Dining",
            imageUrl = "https://plus.unsplash.com/premium_photo-1721274105657-0751a5f42eb8?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8TWluaW1hbGlzdCUyMERpbmluZ3xlbnwwfHwwfHx8MA%3D%3D",
            category = "Cairo, Egypt"
        ),
        RoomDesign(
            id = "d32",
            title = "Minimalist Workspace",
            imageUrl = "https://images.unsplash.com/photo-1623916799434-114e844becc2?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8UHJvZHVjdGl2ZSUyMEhvbWUlMjBEZXNrfGVufDB8fDB8fHww",
            category = "Alexandria, Egypt"
        ),
        RoomDesign(
            id = "d33",
            title = "Pure White Interior",
            imageUrl = "https://images.unsplash.com/photo-1576941160550-2173dba999ef?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8TWluaW1hbGlzdCUyMExpdmluZ3xlbnwwfHwwfHx8MA%3D%3D",
            category = "Giza, Egypt"
        )
    )
}