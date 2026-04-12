package com.example.decorato.presentation.screens.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
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
            .height(250.dp)
            .background(Color(0xFFF9F9F9))
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_header_placeholder),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(212.dp),
            contentScale = ContentScale.FillBounds
        )

        Row(
            modifier = Modifier
                .padding(top = 62.dp, start = 14.dp)
                .fillMaxWidth()
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
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp),
                    tint = Color.Black
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = stringResource(id = R.string.edit_profile),
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF003D33)
            )
        }

        Box(
            modifier = Modifier
                .padding(top = 142.dp)
                .fillMaxWidth()
                .height(96.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(userImage),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .size(96.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.White, CircleShape),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .offset(x = 32.dp, y = 63.dp)
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFF9F9F9))
                    .clickable { onUpdateImageClick() },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_camera),
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    }
}