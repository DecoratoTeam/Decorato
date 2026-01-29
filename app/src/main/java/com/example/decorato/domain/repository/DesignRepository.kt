package com.example.decorato.domain.repository

import com.example.decorato.domain.entity.Design
import com.example.decorato.domain.entity.RecentlyWatchedDesign

interface DesignRepository {
    suspend fun getPopularDesigns(): List<Design>
    suspend fun getRecentlyWatchedDesigns(): List<RecentlyWatchedDesign>
}