package com.example.decorato.presentation.screens.community.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.decorato.R
import com.example.decorato.presentation.theme.colors.LocalDecoratoAppColors

@Composable
fun UserInfoHeader(
    userName: String,
    profileImageUrl: String, // التأكد من الاسم ده
    onProfileClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = LocalDecoratoAppColors.current

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp) ,// Height Hug (48px) من الفيجما
        verticalAlignment = Alignment.CenterVertically
    ) {
        // --- صورة المستخدم ---
        AsyncImage(
            model = profileImageUrl,
            contentDescription = "My Profile",
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .clickable { onProfileClick() },
            contentScale = ContentScale.Crop
        )

        // Gap = 8px
        Spacer(modifier = Modifier.width(8.dp))

        // --- اسم المستخدم ---
        Text(
            text = userName,
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.poppins_medium)), // Medium 500
                fontWeight = FontWeight.W500,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                color = colors.titleL
            )
        )
    }
}