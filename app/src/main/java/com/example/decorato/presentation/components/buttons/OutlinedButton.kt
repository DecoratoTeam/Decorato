package com.example.decorato.presentation.components.buttons

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.decorato.presentation.theme.DecoratoTheme
import com.example.decorato.presentation.utils.ThemeAndLocalePreviews


@Composable
fun OutlinedButton(
    title: String,
    onClick: () -> Unit,
    isEnabled: Boolean,
    isLoading: Boolean,
    isNegative: Boolean,
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    icon: (@Composable (tint: Color) -> Unit)? = null,
) {
    BaseButton(
        title = title,
        icon = icon,
        onClick = onClick,
        isLoading = isLoading,
        isEnabled = isEnabled,
        isNegative = isNegative,
        isSecondary = true,
        modifier = modifier,
        colors = colors,
    )
}

@ThemeAndLocalePreviews
@Composable
private fun OutlinedButtonPreview() {
    DecoratoTheme {
        Box(
            modifier = Modifier.padding(16.dp),
        ) {
            OutlinedButton(
                title = "Button",
                onClick = {},
                isEnabled = true,
                isLoading = false,
                isNegative = false,
                modifier = Modifier,
            )
        }
    }
}
