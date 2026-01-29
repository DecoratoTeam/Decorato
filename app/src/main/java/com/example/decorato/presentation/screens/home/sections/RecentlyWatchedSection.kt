package com.example.decorato.presentation.screens.home.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage
import com.example.decorato.presentation.components.DesignCard
import com.example.decorato.presentation.components.SectionTitle
import com.example.decorato.presentation.screens.home.sections.placeHolder.designSectionPlaceholder
import com.example.decorato.presentation.viewModel.home.section.RecentlyWatchedSectionUiState


fun LazyListScope.recentlyWatchedSection(
    state: RecentlyWatchedSectionUiState,
    isVisible: Boolean,
    onClickDesignItem: (String) -> Unit,
    onClickShowAll: () -> Unit,
) {
    if (isVisible) {
        if (state.isLoading) {
            designSectionPlaceholder()
        } else {
            item {
                SectionTitle(
                    title = "Recently Watched",
                    modifier = Modifier
                        .zIndex(1f)
                        .padding(top = 24.dp, bottom = 12.dp),
                    showAllLabel = true,
                    onAllLabelClicked = onClickShowAll
                )
            }
            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp),
                ) {
                    items(state.items) { item ->
                        DesignCard(
                            designImage = { DesignImage(item.imageUrl) },
                            designTitle = item.title,
                            designLocation = item.location,
                            designCategory = item.category
                        ) {
                            onClickDesignItem(item.id)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DesignImage(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = imageUrl,
        contentDescription = null,
        modifier = modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}