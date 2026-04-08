package com.example.decorato.presentation.screens.profile.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.decorato.R
import com.example.decorato.presentation.theme.colors.LocalDecoratoAppColors
import com.example.decorato.presentation.theme.textStyle.LocalDecoratoTextStyle

@Composable
fun ThemeDialog(
    onConfirm: (Boolean) -> Unit, // true للـ Dark، false للـ Light
    onDismiss: () -> Unit
) {
    val colors = LocalDecoratoAppColors.current
    val typography = LocalDecoratoTextStyle.current

    Dialog(onDismissRequest = onDismiss) {
        Card(
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = colors.surface)
        ) {
            Column(modifier = Modifier.padding(24.dp)) {
                Text(
                    text = stringResource(id = R.string.darkMode),
                    style = typography.title.medium,
                    color = colors.titleL
                )

                Spacer(Modifier.height(16.dp))

                // تقدري تعملي اختيارين هنا بنفس ستايل الـ LanguageOptionRow
                // حالياً هنكتفي بتبديل بسيط أو تقدري تكرري الـ Row

                Text(
                    text = "This will change the app appearance.",
                    style = typography.body.small,
                    color = colors.body
                )

                Spacer(Modifier.height(24.dp))

                Button(
                    onClick = { onConfirm(true) }, // مثال
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                    colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                        containerColor = colors.primary,
                        contentColor = colors.onPrimary
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(text = stringResource(id = R.string.confirm))
                }
            }
        }
    }
}