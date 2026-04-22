package com.example.decorato.presentation.screens.community.sections

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.decorato.presentation.screens.community.components.CommunityTopBar
import com.example.decorato.presentation.screens.community.components.PostCard
import com.example.decorato.presentation.theme.colors.LocalDecoratoAppColors
import com.example.decorato.presentation.viewModel.community.community_screen.CommunityInteractionListener
import com.example.decorato.presentation.viewModel.community.community_screen.CommunityUiState


@Composable
fun CommunitySection(
    state: CommunityUiState,
    listener: CommunityInteractionListener,
    modifier: Modifier = Modifier,
) {
    val colors = LocalDecoratoAppColors.current

    Surface(
        modifier = modifier.fillMaxSize(),
        color = colors.surface
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            item {
                CommunityTopBar(
                    state = state,
                    onShareClick = { listener.onClickSharePostSection() },
                    onProfileClick = { listener.onClickUserAvatar("my_id") }
                )
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }

            items(
                items = state.posts,
                key = { it.id }
            ) { post ->
                PostCard(
                    post = post,
                    listener = listener
                )
            }
        }
    }
}