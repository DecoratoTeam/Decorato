package com.example.decorato.presentation.screens.profile.components.my_posts

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.decorato.R
import com.example.decorato.presentation.theme.colors.LocalDecoratoAppColors
import com.example.decorato.presentation.viewModel.profile.InteractionListener.MyPostsInteractionListener
import com.example.decorato.presentation.viewModel.profile.UiState.PostItemUiState

@Composable
fun PostItem(
    state: PostItemUiState,
    listener: MyPostsInteractionListener
) {
    val colors = LocalDecoratoAppColors.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            // المسافة الخارجية بين الكروت (Horizontal 20dp زي الفيجما)
            .padding(horizontal = 20.dp, vertical = 10.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = colors.surfaceHigh),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Header (Profile + Name)
            Row(verticalAlignment = Alignment.CenterVertically) {
                AsyncImage(
                    model = state.userImage,
                    contentDescription = null,
                    modifier = Modifier.size(48.dp).clip(CircleShape),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(R.drawable.ic_profile_placeholder)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = state.userName,
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        color = colors.titleL
                    )
                    // مسافة صغيرة جداً بين الاسم والوقت
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_clock),
                            contentDescription = null,
                            modifier = Modifier.size(12.dp),
                            tint = colors.hint
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = state.timeAgo,
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            color = colors.hint
                        )
                    }
                }
            }

            // مسافة 16dp قبل النص الوصفي
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = state.description,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                lineHeight = 22.sp, // ضبط ارتفاع السطر لراحة العين
                color = colors.body
            )

            // مسافة 12dp قبل الصورة
            Spacer(modifier = Modifier.height(12.dp))

            AsyncImage(
                model = state.postImage,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(R.drawable.ic_launcher_background)
            )

            // مسافة 12dp قبل قسم اللايك
            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = state.likesCount,
                    fontSize = 11.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    color = colors.hint
                )
                Spacer(modifier = Modifier.width(6.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_like_status),
                    contentDescription = null,
                    modifier = Modifier.size(22.dp),
                    tint = Color.Unspecified
                )
            }
        }
    }
}