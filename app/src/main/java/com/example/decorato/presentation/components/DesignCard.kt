package com.example.decorato.presentation.components

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun DesignCard(
    designImage: @Composable () -> Unit,
    designTitle: String,
    designLocation: String,
    designCategory: String,
    modifier: Modifier = Modifier,
    topIcon: Painter? = null,
    onTopIconClick: () -> Unit = {},
    onClick: () -> Unit = {},
) {
    BaseCard(
        modifier = modifier.size(140.dp, 180.dp),
        designImage = designImage,
        designTitle = designTitle,
        designLocation = designLocation,
        designCategory = designCategory,
        onClick = onClick,
        topIcon = topIcon,
        onTopIconClick = onTopIconClick,
    )
}