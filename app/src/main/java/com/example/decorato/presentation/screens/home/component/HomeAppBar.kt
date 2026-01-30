package com.example.decorato.presentation.screens.home.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.decorato.R
import com.example.decorato.presentation.components.Text
import com.example.decorato.presentation.components.TopAppBar
import com.example.decorato.presentation.components.buttons.IconButton
import com.example.decorato.presentation.theme.AppTheme
import com.example.decorato.presentation.theme.DecoratoTheme
import com.example.decorato.presentation.utils.ThemeAndLocalePreviews


@Composable
fun HomeAppBar(
    modifier: Modifier = Modifier,
    containerColor: Color = Color.Unspecified,
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = stringResource(R.string.app_name),
                color = AppTheme.color.secondary,
                style = AppTheme.textStyle.appName.large,
            )
        },
        containerColor = containerColor,
        subTitle = {
            Text(
                modifier = Modifier.fillMaxWidth(0.85f),
                text = stringResource(R.string.decorato_description),
                color = AppTheme.color.body,
                style = AppTheme.textStyle.label.small,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        leadingIcon = {
            IconButton(
                painter = painterResource(R.drawable.ic_logo),
                contentDescription = stringResource(R.string.app_name),
                containerColor = AppTheme.color.primaryVariant,
                paddingValues = PaddingValues(horizontal = 6.dp, vertical = 9.dp),
                withBorder = true,
            )
        },
    )
}

@ThemeAndLocalePreviews
@Composable
private fun HomeAppBarPreview() {
    DecoratoTheme {
        HomeAppBar(
            containerColor = AppTheme.color.surface,
        )
    }
}
