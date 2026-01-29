package com.example.decorato.presentation.screens.home.sections.placeHolder

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import com.example.decorato.presentation.components.RoundedShimmerPlaceholder
import kotlin.math.absoluteValue

@SuppressLint("RestrictedApi", "UnusedBoxWithConstraintsScope")
fun LazyListScope.popularSectionPlaceholder() {
    item {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp, bottom = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RoundedShimmerPlaceholder(
                height = 24.dp,
                width = 100.dp,
                cornerRadius = 8.dp
            )
            RoundedShimmerPlaceholder(
                height = 24.dp,
                width = 24.dp,
                cornerRadius = 12.dp
            )
        }
    }

    item {
        BoxWithConstraints {
            val pagerState = rememberPagerState(
                initialPage = 1,
                pageCount = { 3 }
            )
            val screenWidth = maxWidth
            val itemWidth = 244.dp
            val horizontalPadding = (screenWidth - itemWidth) / 2

            HorizontalPager(
                state = pagerState,
                pageSpacing = 16.dp,
                contentPadding = PaddingValues(horizontal = horizontalPadding),
                userScrollEnabled = false,
                modifier = Modifier.align(Alignment.TopCenter)
            ) { page ->
                val currentPageOffset =
                    ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction).absoluteValue

                val width by animateDpAsState(
                    targetValue = lerp(220.dp, 244.dp, 1f - currentPageOffset.coerceIn(0f, 1f)),
                    label = "width"
                )

                val height by animateDpAsState(
                    targetValue = lerp(260.dp, 280.dp, 1f - currentPageOffset.coerceIn(0f, 1f)),
                    label = "height"
                )

                Column(
                    modifier = Modifier.width(width),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    RoundedShimmerPlaceholder(
                        height = height,
                        width = width,
                        cornerRadius = 16.dp
                    )
                }
            }
        }
    }
}