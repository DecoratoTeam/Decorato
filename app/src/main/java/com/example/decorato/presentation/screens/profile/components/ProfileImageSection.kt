package com.example.decorato.presentation.screens.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.example.decorato.R
import com.example.decorato.presentation.components.Text
import com.example.decorato.presentation.theme.colors.LocalDecoratoAppColors
import com.example.decorato.presentation.theme.textStyle.LocalDecoratoTextStyle

@Composable
fun ProfileImageSection(
    userName: String,
    userImage: String,
    onClickEdit: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxWidth().height(260.dp)
    ) {
        // الخلفية المستقيمة تماماً (Height 212)
        Image(
            painter = painterResource(id = R.drawable.profile_header_placeholder),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().height(212.dp),
            contentScale = ContentScale.FillBounds
        )

        // كلمة My Profile (أخضر غامق، محاذاة للشمال)
        androidx.compose.material3.Text(
            text = "My Profile",
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF003D33) // اللون الأخضر من الفيجما
            ),
            modifier = Modifier.padding(top = 50.dp, start = 20.dp)
        )

        // الصورة والاسم
        Column(
            modifier = Modifier.align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberAsyncImagePainter(userImage),
                contentDescription = null,
                modifier = Modifier
                    .size(96.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.White, CircleShape)
                    .clickable { onClickEdit() },
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(12.dp))
            androidx.compose.material3.Text(
                text = userName,
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
            )
        }
    }
}