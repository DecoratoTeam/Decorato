package com.example.decorato.presentation.screens.community

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.decorato.presentation.navigation.NavigationManager
import com.example.decorato.presentation.navigation.Route
import com.example.decorato.presentation.screens.community.sections.CreatePostScreen
import com.example.decorato.presentation.viewModel.community.create_post.CreatePostViewModel
import com.example.decorato.presentation.viewModel.community.create_post.CreatePostEffect
import com.example.decorato.presentation.viewModel.community.create_post.CreatePostUiState


fun NavGraphBuilder.createPostScreenRoute(navigationManager: NavigationManager) {
    composable<Route.CreatePost> {
        CreatePostScreenRoute(navigationManager = navigationManager)
    }
}

@Composable
fun CreatePostScreenRoute(
    navigationManager: NavigationManager,
    createPostViewModel: CreatePostViewModel = hiltViewModel()
) {
    val state: CreatePostUiState by createPostViewModel.state.collectAsState()

    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? -> uri?.let { createPostViewModel.onImagePicked(it.toString()) } }

    LaunchedEffect(Unit) {
        createPostViewModel.effect.collect { effect: CreatePostEffect ->
            when (effect) {
                is CreatePostEffect.PickImageFromGallery -> galleryLauncher.launch("image/*")
                is CreatePostEffect.NavigateBack -> navigationManager.navigateBack()
                is CreatePostEffect.NavigateToUserProfile -> {
                    navigationManager.toProfile()
                }
                else -> {}
            }
        }
    }

    // الزتونة: هنا بعتنا الـ state والـ listener زي ما الـ Section محتاج بالظبط
    CreatePostScreen(
        state = state,      // هيبعت الـ CreatePostUiState بالكامل
        listener = createPostViewModel // هيبعت الـ ViewModel كـ listener
    )
}