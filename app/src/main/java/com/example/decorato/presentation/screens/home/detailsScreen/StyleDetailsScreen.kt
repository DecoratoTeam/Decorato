package com.example.decorato.presentation.screens.home.detailsScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.decorato.presentation.application.LocalNavManager
import com.example.decorato.presentation.components.BaseCard
import com.example.decorato.presentation.components.DefaultAppBar
import com.example.decorato.presentation.theme.AppTheme
import com.example.decorato.presentation.viewModel.home.detailsScreen.StyleDetailsEffect
import com.example.decorato.presentation.viewModel.home.detailsScreen.StyleDetailsUiState
import com.example.decorato.presentation.viewModel.home.detailsScreen.StyleDetailsViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun StyleDetailsScreen(
    styleId: String,
    modifier: Modifier = Modifier,
    viewModel: StyleDetailsViewModel = hiltViewModel()
) {
    val navigationManager = LocalNavManager.current
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(styleId) {
        viewModel.loadStyleDesigns(styleId)
    }

    LaunchedEffect(Unit) {
        viewModel.effect.collectLatest { effect ->
            when (effect) {
                is StyleDetailsEffect.NavigateToDesignDetails -> {
                    navigationManager.toDesignDetails(effect.designId)
                }
                is StyleDetailsEffect.NavigateBack -> {
                    navigationManager.navigateBack()
                }
            }
        }
    }

    StyleDetailsScreenContent(
        state = state,
        onBackClick = { viewModel.onBackClick() },
        onDesignClick = { designId -> viewModel.onDesignClick(designId) },
        modifier = modifier
    )
}

@Composable
private fun StyleDetailsScreenContent(
    state: StyleDetailsUiState,
    onBackClick: () -> Unit,
    onDesignClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(AppTheme.color.surface)
    ) {
        DefaultAppBar(
            title = state.styleName,
            showNavigateBackButton = true,
            containerColor = AppTheme.color.surface,
            onNavigateBackClicked = onBackClick,
            modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
        )

        if (state.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Loading...",
                    color = AppTheme.color.surfaceHigh,
                    style = AppTheme.textStyle.body.medium
                )
            }
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxSize()
                    .background(AppTheme.color.surface),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(state.designs) { design ->
                    BaseCard(
                        designImage = {
                            AsyncImage(
                                model = design.imageUrl,
                                contentDescription = design.title,
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                        },
                        designTitle = design.title,
                        designLocation = design.category,
                        designCategory = design.category,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(AppTheme.color.surface),
                        onClick = { onDesignClick(design.id) }
                    )
                }
            }
        }
    }
}