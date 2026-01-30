package com.example.decorato.domain.useCase

import com.example.decorato.domain.entity.Design
import com.example.decorato.domain.repository.DesignRepository
import javax.inject.Inject

class GetPopularDesignsUseCase @Inject constructor(
    private val designRepository: DesignRepository
) {
    suspend operator fun invoke(): List<Design> {
        return designRepository.getPopularDesigns()
    }
}