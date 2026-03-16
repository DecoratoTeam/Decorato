package com.example.decorato.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.decorato.R
import com.example.decorato.presentation.components.buttons.IconButton
import com.example.decorato.presentation.theme.AppTheme
import com.example.decorato.presentation.theme.DecoratoTheme
import com.example.decorato.presentation.utils.ThemeAndLocalePreviews


@Composable
fun DefaultAppBar(
    modifier: Modifier = Modifier,
    title: String = "",
    showNavigateBackButton: Boolean = true,
    firstOption: Painter? = null,
    firstOptionIconTint: Color = AppTheme.color.body,
    lastOptionIconTint: Color = AppTheme.color.body,
    firstOptionContentDescription: String? = null,
    lastOption: Painter? = null,
    lastOptionContentDescription: String? = null,
    containerColor: Color = Color.Unspecified,
    onFirstOptionClicked: () -> Unit = {},
    onLastOptionClicked: () -> Unit = {},
    onNavigateBackClicked: () -> Unit = {},
) {


    TopAppBar(
        modifier = modifier,
        containerColor = containerColor,
        title =
            title.takeIf { it.isNotBlank() }?.let { text ->
                {
                    Box(Modifier.height(40.dp), contentAlignment = Alignment.Center) {
                        Text(
                            text = text,
                            color = AppTheme.color.titleL,
                            style = AppTheme.textStyle.title.large,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            },
        leadingIcon =
            if (showNavigateBackButton) {
                {
                    IconButton(
                        painter = painterResource(R.drawable.ic_arrow_left),
                        tint = AppTheme.color.titleL,
                        contentDescription = "Back to menu",
                        onClick = onNavigateBackClicked,
                    )
                }
            } else {
                null
            },
        middleIcon =
            firstOption?.let { painter ->
                {
                    IconButton(
                        painter = painter,
                        contentDescription = firstOptionContentDescription,
                        tint = firstOptionIconTint,
                        paddingValues = PaddingValues(8.dp),
                        onClick = onFirstOptionClicked,
                    )
                }
            },
        trailingIcon =
            lastOption?.let { painter ->
                {
                    IconButton(
                        painter = painter,
                        contentDescription = lastOptionContentDescription,
                        tint = lastOptionIconTint,
                        paddingValues = PaddingValues(8.dp),
                        onClick = onLastOptionClicked,
                    )
                }
            },
    )
}

@ThemeAndLocalePreviews
@Composable
private fun DefaultAppBarPreview() {
    DecoratoTheme {
        DefaultAppBar(
            title = stringResource(R.string.app_name),
            firstOption = painterResource(R.drawable.ic_arrow_left),
            lastOption = painterResource(R.drawable.ic_arrow_left),
            containerColor = AppTheme.color.surface,
        )
    }
}

@ThemeAndLocalePreviews
@Composable
private fun DefaultAppBaarPreview() {
    DecoratoTheme {
        DefaultAppBar(
            title = stringResource(R.string.app_name),
            containerColor = AppTheme.color.surface,
            showNavigateBackButton = false
        )
    }
}
