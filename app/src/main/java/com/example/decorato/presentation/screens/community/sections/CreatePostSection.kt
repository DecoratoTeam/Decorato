package com.example.decorato.presentation.screens.community.sections

import PostInputField
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.decorato.presentation.screens.community.components.CreatePostTopBar
import com.example.decorato.presentation.screens.community.components.ImageAttachment
import com.example.decorato.presentation.screens.community.components.UserInfoHeader
import com.example.decorato.presentation.theme.colors.LocalDecoratoAppColors
import com.example.decorato.presentation.viewmodel.community.community_screen.CommunityInteractionListener
import com.example.decorato.presentation.viewmodel.community.community_screen.CommunityUiState
import com.example.decorato.presentation.viewmodel.community.create_post.CreatePostInteractionListener
import com.example.decorato.presentation.viewmodel.community.create_post.CreatePostUiState

@Composable
fun CreatePostScreen(
    state: CreatePostUiState, // بنبعت الـ State كامل أسهل
    listener: CreatePostInteractionListener, // الـ listener بيشيل كل الـ actions
) {
    val colors = LocalDecoratoAppColors.current
    val scrollState = rememberScrollState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colors.surface
    ) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding(),
            containerColor = Color.Transparent,
            topBar = {
                CreatePostTopBar(
                    onBackClick = listener::onClickBack, // بننادي من الـ listener
                    onPublishClick = listener::onClickPublish,
                    canPublish = state.postText.isNotBlank() || state.selectedImageUris.isNotEmpty(),
                    isPublishing = state.isPublishing
                )
            },
            bottomBar = {
                ImageAttachment(
                    hasSelectedImage = state.selectedImageUris.isNotEmpty(),
                    onAddImageClick = listener::onClickAddImage,
                    modifier = Modifier.padding(16.dp)
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp)
                    .verticalScroll(scrollState)
            ) {
                // مسافة مريحة بعد الـ Top Bar زي الفيجما
                Spacer(modifier = Modifier.height(24.dp))

                UserInfoHeader(
                    userName = state.userName,
                    profileImageUrl = state.profileImageUrl,
                    onProfileClick = { listener.onClickUserAvatar("my_id") }
                )

                // المسافة الرأسية اللي رجعناها عشان متبقاش لزقة في اليوزر
                Spacer(modifier = Modifier.height(24.dp))

                PostInputField(
                    text = state.postText,
                    onValueChange = listener::onTextChange
                )

                // عرض الصور المتعددة
                state.selectedImageUris.forEach { imageUri ->
                    Spacer(modifier = Modifier.height(16.dp))
                    AsyncImage(
                        model = imageUri,
                        contentDescription = "Selected Post Image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                            .clip(RoundedCornerShape(16.dp)),
                        contentScale = ContentScale.Crop
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}