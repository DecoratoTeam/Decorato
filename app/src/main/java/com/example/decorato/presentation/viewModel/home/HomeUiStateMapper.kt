package com.example.decorato.presentation.viewModel.home

import com.example.decorato.domain.entity.Design
import com.example.decorato.domain.entity.RecentlyWatchedDesign
import com.example.decorato.domain.entity.RoomDesign
import com.example.decorato.domain.entity.RoomType
import com.example.decorato.domain.entity.Style
import com.example.decorato.presentation.viewModel.home.section.PopularItemUiState
import com.example.decorato.presentation.viewModel.home.section.PopularSectionUiState
import com.example.decorato.presentation.viewModel.home.section.RecentlyWatchedItemUiState
import com.example.decorato.presentation.viewModel.home.section.RecentlyWatchedSectionUiState
import com.example.decorato.presentation.viewModel.home.section.RoomDesignItemUiState
import com.example.decorato.presentation.viewModel.home.section.RoomDesignsSectionUiState
import com.example.decorato.presentation.viewModel.home.section.RoomTypeItemUiState
import com.example.decorato.presentation.viewModel.home.section.RoomTypeSectionUiState
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

    fun toRoomTypeSectionUiState(
        roomTypes: List<RoomType>,
        isLoading: Boolean = false
    ): RoomTypeSectionUiState {
        return RoomTypeSectionUiState(
            items = roomTypes.map { toRoomTypeItemUiState(it) },
            selectedRoomTypeId = roomTypes.firstOrNull { it.isSelected }?.id ?: "1",
            isLoading = isLoading
        )
    }

    fun toRoomTypeItemUiState(roomType: RoomType): RoomTypeItemUiState {
        return RoomTypeItemUiState(
            id = roomType.id,
            name = roomType.name,
            isSelected = roomType.isSelected
        )
    }

    fun toRoomDesignsSectionUiState(
        roomDesigns: List<RoomDesign>,
        isLoading: Boolean = false
    ): RoomDesignsSectionUiState {
        return RoomDesignsSectionUiState(
            items = roomDesigns.map { toRoomDesignItemUiState(it) },
            isLoading = isLoading
        )
    }

    fun toRoomDesignItemUiState(roomDesign: RoomDesign): RoomDesignItemUiState {
        return RoomDesignItemUiState(
            id = roomDesign.id,
            title = roomDesign.title,
            imageUrl = roomDesign.imageUrl,
            category = roomDesign.category
        )
    }
}