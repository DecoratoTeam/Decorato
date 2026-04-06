package com.example.decorato.presentation.screens.home.sections

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.decorato.presentation.screens.home.component.RoomDesignCard
import com.example.decorato.presentation.screens.home.sections.placeHolder.stylePlaceholder
import com.example.decorato.presentation.viewModel.home.section.RoomDesignsSectionUiState

fun LazyListScope.roomDesignsSection(
    state: RoomDesignsSectionUiState,
    onClickRoomDesign: (String) -> Unit,
    isVisible: Boolean
) {
    if (isVisible) {
        if (state.isLoading) {
            stylePlaceholder()
        } else if (state.items.isEmpty()) {
            return
        } else {
            items(state.items) { item ->
                RoomDesignCard(
                    item = item,
                    onClick = { onClickRoomDesign(item.id) },
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
        }
    }
}