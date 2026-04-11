package com.example.decorato.presentation.screens.login.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.decorato.presentation.theme.AppTheme

@Composable
fun PrimaryVariantButton(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    // 🔥 الزتونة: ضفنا متغير للون النص عشان نتحكم فيه براحتنا
    textColor: Color = AppTheme.color.body,
    isEnabled: Boolean = true,
    isLoading: Boolean = false
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .clickable(enabled = isEnabled && !isLoading, onClick = onClick),
        color = AppTheme.color.primaryVariant,
        border = BorderStroke(1.dp, AppTheme.color.stroke),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                style = AppTheme.textStyle.label.medium,
                color = textColor // 👈 هيقرأ اللون اللي هنبعته
            )
        }
    }
}