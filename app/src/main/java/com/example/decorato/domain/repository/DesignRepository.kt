package com.example.decorato.domain.repository

import com.example.decorato.domain.entity.Design
import com.example.decorato.domain.entity.RecentlyWatchedDesign
import com.example.decorato.domain.entity.RoomDesign

interface DesignRepository {
    suspend fun getPopularDesigns(): List<Design>
    suspend fun getRecentlyWatchedDesigns(): List<RecentlyWatchedDesign>
    suspend fun getDesignsByStyle(styleId: String): List<RoomDesign>
    suspend fun getDesignById(designId: String): Design
}