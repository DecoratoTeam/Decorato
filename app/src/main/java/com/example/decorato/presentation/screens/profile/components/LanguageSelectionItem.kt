package com.example.decorato.presentation.screens.profile.components

import OptionRow
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource // استدعاء مكتبة النصوص
import androidx.compose.ui.unit.dp
import com.example.decorato.R
import com.example.decorato.domain.model.AppLanguage
import com.example.decorato.presentation.theme.colors.LocalDecoratoAppColors

@Composable
fun LanguageSelectionItem(
    // لو مش محتاجة الـ currentLanguage عشان تعرضيها، ممكن تشيلي البراميتر ده خالص
    onClick: () -> Unit
) {
    val colors = LocalDecoratoAppColors.current

    OptionRow(
        title = stringResource(id = R.string.language),
        painter = painterResource(id = R.drawable.ic_language),
        onClick = onClick,
        trailingContent = {
            // الزيتونة: استبدلنا النص بالسهم اللي في الفيجما
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_right),
                contentDescription = null,
                modifier = Modifier.size(16.dp),
                tint = colors.hint // أو Color.LightGray حسب الفيجما
            )
        }
    )
}