package com.example.decorato.presentation.viewModel.home.section

data class RoomTypeSectionUiState(
    val items: List<RoomTypeItemUiState> = emptyList(),
    val selectedRoomTypeId: String = "1",
    val isLoading: Boolean = false
)

data class RoomTypeItemUiState(
    val id: String,
    val name: String,
    val isSelected: Boolean = false
)

data class RoomDesignsSectionUiState(
    val items: List<RoomDesignItemUiState> = emptyList(),
    val isLoading: Boolean = false
)

data class RoomDesignItemUiState(
    val id: String,
    val title: String,
    val imageUrl: String,
    val category: String
)