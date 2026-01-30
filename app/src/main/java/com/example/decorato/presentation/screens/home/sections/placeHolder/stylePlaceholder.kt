package com.example.decorato.presentation.screens.home.sections.placeHolder

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.decorato.presentation.components.RoundedShimmerPlaceholder

fun LazyListScope.stylePlaceholder(modifier: Modifier = Modifier) {
    item {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 24.dp, bottom = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            RoundedShimmerPlaceholder(
                height = 24.dp,
                width = 80.dp,
                cornerRadius = 8.dp
            )
        }
    }

    item {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            userScrollEnabled = false
        ) {
            items(6) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    RoundedShimmerPlaceholder(
                        height = 100.dp,
                        width = 160.dp,
                        cornerRadius = 12.dp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    RoundedShimmerPlaceholder(
                        height = 16.dp,
                        width = 80.dp,
                        cornerRadius = 4.dp
                    )
                }
            }
        }
    }
}