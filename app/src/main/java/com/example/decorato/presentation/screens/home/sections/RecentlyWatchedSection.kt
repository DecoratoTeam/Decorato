package com.example.decorato.presentation.screens.home.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage
import com.example.decorato.R
import com.example.decorato.presentation.components.DesignCard
import com.example.decorato.presentation.components.SectionTitle
import com.example.decorato.presentation.screens.home.sections.placeHolder.designSectionPlaceholder
import com.example.decorato.presentation.theme.DecoratoTheme
import com.example.decorato.presentation.utils.ThemeAndLocalePreviews
import com.example.decorato.presentation.viewModel.home.section.RecentlyWatchedItemUiState
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
                    title = stringResource(R.string.recentlyWatched),
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

// ==================== PREVIEW ====================

@ThemeAndLocalePreviews
@Composable
private fun RecentlyWatchedSectionPreview() {
    val dummyDesigns = List(5) {
        RecentlyWatchedItemUiState(
            id = "${it + 1}",
            title = when(it) {
                0 -> "Modern Kitchen"
                1 -> "Cozy Living Room"
                2 -> "Minimalist Bedroom"
                3 -> "Elegant Bathroom"
                else -> "Contemporary Office"
            },
            imageUrl = "https://images.unsplash.com/photo-1556912167-f556f1f39faa?w=500",
            location = when(it) {
                0 -> "Cairo, Egypt"
                1 -> "Alexandria, Egypt"
                2 -> "Giza, Egypt"
                3 -> "Luxor, Egypt"
                else -> "Aswan, Egypt"
            },
            category = when(it) {
                0 -> "Kitchen"
                1 -> "Living Room"
                2 -> "Bedroom"
                3 -> "Bathroom"
                else -> "Office"
            }
        )
    }

    DecoratoTheme {
        LazyColumn {
            recentlyWatchedSection(
                state = RecentlyWatchedSectionUiState(
                    items = dummyDesigns,
                    isLoading = false
                ),
                isVisible = true,
                onClickDesignItem = {},
                onClickShowAll = {}
            )
        }
    }
}

@ThemeAndLocalePreviews
@Composable
private fun RecentlyWatchedSectionLoadingPreview() {
    DecoratoTheme {
        LazyColumn {
            recentlyWatchedSection(
                state = RecentlyWatchedSectionUiState(
                    items = emptyList(),
                    isLoading = true
                ),
                isVisible = true,
                onClickDesignItem = {},
                onClickShowAll = {}
            )
        }
    }
}

@ThemeAndLocalePreviews
@Composable
private fun RecentlyWatchedSectionEmptyPreview() {
    DecoratoTheme {
        LazyColumn {
            recentlyWatchedSection(
                state = RecentlyWatchedSectionUiState(
                    items = emptyList(),
                    isLoading = false
                ),
                isVisible = false,
                onClickDesignItem = {},
                onClickShowAll = {}
            )
        }
    }
}