package com.example.decorato.domain.useCase

import com.example.decorato.domain.entity.RoomDesign
import com.example.decorato.domain.repository.StyleDetailsRepository
import javax.inject.Inject

class GetDesignsByStyleUseCase @Inject constructor(
    private val styleDetailsRepository: StyleDetailsRepository
) {
    suspend operator fun invoke(styleId: String): List<RoomDesign> {
        return styleDetailsRepository.getDesignsByStyle(styleId)
    }
}