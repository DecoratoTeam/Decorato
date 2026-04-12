package com.example.decorato.presentation.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.decorato.presentation.screens.profile.components.EditProfileFields
import com.example.decorato.presentation.screens.profile.components.ProfileHeader
import com.example.decorato.presentation.theme.AppTheme
import com.example.decorato.presentation.viewModel.profile.InteractionListener.EditProfileInteractionListener
import com.example.decorato.presentation.viewModel.profile.UiState.EditProfileUiState

@Composable
 fun EditProfileContent(
    state: EditProfileUiState,
    listener: EditProfileInteractionListener,
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.color.surface)
            .verticalScroll(rememberScrollState())
    ) {

        // 🔥 Header (Edit Mode)
        ProfileHeader(
            userName = null,
            userImage = state.userImage,
            isEdit = true,

            // 🔙 ده أهم سطر (السهم)
            onBackClick = onBackClick,

            onUpdateImageClick = {
                listener.onUpdateImageClick()
            },

            onClickEdit = {
                listener.onClickEditProfile()
            }
        )

        // 📝 Fields
        EditProfileFields(
            state = state,
            interactionListener = listener
        )
    }
}