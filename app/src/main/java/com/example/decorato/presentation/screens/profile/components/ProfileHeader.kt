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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import coil.compose.rememberAsyncImagePainter
import com.example.decorato.R
import com.example.decorato.presentation.theme.colors.LocalDecoratoAppColors

@Composable
fun ProfileHeader(
    userName: String?,
    userImage: String,
    isEdit: Boolean,
    onBackClick: () -> Unit = {},
    onUpdateImageClick: () -> Unit = {},
    onClickEdit: () -> Unit = {}
) {

    val colors = LocalDecoratoAppColors.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color(0xFFF9F9F9))
    ) {

        /* ---------------- BACKGROUND (الهيدر الأخضر) ---------------- */
        Image(
            painter = painterResource(id = R.drawable.profile_header_placeholder),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(212.dp),
            contentScale = ContentScale.FillBounds
        )

        /* ---------------- TOP BAR (العنوان) ---------------- */
        Row(
            modifier = Modifier
                .padding(top = 50.dp, start = 14.dp, end = 14.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            if (isEdit) {
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
            }

            Text(
                text = if (isEdit) "Edit Profile" else "My Profile",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = colors.secondary
            )
        }

        /* ---------------- PROFILE IMAGE & NAME ---------------- */
        // الزتونة: الـ 140dp دي هي اللي هتخلي الـ 3/4 فوق والربع تحت بالمللي
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 140.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Box(modifier = Modifier.size(96.dp)) {
                    // 👤 الصورة الشخصية
                    Image(
                        painter = rememberAsyncImagePainter(userImage),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(CircleShape)
                            .border(2.dp, Color.White, CircleShape)
                            .clickable { if (!isEdit) onClickEdit() },
                        contentScale = ContentScale.Crop
                    )

                    // 📷 أيقونة الكاميرا
                    if (isEdit) {
                        Box(
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
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

                // 👇 الاسم
                if (!isEdit && userName != null) {
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = userName,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                }
            }
        }
    }
}