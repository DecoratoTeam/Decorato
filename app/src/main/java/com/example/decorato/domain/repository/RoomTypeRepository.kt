package com.example.decorato.domain.repository

import com.example.decorato.domain.entity.RoomType
import com.example.decorato.domain.entity.RoomDesign

interface RoomTypeRepository {
    suspend fun getRoomTypes(): List<RoomType>
    suspend fun getRoomDesignsByType(roomTypeId: String): List<RoomDesign>
}