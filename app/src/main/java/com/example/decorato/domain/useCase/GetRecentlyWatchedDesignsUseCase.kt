package com.example.decorato.domain.useCase

import com.example.decorato.domain.entity.RecentlyWatchedDesign
import com.example.decorato.domain.repository.DesignRepository
import javax.inject.Inject

class GetRecentlyWatchedDesignsUseCase @Inject constructor(
    private val designRepository: DesignRepository
) {
    suspend operator fun invoke(): List<RecentlyWatchedDesign> {
        return designRepository.getRecentlyWatchedDesigns()
    }
}