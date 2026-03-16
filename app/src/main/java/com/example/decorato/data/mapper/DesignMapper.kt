package com.example.decorato.data.mapper


import com.example.decorato.data.remote.dto.DesignDto
import com.example.decorato.data.remote.dto.RecentlyWatchedDesignDto
import com.example.decorato.domain.entity.Design
import com.example.decorato.domain.entity.RecentlyWatchedDesign
import com.example.decorato.domain.entity.RoomDesign
import javax.inject.Inject

class DesignMapper @Inject constructor() {

    fun mapToDesign(dto: DesignDto): Design {
        return Design(
            id = dto.id,
            title = dto.title,
            description = dto.description,
            imageUrl = dto.imageUrl,
            category = dto.category,
            createdAt = dto.createdAt
        )
    }

    fun mapToRecentlyWatchedDesign(dto: RecentlyWatchedDesignDto): RecentlyWatchedDesign {
        return RecentlyWatchedDesign(
            id = dto.id,
            title = dto.title,
            location = dto.location,
            imageUrl = dto.imageUrl,
            category = dto.category,
            watchedAt = dto.watchedAt
        )
    }

    fun mapToRoomDesign(dto: DesignDto): RoomDesign {
        return RoomDesign(
            id = dto.id,
            title = dto.title,
            imageUrl = dto.imageUrl,
            category = dto.category
        )
    }
}