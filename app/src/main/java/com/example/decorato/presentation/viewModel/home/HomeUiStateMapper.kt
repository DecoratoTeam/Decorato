package com.example.decorato.presentation.viewModel.home

import com.example.decorato.domain.entity.Design
import com.example.decorato.domain.entity.RecentlyWatchedDesign
import com.example.decorato.domain.entity.Style
import com.example.decorato.presentation.viewModel.home.section.PopularItemUiState
import com.example.decorato.presentation.viewModel.home.section.PopularSectionUiState
import com.example.decorato.presentation.viewModel.home.section.RecentlyWatchedItemUiState
import com.example.decorato.presentation.viewModel.home.section.RecentlyWatchedSectionUiState
import com.example.decorato.presentation.viewModel.home.section.StyleItemUiState
import com.example.decorato.presentation.viewModel.home.section.StyleSectionUiState
import javax.inject.Inject

class HomeUiStateMapper @Inject constructor() {

    fun toPopularSectionUiState(
        designs: List<Design>,
        isLoading: Boolean = false
    ): PopularSectionUiState {
        return PopularSectionUiState(
            items = designs.map { toPopularItemUiState(it) },
            isLoading = isLoading
        )
    }

    fun toPopularItemUiState(design: Design): PopularItemUiState {
        return PopularItemUiState(
            id = design.id,
            title = design.title,
            description = design.description,
            imageUrl = design.imageUrl,
            category = design.category
        )
    }

    fun toRecentlyWatchedSectionUiState(
        designs: List<RecentlyWatchedDesign>,
        isLoading: Boolean = false
    ): RecentlyWatchedSectionUiState {
        return RecentlyWatchedSectionUiState(
            items = designs.map { toRecentlyWatchedItemUiState(it) },
            isLoading = isLoading
        )
    }

    fun toRecentlyWatchedItemUiState(design: RecentlyWatchedDesign): RecentlyWatchedItemUiState {
        return RecentlyWatchedItemUiState(
            id = design.id,
            title = design.title,
            location = design.location,
            imageUrl = design.imageUrl,
            category = design.category
        )
    }

    fun toStyleSectionUiState(
        styles: List<Style>,
        isLoading: Boolean = false
    ): StyleSectionUiState {
        return StyleSectionUiState(
            items = styles.map { toStyleItemUiState(it) },
            isLoading = isLoading
        )
    }

    fun toStyleItemUiState(style: Style): StyleItemUiState {
        return StyleItemUiState(
            id = style.id,
            name = style.name,
            imageUrl = style.imageUrl,
            imageRes = style.imageRes
        )
    }
}