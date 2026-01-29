package com.example.decorato.presentation.screens.home.sections

import android.annotation.SuppressLint
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import com.example.decorato.R
import com.example.decorato.presentation.screens.home.component.PopularDesignCard
import com.example.decorato.presentation.screens.home.sections.placeHolder.popularSectionPlaceholder
import com.example.decorato.presentation.viewModel.home.section.PopularSectionUiState
import kotlinx.coroutines.delay
import kotlin.math.absoluteValue

@SuppressLint("RestrictedApi")
fun LazyListScope.popularSection(
    state: PopularSectionUiState,
    onClickDesignItem: (String) -> Unit,
    isVisible: Boolean
) {
    if (isVisible) {
        if (state.isLoading) {
            popularSectionPlaceholder()
        } else if (state.items.isEmpty()) {
            return
        } else {
            item {
                Box {
                    val pagerState = rememberPagerState(
                        initialPage = Int.MAX_VALUE / 2,
                        pageCount = { Int.MAX_VALUE }
                    )

                    Crossfade(
                        targetState = pagerState.currentPage,
                        animationSpec = tween(500, easing = FastOutSlowInEasing),
                        label = "background_crossfade"
                    ) { page ->
                        BlurredDesignBackground(
                            imageUrl = state.items[page % state.items.size].imageUrl,
                            modifier = Modifier
                        )
                    }

                    Column(
                        modifier = Modifier
                            .padding(top = 16.dp)
                    ) {
                        PopularSectionTitle()

                        AutoScrollingPager(pagerState)

                        BoxWithConstraints {
                            val screenWidth = maxWidth
                            PopularDesignPager(
                                pagerState = pagerState,
                                state = state,
                                screenWidth = screenWidth,
                                onClickDesignItem = onClickDesignItem
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun PopularSectionTitle(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(bottom = 12.dp)
    ) {
        Text(
            text = "Popular",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1A1A1A)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            painter = painterResource(id = R.drawable.ic_fire),
            contentDescription = "Popular",
            tint = Color(0xFF00CDB8),
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
private fun AutoScrollingPager(
    pagerState: PagerState,
    intervalMillis: Long = 4000L
) {
    val interactionSource = pagerState.interactionSource
    var isUserInteracting by remember { mutableStateOf(false) }

    LaunchedEffect(pagerState) {
        interactionSource.interactions.collect { interaction ->
            isUserInteracting = when (interaction) {
                is PressInteraction.Press,
                is DragInteraction.Start -> true
                else -> false
            }
        }
    }

    LaunchedEffect(isUserInteracting) {
        while (!isUserInteracting) {
            delay(intervalMillis)
            val nextPage = (pagerState.currentPage + 1) % Int.MAX_VALUE
            pagerState.animateScrollToPage(
                page = nextPage,
                animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing)
            )
        }
    }
}

@Composable
private fun PopularDesignPager(
    pagerState: PagerState,
    state: PopularSectionUiState,
    screenWidth: Dp,
    modifier: Modifier = Modifier,
    onClickDesignItem: (String) -> Unit
) {
    val itemWidth = 244.dp
    val horizontalPadding = (screenWidth - itemWidth) / 2

    HorizontalPager(
        state = pagerState,
        pageSpacing = 16.dp,
        contentPadding = PaddingValues(horizontal = horizontalPadding),
        modifier = modifier
    ) { page ->
        val currentPageOffset =
            ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction).absoluteValue

        val width by animateDpAsState(
            targetValue = lerp(
                220.dp,
                244.dp,
                1f - currentPageOffset.coerceIn(0f, 1f)
            ),
            label = "width"
        )

        val height by animateDpAsState(
            targetValue = lerp(
                260.dp,
                280.dp,
                1f - currentPageOffset.coerceIn(0f, 1f)
            ),
            label = "height"
        )

        val alpha by animateFloatAsState(
            targetValue = androidx.compose.ui.util.lerp(
                0.7f,
                1f,
                1f - currentPageOffset.coerceIn(0f, 1f)
            ),
            label = "alpha"
        )

        PopularDesignCard(
            item = state.items[page % state.items.size],
            imageWidth = width,
            imageHeight = height,
            alpha = alpha,
            onClick = { onClickDesignItem(state.items[page % state.items.size].id) }
        )
    }
}

@Composable
private fun BlurredDesignBackground(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .size(300.dp)
    ) {
        // TODO: Add blurred background image
    }
}