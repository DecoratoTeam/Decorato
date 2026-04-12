package com.example.decorato.domain.useCase

import com.example.decorato.domain.repository.MockDesignRepository
import com.example.decorato.domain.entity.RoomType
import javax.inject.Inject

class GetRoomTypesUseCase @Inject constructor() {
    suspend operator fun invoke(): List<RoomType> {
        return MockDesignRepository.getRoomTypes()
    }
}