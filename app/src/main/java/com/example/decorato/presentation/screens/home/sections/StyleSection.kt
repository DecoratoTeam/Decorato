package com.example.decorato.presentation.screens.home.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.decorato.presentation.components.SectionTitle
import com.example.decorato.presentation.screens.home.sections.placeHolder.stylePlaceholder
import com.example.decorato.presentation.theme.AppTheme
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
                    title = "Style",
                    modifier = Modifier
                        .padding(top = 24.dp, bottom = 12.dp),
                    showAllLabel = false
                )
            }
            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
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

@Composable
private fun StyleCard(
    item: StyleItemUiState,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .width(120.dp)
            .height(48.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(AppTheme.color.surface)
            .border(
                width = 1.dp,
                color = AppTheme.color.stroke,
                shape = RoundedCornerShape(24.dp)
            )
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = item.name,
            color = AppTheme.color.titleL,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}

// ==================== PREVIEW ====================

@ThemeAndLocalePreviews
@Composable
private fun StyleSectionPreview() {
    val dummyStyles = listOf(
        StyleItemUiState(id = "1", name = "Modern", imageUrl = ""),
        StyleItemUiState(id = "2", name = "Classic", imageUrl = ""),
        StyleItemUiState(id = "3", name = "Bohemian", imageUrl = ""),
        StyleItemUiState(id = "4", name = "Rustic", imageUrl = ""),
        StyleItemUiState(id = "5", name = "Contemporary", imageUrl = ""),
        StyleItemUiState(id = "6", name = "Minimalist", imageUrl = "")
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

@ThemeAndLocalePreviews
@Composable
private fun StyleCardPreview() {
    DecoratoTheme {
        StyleCard(
            item = StyleItemUiState(
                id = "1",
                name = "Modern",
                imageUrl = ""
            ),
            onClick = {}
        )
    }
}