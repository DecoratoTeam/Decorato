package com.example.decorato.domain.useCase

import com.example.decorato.domain.repository.MockDesignRepository
import com.example.decorato.domain.entity.Design
import javax.inject.Inject

class GetPopularDesignsUseCase @Inject constructor() {
    suspend operator fun invoke(): List<Design> {
        return MockDesignRepository.getPopularDesigns()
    }
}