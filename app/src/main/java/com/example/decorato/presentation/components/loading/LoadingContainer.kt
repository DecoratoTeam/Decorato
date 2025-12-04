package com.example.decorato.presentation.components.loading

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.decorato.R
import com.example.decorato.presentation.theme.AppTheme
import com.example.decorato.presentation.utils.ThemeAndLocalePreviews


@Composable
fun LoadingContainer(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        LoadingIndicator()
        Text(
            text = stringResource(R.string.loading),
            style = AppTheme.textStyle.label.medium,
            color = AppTheme.color.body,
            modifier = Modifier.padding(top = 8.dp),
        )
    }
}

@Composable
@ThemeAndLocalePreviews
private fun LoadingContainerPreview() {
    LoadingContainer()
}
