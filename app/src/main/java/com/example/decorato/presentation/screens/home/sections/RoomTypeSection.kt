package com.example.decorato.presentation.screens.home.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.decorato.R
import com.example.decorato.presentation.screens.home.component.RoomTypeButton
import com.example.decorato.presentation.screens.home.sections.placeHolder.stylePlaceholder
import com.example.decorato.presentation.theme.AppTheme
import com.example.decorato.presentation.viewModel.home.section.RoomTypeSectionUiState

fun LazyListScope.roomTypeSection(
    state: RoomTypeSectionUiState,
    onClickRoomType: (String) -> Unit,
    isVisible: Boolean
) {
    if (isVisible) {
        if (state.isLoading) {
            stylePlaceholder()
        } else if (state.items.isEmpty()) {
            return
        } else {
            item {
                Text(
                    text = stringResource(R.string.roomType),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = AppTheme.color.titleL,
                    modifier = Modifier.padding(start = 16.dp, top = 24.dp, bottom = 12.dp)
                )
            }
            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp),
                ) {
                    items(state.items) { item ->
                        RoomTypeButton(
                            item = item,
                            onClick = { onClickRoomType(item.id) }
                        )
                    }
                }
            }
        }
    }
}