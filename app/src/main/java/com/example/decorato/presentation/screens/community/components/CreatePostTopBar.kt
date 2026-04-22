package com.example.decorato.presentation.screens.community.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.decorato.R
import com.example.decorato.presentation.theme.colors.LocalDecoratoAppColors

@Composable
fun CreatePostTopBar(
    onBackClick: () -> Unit,
    onPublishClick: () -> Unit,
    canPublish: Boolean,
    isPublishing: Boolean
) {
    val colors = LocalDecoratoAppColors.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .height(56.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // --- سكشن السهم + العنوان (مجموعين مع بعض عشان نتحكم في المسافة) ---
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f) // بياخد المساحة المتاحة ويزق زرار ببلش للآخر
        ) {
            IconButton(
                onClick = onBackClick,
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(12.dp)) // تغيير من دائرة لـ 12dp زي الفيجما
                    .background(colors.surfaceHigh)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = stringResource(R.string.back),
                    modifier = Modifier.size(24.dp),
                    tint = colors.titleL
                )
            }

            Spacer(modifier = Modifier.width(10.dp)) // الـ Gap اللي في الفيجما (10px)

            Text(
                text = stringResource(R.string.create_a_post),
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    lineHeight = 28.sp,
                    color = colors.secondary
                )
            )
        }

        // --- زرار Publish ---
        Button(
            onClick = onPublishClick,
            enabled = canPublish && !isPublishing,
            modifier = Modifier
                .width(81.dp)
                .height(36.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colors.primary, // في الدارك مود ده هيكون المينت المنور
                contentColor = Color.Black,
                // تعديل ألوان الـ Disable عشان تناسب الدارك مود
                disabledContainerColor = colors.surfaceHigh.copy(alpha = 0.5f),
                disabledContentColor = colors.hint.copy(alpha = 0.5f)
            ),
            contentPadding = PaddingValues(0.dp)
        ) {
            if (isPublishing) {
                CircularProgressIndicator(
                    modifier = Modifier.size(16.dp),
                    strokeWidth = 2.dp,
                    color = Color.Black
                )
            } else {
                Text(
                    text = stringResource(R.string.publish),
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    )
                )
            }
        }
    }
}