package com.example.decorato.presentation.screens.home.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.decorato.R
import com.example.decorato.presentation.components.SectionTitle
import com.example.decorato.presentation.screens.home.component.StyleCard
import com.example.decorato.presentation.screens.home.sections.placeHolder.stylePlaceholder
import com.example.decorato.presentation.theme.DecoratoTheme
import com.example.decorato.presentation.utils.ThemeAndLocalePreviews
import com.example.decorato.presentation.viewModel.home.section.StyleItemUiState
import com.example.decorato.presentation.viewModel.home.section.StyleSectionUiState

fun LazyListScope.styleSection(
    state: StyleSectionUiState,
    isVisible: Boolean,
    onClickStyleItem: (String) -> Unit,
) {
    if (isVisible) {
        if (state.isLoading) {
            stylePlaceholder()
        } else if (state.items.isEmpty()) {
            return
        } else {
            item {
                SectionTitle(
                    title =stringResource(R.string.style),
                    modifier = Modifier
                        .padding(top = 24.dp, bottom = 12.dp),
                    showAllLabel = false
                )
            }
            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp),
                ) {
                    items(state.items) { item ->
                        StyleCard(
                            item = item,
                            onClick = { onClickStyleItem(item.id) }
                        )
                    }
                }
            }
        }
    }
}

// ==================== PREVIEW ====================

@ThemeAndLocalePreviews
@Composable
private fun StyleSectionPreview() {
    val dummyStyles = listOf(
        StyleItemUiState(id = "1", name = "Modern", imageUrl = "", imageRes = R.drawable.style_modern),
        StyleItemUiState(id = "2", name = "Classic", imageUrl = "", imageRes = R.drawable.style_classic),
        StyleItemUiState(id = "3", name = "Bohemian", imageUrl = "", imageRes = R.drawable.style_bohemian),
        StyleItemUiState(id = "4", name = "Rustic", imageUrl = "", imageRes = R.drawable.style_rustic),
        StyleItemUiState(id = "5", name = "Contemporary", imageUrl = "", imageRes = R.drawable.style_contemporary),
        StyleItemUiState(id = "6", name = "Minimalist", imageUrl = "", imageRes = R.drawable.style_minimalist)
    )

    DecoratoTheme {
        LazyColumn {
            styleSection(
                state = StyleSectionUiState(items = dummyStyles, isLoading = false),
                isVisible = true,
                onClickStyleItem = {}
            )
        }
    }
}

@ThemeAndLocalePreviews
@Composable
private fun StyleSectionLoadingPreview() {
    DecoratoTheme {
        LazyColumn {
            styleSection(
                state = StyleSectionUiState(items = emptyList(), isLoading = true),
                isVisible = true,
                onClickStyleItem = {}
            )
        }
    }
}