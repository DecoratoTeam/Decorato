package com.example.decorato.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.decorato.R
import com.example.decorato.presentation.components.buttons.OutlinedButton
import com.example.decorato.presentation.theme.AppTheme
import com.example.decorato.presentation.theme.DecoratoTheme
import com.example.decorato.presentation.utils.ThemeAndLocalePreviews

@Composable
fun NoNetworkContainer(
    onClickRetry: () -> Unit,
    modifier: Modifier = Modifier,
    imageRes: Painter = painterResource(R.drawable.ic_no_internet),
    title: String = stringResource(R.string.offline_message),
    description: String = stringResource(R.string.offline_description),
    showRetryLoading: Boolean = false
) {
    Column(
        modifier = modifier.fillMaxWidth().padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = imageRes,
            contentDescription = stringResource(R.string.offline_message),
        )
        Text(
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
            text = title,
            textAlign = TextAlign.Center,
            style = AppTheme.textStyle.title.medium,
            color = AppTheme.color.titleL,
        )
        if(description.isNotEmpty()){
            Text(
                text = description,
                textAlign = TextAlign.Center,
                style = AppTheme.textStyle.body.small,
                color = AppTheme.color.body,
            )
        }
        OutlinedButton(
            title = stringResource(R.string.try_again),
            onClick = onClickRetry,
            isEnabled = true,
            isLoading = showRetryLoading,
            isNegative = false,
            modifier = Modifier.padding(top = 16.dp).fillMaxWidth(),
        )
    }
}

@Composable
@ThemeAndLocalePreviews
private fun NoNetworkContainerPreview() {
    DecoratoTheme {
        NoNetworkContainer(
            onClickRetry = {},
        )
    }
}
