package com.example.decorato.presentation.screens.community

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.decorato.presentation.theme.AppTheme
import com.example.decorato.presentation.theme.DecoratoTheme
import com.example.decorato.presentation.utils.ThemeAndLocalePreviews

@Composable
fun CommunityScreen() {
    CommunityScreenContent()
}

@Composable
private fun CommunityScreenContent(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(AppTheme.color.surface)
            .statusBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Community Screen",
                style = AppTheme.textStyle.title.large,
                color = AppTheme.color.primary
            )

            Text(
                text = "Share and Explore Designs 👥",
                style = AppTheme.textStyle.body.large,
                color = AppTheme.color.body,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}

@ThemeAndLocalePreviews
@Composable
private fun CommunityScreenPreview() {
    DecoratoTheme {
        CommunityScreenContent()
    }
}