package com.example.decorato.presentation.screens.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.decorato.presentation.theme.AppTheme
import com.example.decorato.presentation.theme.DecoratoTheme
import com.example.decorato.presentation.utils.ThemeAndLocalePreviews
import com.example.decorato.presentation.viewModel.home.section.RoomTypeItemUiState

@Composable
fun RoomTypeButton(
    item: RoomTypeItemUiState,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .border(
                width = 1.dp,
                color = if (item.isSelected) AppTheme.color.primary else AppTheme.color.stroke,
                shape = RoundedCornerShape(12.dp)
            )
            .background(
                color = if (item.isSelected) AppTheme.color.primary else Color.White,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 10.dp)
    ) {
        Text(
            text = item.name,
            fontSize = 14.sp,
            color = if (item.isSelected) Color.White else AppTheme.color.primary
        )
    }
}

@ThemeAndLocalePreviews
@Composable
private fun RoomTypeButtonPreview() {
    DecoratoTheme {
        Box(modifier = Modifier.padding(16.dp)) {
            RoomTypeButton(
                item = RoomTypeItemUiState(
                    id = "1",
                    name = "All",
                    isSelected = true
                ),
                onClick = {}
            )
        }
    }
}

@ThemeAndLocalePreviews
@Composable
private fun RoomTypeButtonUnselectedPreview() {
    DecoratoTheme {
        Box(modifier = Modifier.padding(16.dp)) {
            RoomTypeButton(
                item = RoomTypeItemUiState(
                    id = "2",
                    name = "Living Room",
                    isSelected = false
                ),
                onClick = {}
            )
        }
    }
}