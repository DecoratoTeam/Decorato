package com.example.decorato.domain.useCase

import com.example.decorato.domain.repository.MockDesignRepository
import com.example.decorato.domain.entity.Style
import javax.inject.Inject

class GetStylesUseCase @Inject constructor() {
    suspend operator fun invoke(): List<Style> {
        return MockDesignRepository.getStyles()
    }
}