package com.example.decorato.presentation.screens.generate

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.decorato.R
import com.example.decorato.presentation.application.LocalNavManager
import com.example.decorato.presentation.components.buttons.ConfirmButton
import com.example.decorato.presentation.theme.AppTheme
import com.example.decorato.presentation.theme.DecoratoTheme
import com.example.decorato.presentation.utils.ThemeAndLocalePreviews
import com.example.decorato.presentation.viewModel.generate.GenerateEffect
import com.example.decorato.presentation.viewModel.generate.GenerateInteractionListener
import com.example.decorato.presentation.viewModel.generate.GenerateUiState
import com.example.decorato.presentation.viewModel.generate.GenerateViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun GenerateScreen(
    viewModel: GenerateViewModel = hiltViewModel()
) {
    val navigationManager = LocalNavManager.current
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.effect.collectLatest { effect ->
            when (effect) {
                GenerateEffect.NavigateToChat -> {
                    navigationManager.toGenerateChat()
                }
            }
        }
    }

    GenerateScreenContent(
        state = state,
        listener = viewModel
    )
}

@Composable
private fun GenerateScreenContent(
    state: GenerateUiState,
    listener: GenerateInteractionListener,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(AppTheme.color.surface)
            .statusBarsPadding()
            .navigationBarsPadding()
            .padding(horizontal = 24.dp, vertical = 16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(110.dp))

            Image(
                painter = painterResource(id = R.drawable.ic_decobot),
                contentDescription = "DecoBot Icon",
                modifier = Modifier.size(120.dp),
                colorFilter = ColorFilter.tint(AppTheme.color.primary)
            )

            Spacer(modifier = Modifier.height(28.dp))

            Text(
                text = stringResource(R.string.generate_welcome_to),
                style = AppTheme.textStyle.title.large,
                color = AppTheme.color.titleL
            )

            Text(
                text = stringResource(R.string.generate_bot_name),
                style = AppTheme.textStyle.title.large,
                color = AppTheme.color.primary
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = stringResource(R.string.generate_welcome_subtitle),
                style = AppTheme.textStyle.body.medium,
                color = AppTheme.color.hint,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 8.dp)
            )

            Spacer(modifier = Modifier.height(100.dp))

            ConfirmButton(
                title = stringResource(R.string.start_chat),
                onClick = listener::onStartChatClick,
                isEnabled = !state.isLoading,
                isLoading = state.isLoading,
                isNegative = false
            )

            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@ThemeAndLocalePreviews
@Composable
private fun GenerateScreenPreview() {
    DecoratoTheme {
        GenerateScreenContent(
            state = GenerateUiState(),
            listener = object : GenerateInteractionListener {
                override fun onStartChatClick() = Unit
            }
        )
    }
}