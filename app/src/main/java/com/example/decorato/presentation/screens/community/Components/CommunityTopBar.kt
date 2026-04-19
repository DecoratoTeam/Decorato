package com.example.decorato.presentation.screens.community.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.decorato.R
import com.example.decorato.presentation.theme.colors.LocalDecoratoAppColors
import com.example.decorato.presentation.viewmodel.community.community_screen.CommunityUiState

@Composable
fun CommunityTopBar(
    state: CommunityUiState,
    onShareClick: () -> Unit,
    modifier: Modifier = Modifier,
    onProfileClick: () -> Unit
) {
    val colors = LocalDecoratoAppColors.current
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 24.dp)
            .height(56.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // صورة البروفايل (56x56)
        AsyncImage(
            model = state.userProfileImageUrl,
            contentDescription = "My Profile",
            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape)
                .clickable { onProfileClick() },
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .width(240.dp)
                .height(48.dp)
                .background(
                    color = colors.blurOverly,
                    shape = RoundedCornerShape(16.dp)
                )
                .clickable { onShareClick() },
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = stringResource(id = R.string.share_your_design),
                modifier = Modifier.padding(start = 16.dp),
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    fontSize = 14.sp, //
                    fontWeight = FontWeight.Normal,
                    lineHeight = 22.sp, //
                ),
                color = colors.body.copy(alpha = 0.6f) // سحبنا لون الـ body
            )
        }
    }
}