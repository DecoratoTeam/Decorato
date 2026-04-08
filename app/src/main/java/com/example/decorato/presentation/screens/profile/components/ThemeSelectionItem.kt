package com.example.decorato.presentation.screens.profile.components

import OptionRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.decorato.R
import com.example.decorato.presentation.theme.colors.LocalDecoratoAppColors

@Composable
fun ThemeSelectionItem(
    currentTheme: String, // مثلاً "Dark" أو "Light"
    onClick: () -> Unit
) {
    val colors = LocalDecoratoAppColors.current

    OptionRow(
        // استخدام المعرف من strings.xml (تأكدي من وجوده باسم darkMode أو theme)
        title = stringResource(id = R.string.darkMode),
        // أيقونة الثيم (احفظيها باسم ic_theme أو ic_dark_mode)
        painter = painterResource(id = R.drawable.ic_dark_mode),
        onClick = onClick,
        trailingContent = {
            Text(
                text = currentTheme,
                color = colors.hint
            )
        }
    )
}