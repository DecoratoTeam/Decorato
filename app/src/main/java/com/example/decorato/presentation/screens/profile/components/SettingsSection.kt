package com.example.decorato.presentation.screens.profile.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.decorato.R
import com.example.decorato.presentation.components.Text
import com.example.decorato.presentation.theme.colors.LocalDecoratoAppColors
import com.example.decorato.presentation.theme.textStyle.LocalDecoratoTextStyle

@Composable
fun SettingsSection(
    isDarkMode: Boolean,
    onDarkModeChange: (Boolean) -> Unit,
    currentLanguage: String,
    onLanguageClick: () -> Unit,
    onLogoutClick: () -> Unit,
    version: String = "1.0.1"
) {
    val typography = LocalDecoratoTextStyle.current
    val colors = LocalDecoratoAppColors.current
    val layoutDirection = LocalLayoutDirection.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        // 1. عنوان القسم
        Text(
            text = stringResource(R.string.settings),
            style = typography.title.small,
            color = colors.titleL,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        // 2. الحاوية البيضاء للإعدادات
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(168.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            border = BorderStroke(1.dp, Color(0xFFF5F5F5))
        ) {
            Column(modifier = Modifier.fillMaxSize()) {

                // --- صف الدارك مود ---
                SettingRow(
                    title = stringResource(R.string.darkMode),
                    icon = R.drawable.ic_dark_mode,
                    trailing = {
                        Switch(
                            checked = isDarkMode,
                            onCheckedChange = onDarkModeChange,
                            colors = SwitchDefaults.colors(checkedTrackColor = colors.primary)
                        )
                    }
                )

                // --- صف اللغة ---
                SettingRow(
                    title = stringResource(R.string.language),
                    icon = R.drawable.ic_language,
                    trailing = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = currentLanguage, style = typography.body.small, color = colors.hint)
                            Spacer(modifier = Modifier.width(4.dp))
                            Icon(
                                painter = painterResource(id = R.drawable.ic_arrow_right),
                                contentDescription = null,
                                modifier = Modifier.size(16.dp).graphicsLayer {
                                    rotationY = if (layoutDirection == LayoutDirection.Rtl) 180f else 0f
                                },
                                tint = colors.hint
                            )
                        }
                    },
                    onClick = onLanguageClick
                )

                // --- صف تسجيل الخروج ---
                SettingRow(
                    title = stringResource(R.string.logout),
                    icon = R.drawable.ic_logout,
                    isLast = true,
                    trailing = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrow_right),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp).graphicsLayer {
                                rotationY = if (layoutDirection == LayoutDirection.Rtl) 180f else 0f
                            },
                            tint = Color(0xFFE57373) // لون أحمر متناسق مع كلمة Logout
                        )
                    },
                    onClick = onLogoutClick
                )
            }
        }

        // 3. رقم الإصدار
        Text(
            "${stringResource(R.string.version)} $version",
            style = typography.body.small,
            color = colors.hint.copy(alpha = 0.5f),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun SettingRow(
    title: String,
    icon: Int,
    isLast: Boolean = false,
    onClick: (() -> Unit)? = null,
    trailing: @Composable (() -> Unit)? = null
) {
    val colors = LocalDecoratoAppColors.current
    // "الزيتونة": بنلون الخروج بالأحمر بناءً على الأيقونة عشان نتفادى مشاكل الترجمة
    val isLogout = icon == R.drawable.ic_logout
    val contentColor = if (isLogout) Color(0xFFE57373) else Color.Black

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable(enabled = onClick != null) { onClick?.invoke() }
            .padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Icon(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = if (isLogout) contentColor else Color.Unspecified
            )

            Text(
                text = title,
                modifier = Modifier.weight(1f),
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 14.sp,
                    color = contentColor
                )
            )

            trailing?.invoke()
        }

        if (!isLast) {
            HorizontalDivider(
                modifier = Modifier.align(Alignment.BottomCenter),
                thickness = 0.5.dp,
                color = colors.stroke
            )
        }
    }
}