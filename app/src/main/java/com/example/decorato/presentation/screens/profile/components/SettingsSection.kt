package com.example.decorato.presentation.screens.profile.components

import OptionRow
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
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
    version: String = "Version 1.0.1"
) {
    val typography = LocalDecoratoTextStyle.current
    val colors = LocalDecoratoAppColors.current

    // Column حر تماماً عشان نضمن إن مفيش حاجة تزنق الـ Settings
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        // 1. كلمة Settings (مستقلة ومحاذاتها للشمال)
        Text(
            text = "Settings",
            style = typography.title.small,
            color = colors.titleL,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        // 2. الحاوية البيضاء (فقط للإعدادات - Height 168px)
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
                // الصفوف الثلاثة (كل واحد 56px)
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
                SettingRow(
                    title = stringResource(R.string.language),
                    icon = R.drawable.ic_language,
                    trailing = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = currentLanguage, style = typography.body.small, color = colors.hint)
                            Spacer(modifier = Modifier.width(4.dp))
                            Icon(painterResource(R.drawable.ic_arrow_right), null, modifier = Modifier.size(16.dp), tint = colors.hint)
                        }
                    },
                    onClick = onLanguageClick
                )
                SettingRow(
                    title = stringResource(R.string.logout),
                    icon = R.drawable.ic_logout,
                    isLast = true,
                    onClick = onLogoutClick
                )
            }
        }

        // 3. كلمة Version (مستقلة وتحت خالص في النص)
        Text(
            text = version,
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
    // تحديد لون النص والأيقونة بناءً على النوع (Logout بياخد لون أحمر خفيف سيكا)
    val contentColor = if (title == "Logout") Color(0xFFE57373) else Color.Black

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
            horizontalArrangement = Arrangement.spacedBy(12.dp) // المسافة بين الأيقونة والكلام
        ) {
            // الأيقونة
            Icon(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = if (title == "Logout") contentColor else Color.Unspecified
            )

            // العنوان
            Text(
                text = title,
                modifier = Modifier.weight(1f),
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 14.sp,
                    color = contentColor
                )
            )

            // الـ Trailing (اللي هو السهم في حالة اللغة)
            trailing?.invoke()
        }

        // الخط الفاصل (Divider) نخليه خفيف جداً زي الفيجما
        if (!isLast) {
            androidx.compose.material3.HorizontalDivider(
                modifier = Modifier.align(Alignment.BottomCenter),
                thickness = 0.5.dp, // خليه رفيع جداً (0.5) عشان يبان شيك
                color = Color(0xFFF1F1F1)
            )
        }
    }
}