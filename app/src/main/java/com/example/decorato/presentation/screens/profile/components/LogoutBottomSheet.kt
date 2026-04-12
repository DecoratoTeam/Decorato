package com.example.decorato.presentation.screens.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.decorato.R
import com.example.decorato.presentation.theme.colors.LocalDecoratoAppColors
import com.example.decorato.presentation.theme.textStyle.LocalDecoratoTextStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogoutBottomSheet(
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
) {
    val colors = LocalDecoratoAppColors.current
    val typography = LocalDecoratoTextStyle.current

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        containerColor = Color.Transparent, // الزيتونة: عشان الكارد يبان طاير
        dragHandle = null,
        scrimColor = Color.Black.copy(alpha = 0.4f)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 24.dp),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = colors.surface)
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // شريط السحب الصغير (Handle)
                Box(
                    modifier = Modifier
                        .width(40.dp)
                        .height(4.dp)
                        .background(colors.body.copy(alpha = 0.1f), CircleShape)
                )

                Spacer(modifier = Modifier.height(20.dp))

                // الأيقونة (السهم)
                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .background(colors.red.copy(alpha = 0.1f), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_logout),
                        contentDescription = null,
                        // لو السهم لسه غريب جربي Color.Unspecified أو colors.red
                        tint = colors.red,
                        modifier = Modifier.size(28.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // العنوان (الزيتونة: fontSize أصغر شوية عشان يفرش سطر واحد)
                Text(
                    text = stringResource(id = R.string.logoutConfirmMsg),
                    style = typography.title.medium.copy(fontSize = 16.sp),
                    color = colors.titleL,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 1
                )

                Spacer(modifier = Modifier.height(8.dp))

                // الوصف
                Text(
                    text = stringResource(id = R.string.logoutDesc),
                    style = typography.body.small,
                    color = colors.body,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 4.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                // الزراير ( Cancel & Logout )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // زرار الكانسل (ألوان الفيجما بالظبط)
                    Button(
                        onClick = onDismiss,
                        modifier = Modifier.weight(1f).height(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFE1F5F2), // Mint Green
                            contentColor = Color(0xFF1ABC9C)    // Dark Mint Text
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.cancel),
                            style = typography.label.medium,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    // زرار الخروج
                    Button(
                        onClick = onConfirm,
                        modifier = Modifier.weight(1f).height(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colors.red,
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.logout),
                            style = typography.label.medium,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }
    }
}