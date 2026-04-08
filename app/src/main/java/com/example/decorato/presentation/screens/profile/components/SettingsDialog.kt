package com.example.decorato.presentation.screens.profile.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.decorato.presentation.theme.colors.LocalDecoratoAppColors

@Composable
fun SettingsDialog(
    onDismiss: () -> Unit,
    // بنمرر الـ Section جوه الدايلوج عشان م نكررش كود
    content: @Composable () -> Unit
) {
    val colors = LocalDecoratoAppColors.current

    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = colors.surface
            )
        ) {
            Column(
                modifier = Modifier
                    .padding(8.dp) // padding بسيط عشان الـ Section جواه فيه padding أصلاً
                    .fillMaxWidth()
            ) {
                // بنعرض المحتوى اللي هو الـ SettingsSection
                content()
            }
        }
    }
}