package com.example.decorato.domain.repository

import com.example.decorato.domain.entity.RoomDesign

interface StyleDetailsRepository {
    suspend fun getDesignsByStyle(styleId: String): List<RoomDesign>
}