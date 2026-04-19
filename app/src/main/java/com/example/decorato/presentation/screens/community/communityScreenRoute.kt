package com.example.decorato.presentation.screens.community

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.decorato.presentation.navigation.NavigationManager
import com.example.decorato.presentation.navigation.Route
import com.example.decorato.presentation.screens.community.sections.CommunitySection
import com.example.decorato.presentation.viewmodel.community.community_screen.CommunityEffect
import com.example.decorato.presentation.viewmodel.community.community_screen.CommunityInteractionListener
import com.example.decorato.presentation.viewmodel.community.community_screen.CommunityUiState
import com.example.decorato.presentation.viewmodel.community.community_screen.CommunityViewModel


// 1. الـ Extension اللي بيتحط في الـ NavGraph
fun NavGraphBuilder.communityScreenRoute(navigationManager: NavigationManager) {
    composable<Route.Tab.Community> {
        CommunityScreenRoute(navigationManager = navigationManager)
    }
}

// 2. الـ Wrapper اللي بيربط الـ Logic بالـ UI
@Composable
fun CommunityScreenRoute(
    navigationManager: NavigationManager,
    viewModel: CommunityViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is CommunityEffect.NavigateToPostDetails -> {
                    navigationManager.toDesignDetails(effect.postId)
                }
                is CommunityEffect.NavigateToUserProfile -> {
                    navigationManager.toProfile()
                }

                is CommunityEffect.NavigateToCreatePost -> {
                     navigationManager.toCreatePost()
                }
                is CommunityEffect.DownloadImage -> {
                    downloadImageToGallery(context, effect.url)
                }
                else -> {}
            }
        }
    }

    CommunityScreen(
        state = state,
        listener = viewModel
    )
}

// 3. الشاشة الفعلية (Stateless) - حل مشكلة No parameter with name 'state'
@Composable
fun CommunityScreen(
    state: CommunityUiState,
    listener: CommunityInteractionListener
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        CommunitySection(
            state = state,
            listener = listener,
            modifier = Modifier.padding(paddingValues)
        )
    }
}










private fun downloadImageToGallery(context: Context, url: String) {
    val request = DownloadManager.Request(Uri.parse(url))
        .setTitle("Decorato Design")
        .setDescription("Downloading image...")
        .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        .setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, "Decorato/${System.currentTimeMillis()}.jpg")
        .setAllowedOverMetered(true)
        .setAllowedOverRoaming(true)

    val manager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
    manager.enqueue(request)
}