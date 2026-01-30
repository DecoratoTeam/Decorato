package com.example.decorato.domain.useCase

import com.example.decorato.domain.entity.Style
import com.example.decorato.domain.repository.StyleRepository
import javax.inject.Inject

class GetStylesUseCase @Inject constructor(
    private val styleRepository: StyleRepository
) {
    suspend operator fun invoke(): List<Style> {
        return styleRepository.getStyles()
    }
}