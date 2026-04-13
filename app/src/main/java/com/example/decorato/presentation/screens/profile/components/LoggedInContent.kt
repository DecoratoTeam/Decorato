package com.example.decorato.presentation.screens.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.decorato.presentation.theme.AppTheme
import com.example.decorato.presentation.theme.colors.LocalDecoratoAppColors

@Composable
fun LoggedInContent(
    userName: String,
    userImage: String,
    postCount: Int,
    rating: Double,
    isDarkMode: Boolean,
    currentLanguage: String,
    onEditClick: () -> Unit,
    onPostsClick: () -> Unit,
    onRatingClick: () -> Unit,
    onDarkModeChange: (Boolean) -> Unit,
    onLanguageClick: () -> Unit,
    onLogoutClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    val colors = LocalDecoratoAppColors.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colors.surface)
            .verticalScroll(scrollState)
    ) {

        ProfileHeader(
            userName = userName,
            userImage = userImage,
            isEdit = false,
            onClickEdit = onEditClick
        )

        Spacer(modifier = Modifier.height(8.dp))

        HistoryAndRatingSection(
            postCount = postCount,
            rating = rating,
            onClickPosts = onPostsClick,
            onClickRating = onRatingClick
        )

        Spacer(modifier = Modifier.height(16.dp))

        SettingsSection(
            isDarkMode = isDarkMode,
            onDarkModeChange = onDarkModeChange,
            currentLanguage = currentLanguage,
            onLanguageClick = onLanguageClick,
            onLogoutClick = onLogoutClick
        )

        Spacer(modifier = Modifier.height(24.dp))
    }
}