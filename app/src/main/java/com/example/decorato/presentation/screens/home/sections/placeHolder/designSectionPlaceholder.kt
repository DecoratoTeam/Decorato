package com.example.decorato.presentation.screens.home.sections.placeHolder

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.decorato.presentation.components.RoundedShimmerPlaceholder

fun LazyListScope.designSectionPlaceholder(modifier: Modifier = Modifier) {
    item {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            RoundedShimmerPlaceholder(
                height = 24.dp,
                width = 180.dp,
                cornerRadius = 8.dp
            )

            RoundedShimmerPlaceholder(
                height = 20.dp,
                width = 70.dp,
                cornerRadius = 8.dp
            )
        }
    }

    item {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            userScrollEnabled = false,
        ) {
            items(10) {
                RoundedShimmerPlaceholder(
                    height = 180.dp,
                    width = 140.dp,
                    cornerRadius = 12.dp
                )
            }
        }
    }
}