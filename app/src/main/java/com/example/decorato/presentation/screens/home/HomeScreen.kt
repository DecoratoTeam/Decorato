package com.example.decorato.presentation.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.decorato.presentation.application.LocalNavManager
import com.example.decorato.presentation.components.NoNetworkContainer
import com.example.decorato.presentation.screens.home.component.HomeAppBar
import com.example.decorato.presentation.screens.home.sections.popularSection
import com.example.decorato.presentation.screens.home.sections.recentlyWatchedSection
import com.example.decorato.presentation.viewModel.home.HomeEffect
import com.example.decorato.presentation.viewModel.home.HomeInteractionListener
import com.example.decorato.presentation.viewModel.home.HomeUiState
import com.example.decorato.presentation.viewModel.home.HomeViewModel
import com.example.decorato.presentation.viewModel.shared.errorUiState.ErrorUiState
import kotlinx.coroutines.flow.collectLatest

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val navigationManager = LocalNavManager.current
    val state by homeViewModel.state.collectAsStateWithLifecycle()
    val errorState by homeViewModel.errorState.collectAsStateWithLifecycle()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        homeViewModel.effect.collectLatest { effect ->
            when (effect) {
                is HomeEffect.NavigateToDesignDetails -> {
                    navigationManager.toDesignDetails(effect.designId)
                }
                is HomeEffect.NavigateToAllRecentlyWatched -> {
                    navigationManager.toAllRecentlyWatched()
                }
                is HomeEffect.NavigateToTab -> {
                    // Handle tab navigation if needed
                }
                is HomeEffect.ShowErrorMessage -> {
                    // Handle error
                }
                is HomeEffect.ShowErrorSnackBar -> {
                    snackbarHostState.showSnackbar(effect.message)
                }
            }
        }
    }

    HomeScreenContent(
        modifier = modifier,
        state = state,
        errorState = errorState,
        interactionListener = homeViewModel,
        snackbarHostState = snackbarHostState
    )
}

@Composable
private fun HomeScreenContent(
    state: HomeUiState,
    errorState: ErrorUiState?,
    interactionListener: HomeInteractionListener,
    snackbarHostState: SnackbarHostState,
    modifier: Modifier = Modifier
) {
    val lazyListState = rememberLazyListState()

    Scaffold(
        topBar = {
            HomeAppBar()
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        containerColor = Color(0xFFF5F5F5)
    ) { paddingValues ->
        when (errorState) {
            is ErrorUiState.NoInternetError -> {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .verticalScroll(rememberScrollState())
                ) {
                    NoNetworkContainer(
                        onClickRetry = interactionListener::onClickRetryLoading,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(vertical = 8.dp)
                    )
                }
            }
            else -> {
                LazyColumn(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    state = lazyListState,
                    contentPadding = PaddingValues(bottom = 16.dp)
                ) {
                    popularSection(
                        state = state.popularSectionUiState,
                        onClickDesignItem = interactionListener::onClickPopularItem,
                        isVisible = true
                    )

                    recentlyWatchedSection(
                        state = state.recentlyWatchedSectionUiState,
                        isVisible = state.recentlyWatchedSectionUiState.items.isNotEmpty(),
                        onClickDesignItem = interactionListener::onClickRecentlyWatchedItem,
                        onClickShowAll = interactionListener::onClickShowAllRecentlyWatched
                    )
                }
            }
        }
    }
}