package com.example.decorato.domain.useCase

import com.example.decorato.domain.repository.MockDesignRepository
import com.example.decorato.domain.entity.Design
import javax.inject.Inject

class GetDesignByIdUseCase @Inject constructor() {
    suspend operator fun invoke(designId: String): Design {
        return MockDesignRepository.getMockDesignById(designId)
    }
}