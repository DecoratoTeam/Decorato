package com.example.decorato.domain.useCase

import com.example.decorato.domain.repository.MockDesignRepository
import com.example.decorato.domain.entity.RecentlyWatchedDesign
import javax.inject.Inject

class GetRecentlyWatchedDesignsUseCase @Inject constructor() {
    suspend operator fun invoke(): List<RecentlyWatchedDesign> {
        return MockDesignRepository.getRecentlyWatchedDesigns()
    }
}