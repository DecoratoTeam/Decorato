package com.example.decorato.presentation.screens.profile.components.my_rating

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.decorato.R

@Composable
fun EmptyRatingContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 40.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 1. الصورة الرمادية (الأيكون)
        Image(
            painter = painterResource(id = R.drawable.ic_no_ratings), // تأكدي إن الاسم ده عندك في الـ drawables
            contentDescription = null,
            modifier = Modifier.size(120.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // 2. العنوان الرئيسي (No Ratings Yet)
        Text(
            text = "No Ratings Yet",
            fontSize = 18.sp,
            fontFamily = FontFamily(Font(R.font.poppins_medium)),
            color = Color(0xFF1F1F1F),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        // 3. النص الفرعي (الوصف)
        Text(
            text = "You haven't rated any designs or rooms so far. Start exploring the designs you like",
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            color = Color(0xFF7C7C7C), // لون رمادي خفيف
            textAlign = TextAlign.Center,
            lineHeight = 20.sp
        )
    }
}