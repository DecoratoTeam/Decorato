package com.example.decorato.presentation.screens.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.decorato.R
import com.example.decorato.presentation.theme.AppTheme
import com.example.decorato.presentation.theme.DecoratoTheme
import com.example.decorato.presentation.utils.ThemeAndLocalePreviews
import com.example.decorato.presentation.viewModel.home.section.StyleItemUiState

@Composable
fun StyleCard(
    item: StyleItemUiState,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Image Box
        Box(
            modifier = Modifier
                .width(160.dp)
                .height(100.dp)
                .clip(RoundedCornerShape(12.dp))
                .clickable(onClick = onClick)
        ) {
            // Background Image
            if (item.imageRes != 0) {
                Image(
                    painter = painterResource(id = item.imageRes),
                    contentDescription = item.name,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                // Dark Gradient Overlay (from bottom)
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Black.copy(alpha = 0.3f)
                                ),
                                startY = 0f,
                                endY = Float.POSITIVE_INFINITY
                            )
                        )
                )
            } else {
                // Fallback color if no image
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(AppTheme.color.surface)
                )
            }
        }

        // Style Name
        Spacer(modifier = Modifier.height(8.dp))
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
private fun StyleCardPreview() {
    DecoratoTheme {
        StyleCard(
            item = StyleItemUiState(
                id = "1",
                name = "Modern",
                imageUrl = "",
                imageRes = R.drawable.style_modern
            ),
            onClick = {}
        )
    }
}

@ThemeAndLocalePreviews
@Composable
private fun StyleCardWithoutImagePreview() {
    DecoratoTheme {
        StyleCard(
            item = StyleItemUiState(
                id = "1",
                name = "Modern",
                imageUrl = "",
                imageRes = 0
            ),
            onClick = {}
        )
    }
}