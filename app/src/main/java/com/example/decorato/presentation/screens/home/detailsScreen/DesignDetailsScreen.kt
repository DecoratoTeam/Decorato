package com.example.decorato.presentation.screens.home.detailsScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.example.decorato.presentation.components.DefaultAppBar
import com.example.decorato.presentation.theme.AppTheme
import com.example.decorato.presentation.viewModel.home.detailsScreen.DesignDetailsEffect
import com.example.decorato.presentation.viewModel.home.detailsScreen.DesignDetailsUiState
import com.example.decorato.presentation.viewModel.home.detailsScreen.DesignDetailsViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun DesignDetailsScreen(
    designId: String,
    modifier: Modifier = Modifier,
    viewModel: DesignDetailsViewModel = hiltViewModel()
) {
    val navigationManager = LocalNavManager.current
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(designId) {
        viewModel.loadDesignDetails(designId)
    }

    LaunchedEffect(Unit) {
        viewModel.effect.collectLatest { effect ->
            when (effect) {
                is DesignDetailsEffect.NavigateBack -> {
                    navigationManager.navigateBack()
                }
            }
        }
    }

    DesignDetailsScreenContent(
        state = state,
        onBackClick = { viewModel.onBackClick() },
        modifier = modifier
    )
}

@Composable
private fun DesignDetailsScreenContent(
    state: DesignDetailsUiState,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(AppTheme.color.surface)
    ) {
        DefaultAppBar(
            title = state.designTitle,
            showNavigateBackButton = true,
            containerColor = AppTheme.color.surface,
            onNavigateBackClicked = onBackClick,
            modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(AppTheme.color.disable)
            ) {
                if (state.isLoading) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "Loading...",
                            color = AppTheme.color.body,
                            style = AppTheme.textStyle.body.medium
                        )
                    }
                } else {
                    AsyncImage(
                        model = state.imageUrl,
                        contentDescription = state.designTitle,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            Text(
                text = state.designTitle,
                style = AppTheme.textStyle.title.large,
                color = AppTheme.color.titleL,
                modifier = Modifier.padding(top = 16.dp)
            )

            Text(
                text = state.category,
                style = AppTheme.textStyle.body.small,
                color = AppTheme.color.hint,
                modifier = Modifier.padding(top = 4.dp)
            )

            Text(
                text = state.description,
                style = AppTheme.textStyle.body.medium,
                color = AppTheme.color.body,
                modifier = Modifier.padding(top = 16.dp, bottom = 24.dp),
            )
        }
    }
}