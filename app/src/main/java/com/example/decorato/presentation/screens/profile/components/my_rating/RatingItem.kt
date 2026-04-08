package com.example.decorato.presentation.screens.profile.components.my_rating

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.decorato.R
import com.example.decorato.presentation.viewModel.profile.InteractionListener.MyRatingInteractionListener
import com.example.decorato.presentation.viewModel.profile.UiState.RatingItemUiState

@Composable
fun RatingItem(
    state: RatingItemUiState, // تأكدي إن ده الـ Item الصغير مش الـ MyRatingUiState الكبير
    listener: MyRatingInteractionListener
) {
    Card(
        modifier = Modifier
            .width(167.dp)
            .height(222.dp)
            .clickable { listener.onRatingItemClick(state.id) },
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, Color(0x141F1F1F))
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            // 1. الصورة الأساسية (الخلفية)
            AsyncImage(
                model = state.imageUrl,
                contentDescription = state.title,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            // 2. حاوية النجمة والتقييم (الـ Badge)
            Surface(
                modifier = Modifier
                    .padding(top = 8.dp, end = 8.dp)
                    .align(Alignment.TopEnd)
                    .width(41.dp)
                    .height(28.dp),
                color = Color.White.copy(alpha = 0.9f),
                shape = RoundedCornerShape(
                    topStart = 4.dp,
                    topEnd = 12.dp,
                    bottomEnd = 4.dp,
                    bottomStart = 12.dp
                ),
                border = BorderStroke(1.dp, Color(0x141F1F1F))
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_star),
                        contentDescription = null,
                        modifier = Modifier.size(13.dp),
                        tint = Color(0xFFFFD700)
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(
                        text = state.rating.toString(),
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        lineHeight = 16.sp,
                        color = Color(0xFF1F1F1F)
                    )
                }
            }

            // 3. منطقة الكلام مع الـ Gradient الأسود عشان الكلام يظهر
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .height(88.dp)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.8f))
                        )
                    )
                    .padding(8.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Column {
                    Text(
                        text = state.title,
                        color = Color.White,
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_medium))
                    )
                    Text(
                        text = state.location,
                        color = Color.White.copy(alpha = 0.8f),
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_regular))
                    )
                }
            }
        }
    }
}