package com.example.decorato.data.repositoryImpl

import com.example.decorato.domain.entity.RoomType
import com.example.decorato.domain.entity.RoomDesign
import com.example.decorato.domain.repository.RoomTypeRepository
import javax.inject.Inject

class RoomTypeRepositoryImpl @Inject constructor() : RoomTypeRepository {

    override suspend fun getRoomTypes(): List<RoomType> {
        return listOf(
            RoomType(id = "1", name = "All", isSelected = true),
            RoomType(id = "2", name = "Living Room"),
            RoomType(id = "3", name = "Bedroom"),
            RoomType(id = "4", name = "Kitchen"),
            RoomType(id = "5", name = "Bathroom"),
            RoomType(id = "6", name = "Dining Room"),
            RoomType(id = "7", name = "Nursery"),
            RoomType(id = "8", name = "Office")
        )
    }

    override suspend fun getRoomDesignsByType(roomTypeId: String): List<RoomDesign> {
        return listOf(
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
    }
}