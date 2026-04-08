package com.example.decorato.presentation.screens.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.remote.core.operations.layout.managers.TextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.decorato.R
import com.example.decorato.presentation.theme.textStyle.LocalDecoratoTextStyle

@Composable
fun HistoryAndRatingSection(
    postCount: Int,
    rating: Double,
    onClickPosts: () -> Unit,
    onClickRating: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        StatCard(
            title = stringResource(id = R.string.myPosts),
            value = postCount.toString(),
            painter = painterResource(id = R.drawable.history),
            onClick = onClickPosts,
            modifier = Modifier.weight(1f)
        )

        StatCard(
            title = stringResource(id = R.string.myRating),
            value = rating.toString(),
            painter = painterResource(id = R.drawable.rating),
            onClick = onClickRating,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun StatCard(
    title: String,
    value: String,
    painter: Painter,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val typography = LocalDecoratoTextStyle.current

    // استخدمنا Box خارجي عشان الأيقونة لما تطلع بره الكارد متتقصش
    Box(
        modifier = modifier
            .width(160.dp)
            .height(85.dp) // زودنا الارتفاع الكلي للبوكس عشان النجمة المرفوعة
    ) {
        // 1. الكارد (جسم التصميم)
        Card(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(71.dp) // ارتفاع الكارد الثابت من الفيجما
                .align(Alignment.BottomCenter), // الكارد يقعد تحت والنجمة تبرز فوقه
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFEEEEEE)),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            // نصوص الكارد
            Column(
                modifier = Modifier.padding(start = 12.dp, top = 12.dp)
            ) {
                Text(
                    text = title,
                    style = typography.body.small.copy(fontSize = 12.sp),
                    color = Color.Gray
                )
                Text(
                    text = value,
                    style = typography.title.large.copy(fontSize = 18.sp, fontWeight = FontWeight.Bold),
                    color = Color.Black
                )
            }
        }

        // 2. الأيقونة (النجمة / الساعة)
        // حطيناها بره الكارد (جوه البوكس الكبير) عشان متتقصش
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .size(width = 64.dp, height = 71.dp)
                .align(Alignment.TopEnd) // هتبدأ من فوق خالص
                .offset(x = (4).dp, y = (-4).dp), // الارتفاع "سيكا" (Top -4) والبروز يميناً
            contentScale = ContentScale.Fit
        )
    }
}