package com.example.decorato.presentation.screens.generate.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.decorato.R
import com.example.decorato.presentation.application.LocalNavManager
import com.example.decorato.presentation.components.DefaultAppBar
import com.example.decorato.presentation.theme.AppTheme
import com.example.decorato.presentation.viewModel.generate.chat.GenerateChatEffect
import com.example.decorato.presentation.viewModel.generate.chat.GenerateChatInteractionListener
import com.example.decorato.presentation.viewModel.generate.chat.GenerateChatUiState
import com.example.decorato.presentation.viewModel.generate.chat.GenerateChatViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun GenerateChatScreen(
    viewModel: GenerateChatViewModel = hiltViewModel()
) {
    val navManager = LocalNavManager.current
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.effect.collectLatest { effect ->
            when (effect) {
                GenerateChatEffect.NavigateBack -> navManager.navigateBack()
            }
        }
    }

    GenerateChatScreenContent(
        state = state,
        listener = viewModel
    )
}

@Composable
private fun GenerateChatScreenContent(
    state: GenerateChatUiState,
    listener: GenerateChatInteractionListener,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(AppTheme.color.surface)
            .statusBarsPadding()
            .navigationBarsPadding()
            .imePadding()
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {

            DefaultAppBar(
                title = stringResource(R.string.generate_title),
                showNavigateBackButton = true,
                containerColor = AppTheme.color.surface,
                onNavigateBackClicked = listener::onBackClick
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Bot title
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_decobot),
                    contentDescription = "DecoBot Icon",
                    tint = AppTheme.color.primary,
                    modifier = Modifier.size(100.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = stringResource(R.string.generate_bot_name),
                    style = AppTheme.textStyle.title.large,
                    color = AppTheme.color.primary
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = AppTheme.color.onPrimaryBody),
                border = androidx.compose.foundation.BorderStroke(1.dp, AppTheme.color.primary),
                modifier = Modifier.padding(horizontal = 40.dp)
            ) {
                Text(
                    text = state.hintText,
                    style = AppTheme.textStyle.body.medium,
                    color = AppTheme.color.hint,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(14.dp)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = AppTheme.color.onPrimaryBody),
                border = androidx.compose.foundation.BorderStroke(1.dp, AppTheme.color.primary)
            ) {
                Text(
                    text = state.resultText,
                    style = AppTheme.textStyle.body.medium,
                    color = AppTheme.color.hint,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(14.dp)
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            val isMessageNotEmpty = state.message.trim().isNotEmpty()

            // Bottom input
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .background(
                        color = AppTheme.color.onPrimary,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .border(
                        width = 1.dp,
                        color = if (isMessageNotEmpty) AppTheme.color.primary else Color.Transparent,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(horizontal = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = state.message,
                    onValueChange = listener::onMessageChanged,
                    placeholder = {
                        Text(
                            text = stringResource(R.string.generate_type_here),
                            style = AppTheme.textStyle.body.small,
                            color = AppTheme.color.hint
                        )
                    },
                    singleLine = true,
                    shape = RoundedCornerShape(10.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        disabledBorderColor = Color.Transparent,
                        focusedContainerColor = AppTheme.color.greenVariant,
                        unfocusedContainerColor = AppTheme.color.greenVariant
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .height(55.dp)
                )

                IconButton(
                    onClick = listener::onMicClick,
                    modifier = Modifier
                        .size(44.dp)
                        .background(AppTheme.color.greenVariant, RoundedCornerShape(10.dp))
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_attachment),
                        contentDescription = stringResource(R.string.attachment),
                        tint = AppTheme.color.body
                    )
                }

                IconButton(
                    onClick = listener::onSendClick,
                    enabled = isMessageNotEmpty,
                    modifier = Modifier
                        .size(44.dp)
                        .background(
                            if (isMessageNotEmpty) AppTheme.color.primary else AppTheme.color.hint,
                            RoundedCornerShape(10.dp)
                        )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_send),
                        contentDescription = stringResource(R.string.send),
                        tint = AppTheme.color.onPrimary
                    )
                }
            }
        }
    }
}