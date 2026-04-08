package com.example.decorato.presentation.screens.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
// Import الصحيح لمشروعك
import com.example.decorato.R

@Composable
fun EditProfileHeader(
    userImage: String,
    onBackClick: () -> Unit,
    onUpdateImageClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(260.dp)
    ) {
        // 1. الخلفية المستقيمة (Height 212)
        Image(
            painter = painterResource(id = R.drawable.profile_header_placeholder),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(212.dp),
            contentScale = ContentScale.FillBounds
        )

        // 2. سهم الرجوع وكلمة Edit Profile (Top: 62px, Left: 14px)
        Row(
            modifier = Modifier
                .padding(top = 62.dp, start = 14.dp)
                .height(40.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.White, RoundedCornerShape(12.dp))
                    .clickable { onBackClick() },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            androidx.compose.material3.Text(
                text = "Edit Profile",
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF003D33)
                )
            )
        }

        // 3. صورة البروفايل مع الكاميرا
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 164.dp)
                .size(width = 114.dp, height = 96.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(userImage),
                contentDescription = null,
                modifier = Modifier
                    .size(96.dp)
                    .align(Alignment.TopCenter)
                    .clip(CircleShape)
                    .border(4.dp, Color.White, CircleShape),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .size(32.dp)
                    .align(Alignment.BottomEnd)
                    .offset(x = (-4).dp, y = (-4).dp)
                    .clip(CircleShape)
                    .background(Color(0xFF00A78E))
                    .border(2.dp, Color.White, CircleShape)
                    .clickable { onUpdateImageClick() }
                    .padding(6.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_camera),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}