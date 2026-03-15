package com.example.decorato.domain.useCase

import com.example.decorato.data.repository.mock.MockDesignRepository
import com.example.decorato.domain.entity.RoomDesign
import javax.inject.Inject

class GetRoomDesignsByTypeUseCase @Inject constructor() {
    suspend operator fun invoke(roomTypeId: String): List<RoomDesign> {
        return MockDesignRepository.getRoomDesignsByType(roomTypeId)
    }
}