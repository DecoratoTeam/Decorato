package com.example.decorato.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.decorato.presentation.application.LocalNavManager
import com.example.decorato.presentation.application.LocalScaffoldBottomPadding
import com.example.decorato.presentation.components.NoNetworkContainer
import com.example.decorato.presentation.screens.home.component.HomeAppBar
import com.example.decorato.presentation.screens.home.sections.popularSection
import com.example.decorato.presentation.screens.home.sections.recentlyWatchedSection
import com.example.decorato.presentation.screens.home.sections.roomDesignsSection
import com.example.decorato.presentation.screens.home.sections.roomTypeSection
import com.example.decorato.presentation.screens.home.sections.styleSection
import com.example.decorato.presentation.theme.AppTheme
import com.example.decorato.presentation.theme.DecoratoTheme
import com.example.decorato.presentation.utils.ThemeAndLocalePreviews
import com.example.decorato.presentation.viewModel.home.HomeEffect
import com.example.decorato.presentation.viewModel.home.HomeInteractionListener
import com.example.decorato.presentation.viewModel.home.HomeUiState
import com.example.decorato.presentation.viewModel.home.HomeViewModel
import com.example.decorato.presentation.viewModel.shared.errorUiState.ErrorUiState
import com.example.decorato.presentation.viewModel.shared.errorUiState.isNull
import kotlinx.coroutines.flow.collectLatest

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val navigationManager = LocalNavManager.current
    val state by homeViewModel.state.collectAsStateWithLifecycle()
    val errorState by homeViewModel.errorState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        homeViewModel.effect.collectLatest { effect ->
            when (effect) {
                is HomeEffect.NavigateToDesignDetails -> {
                    navigationManager.toDesignDetails(effect.designId)
                }
                is HomeEffect.NavigateToAllRecentlyWatched -> {
                    navigationManager.toAllRecentlyWatched()
                }
                is HomeEffect.NavigateToStyleDetails -> {
                    navigationManager.toStyleDetails(effect.styleId)
                }
                is HomeEffect.NavigateToTab -> {
                    // Handle tab navigation
                }
                is HomeEffect.ShowErrorMessage -> {
                    // Handle error
                }
                is HomeEffect.ShowErrorSnackBar -> {
                    // Show snackbar using SnackBarManager
                }
            }
        }
    }

    HomeScreenContent(
        modifier = modifier,
        state = state,
        errorState = errorState,
        interactionListener = homeViewModel
    )
}

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
private fun HomeScreenContent(
    state: HomeUiState,
    errorState: ErrorUiState?,
    interactionListener: HomeInteractionListener,
    modifier: Modifier = Modifier
) {
    val density = LocalDensity.current
    val lazyListState = rememberLazyListState()
    var appBarHeight by remember { mutableStateOf(0.dp) }

    val scrollOffset by remember {
        derivedStateOf { lazyListState.firstVisibleItemScrollOffset }
    }

    val appBarColor by animateColorAsState(
        targetValue = if (scrollOffset > 8) AppTheme.color.surface else Color.Transparent,
        animationSpec = tween(800),
        label = "AppBarScrollColor"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.color.surface)
            .navigationBarsPadding()
            .windowInsetsPadding(WindowInsets(bottom = LocalScaffoldBottomPadding.current))
    ) {
        if (errorState is ErrorUiState.NoInternetError) {
            Column(Modifier.fillMaxSize()) {
                HomeAppBar(
                    modifier = Modifier
                        .background(appBarColor)
                        .statusBarsPadding()
                        .padding(horizontal = 16.dp),
                )
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                ) {
                    NoNetworkContainer(
                        onClickRetry = interactionListener::onClickRetryLoading,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(vertical = 8.dp)
                    )
                }
            }
        } else {
            LazyColumn(
                modifier = modifier.fillMaxSize(),
                state = lazyListState,
            ) {
                item {
                    androidx.compose.foundation.layout.Spacer(
                        modifier = Modifier.height(appBarHeight - 16.dp)
                    )
                }

                popularSection(
                    state = state.popularSectionUiState,
                    onClickDesignItem = interactionListener::onClickPopularItem,
                    isVisible = state.popularSectionUiState.items.isNotEmpty() && errorState.isNull()
                )

                recentlyWatchedSection(
                    state = state.recentlyWatchedSectionUiState,
                    isVisible = state.recentlyWatchedSectionUiState.items.isNotEmpty(),
                    onClickDesignItem = interactionListener::onClickRecentlyWatchedItem,
                    onClickShowAll = interactionListener::onClickShowAllRecentlyWatched
                )

                styleSection(
                    state = state.styleSectionUiState,
                    isVisible = state.styleSectionUiState.items.isNotEmpty() && errorState.isNull(),
                    onClickStyleItem = interactionListener::onClickStyleItem
                )

                roomTypeSection(
                    state = state.roomTypeSectionUiState,
                    onClickRoomType = { roomTypeId ->
                        interactionListener.onRoomTypeSelected(roomTypeId)
                    },
                    isVisible = state.roomTypeSectionUiState.items.isNotEmpty() && errorState.isNull()
                )

                roomDesignsSection(
                    state = state.roomDesignsSectionUiState,
                    onClickRoomDesign = { designId ->
                        interactionListener.onClickRoomDesign(designId)
                    },
                    isVisible = state.roomDesignsSectionUiState.items.isNotEmpty() && errorState.isNull()
                )
            }

            HomeAppBar(
                modifier = Modifier
                    .onSizeChanged {
                        appBarHeight = with(density) { it.height.toDp() }
                    }
                    .background(appBarColor)
                    .statusBarsPadding()
                    .padding(horizontal = 16.dp, vertical = 16.dp)
            )
        }
    }
}

@ThemeAndLocalePreviews
@Composable
private fun HomeScreenPreview() {
    DecoratoTheme {
        HomeScreenContent(
            state = HomeUiState(),
            errorState = ErrorUiState.UnknownError,
            interactionListener = object : HomeInteractionListener {
                override fun onClickRetryLoading() {}
                override fun onClickPopularItem(designId: String) {}
                override fun onClickRecentlyWatchedItem(designId: String) {}
                override fun onClickStyleItem(styleId: String) {}
                override fun onClickShowAllRecentlyWatched() {}
                override fun onTabSelected(tabIndex: Int) {}
                override fun onRoomTypeSelected(roomTypeId: String) {}
                override fun onClickRoomDesign(designId: String) {}
            }
        )
    }
}