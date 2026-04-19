package com.example.decorato.presentation.screens.generate.chat

import android.Manifest
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.content.FileProvider
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.decorato.R
import com.example.decorato.presentation.application.LocalNavManager
import com.example.decorato.presentation.components.DefaultAppBar
import com.example.decorato.presentation.theme.AppTheme
import com.example.decorato.presentation.viewModel.generate.chat.GenerateChatEffect
import com.example.decorato.presentation.viewModel.generate.chat.GenerateChatInteractionListener
import com.example.decorato.presentation.viewModel.generate.chat.GenerateChatMessageType
import com.example.decorato.presentation.viewModel.generate.chat.GenerateChatUiState
import com.example.decorato.presentation.viewModel.generate.chat.GenerateChatViewModel
import kotlinx.coroutines.flow.collectLatest
import java.io.File

@Composable
fun GenerateChatScreen(
    viewModel: GenerateChatViewModel = hiltViewModel()
) {
    val navManager = LocalNavManager.current
    val state by viewModel.state.collectAsStateWithLifecycle()
    val context = LocalContext.current

    var tempCameraUri by remember { mutableStateOf<Uri?>(null) }

    val takePictureLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture()
    ) { success ->
        if (success && tempCameraUri != null) {
            viewModel.onCameraImageCaptured(tempCameraUri.toString())
        } else {
            Toast.makeText(context, "No image captured", Toast.LENGTH_SHORT).show()
        }
    }

    val cameraPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { granted ->
        if (granted) {
            val uri = createTempImageUri(context)
            tempCameraUri = uri
            if (uri != null) {
                takePictureLauncher.launch(uri)
            } else {
                Toast.makeText(context, "Failed to create image file", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(context, "Camera permission denied", Toast.LENGTH_SHORT).show()
        }
    }

    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        if (uri != null) {
            viewModel.onGalleryImagePicked(uri.toString())
        } else {
            Toast.makeText(context, "No image selected", Toast.LENGTH_SHORT).show()
        }
    }

    LaunchedEffect(Unit) {
        viewModel.effect.collectLatest { effect ->
            when (effect) {
                GenerateChatEffect.NavigateBack -> navManager.navigateBack()
                GenerateChatEffect.OpenCamera -> cameraPermissionLauncher.launch(Manifest.permission.CAMERA)
                GenerateChatEffect.OpenGallery -> galleryLauncher.launch("image/*") // ✅ جديد
            }
        }
    }

    GenerateChatScreenContent(
        state = state,
        listener = viewModel
    )
}

private fun createTempImageUri(context: Context): Uri? {
    return try {
        val imageFile = File.createTempFile(
            "camera_${System.currentTimeMillis()}",
            ".jpg",
            context.cacheDir
        )
        FileProvider.getUriForFile(
            context,
            "${context.packageName}.provider",
            imageFile
        )
    } catch (_: Exception) {
        null
    }
}

@Composable
private fun GenerateChatScreenContent(
    state: GenerateChatUiState,
    listener: GenerateChatInteractionListener,
    modifier: Modifier = Modifier
) {
    val isMessageNotEmpty = state.message.trim().isNotEmpty()

    if (state.showAttachmentSheet) {
        AttachmentBottomSheet(listener = listener)
    }

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

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                contentPadding = PaddingValues(bottom = 12.dp)
            ) {
                item {
                    Spacer(modifier = Modifier.height(24.dp))

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_decobot),
                            contentDescription = null,
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
                            text = stringResource(R.string.generate_hint_card_text),
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
                            text = stringResource(R.string.generate_result_card_text),
                            style = AppTheme.textStyle.body.medium,
                            color = AppTheme.color.hint,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(14.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))
                }

                items(state.messages, key = { it.id }) { item ->
                    when (item.type) {
                        GenerateChatMessageType.USER_IMAGE -> {
                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.CenterEnd
                            ) {
                                Card(
                                    shape = RoundedCornerShape(12.dp),
                                    colors = CardDefaults.cardColors(containerColor = AppTheme.color.onPrimary),
                                    modifier = Modifier.fillMaxWidth(0.52f)
                                ) {
                                    AsyncImage(
                                        model = item.localImageUri,
                                        contentDescription = item.fileName,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(110.dp)
                                            .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
                                    )
                                    Text(
                                        text = item.fileName.ifBlank { "Image.jpeg" },
                                        color = AppTheme.color.hint,
                                        style = AppTheme.textStyle.body.small,
                                        modifier = Modifier
                                            .align(Alignment.End)
                                            .padding(horizontal = 10.dp, vertical = 8.dp)
                                    )
                                }
                            }
                        }

                        GenerateChatMessageType.USER_TEXT -> {
                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.CenterEnd
                            ) {
                                Card(
                                    shape = RoundedCornerShape(12.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = AppTheme.color.primary.copy(alpha = 0.75f)
                                    )
                                ) {
                                    Text(
                                        text = item.text,
                                        color = AppTheme.color.onPrimary,
                                        style = AppTheme.textStyle.body.medium,
                                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp)
                                    )
                                }
                            }
                        }

                        GenerateChatMessageType.BOT_TEXT -> {
                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.CenterStart
                            ) {
                                Card(
                                    shape = RoundedCornerShape(12.dp),
                                    colors = CardDefaults.cardColors(containerColor = AppTheme.color.onPrimaryBody)
                                ) {
                                    Text(
                                        text = item.text,
                                        color = AppTheme.color.hint,
                                        style = AppTheme.textStyle.body.medium,
                                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp)
                                    )
                                }
                            }
                        }

                        GenerateChatMessageType.BOT_IMAGE -> {
                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.CenterStart
                            ) {
                                AsyncImage(
                                    model = item.imageUrl,
                                    contentDescription = "generated design",
                                    modifier = Modifier
                                        .fillMaxWidth(0.62f)
                                        .height(150.dp)
                                        .clip(RoundedCornerShape(14.dp)),
                                    contentScale = ContentScale.Crop
                                )
                            }
                        }
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .imePadding()
                    .background(
                        color = AppTheme.color.onPrimary,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .border(
                        width = 1.dp,
                        color = if (isMessageNotEmpty || state.selectedAttachmentName != null) AppTheme.color.primary else Color.Transparent,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(horizontal = 12.dp, vertical = 10.dp)
            ) {
                state.selectedAttachmentName?.let { fileName ->
                    Card(
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(containerColor = AppTheme.color.surface),
                        border = androidx.compose.foundation.BorderStroke(
                            1.dp,
                            AppTheme.color.primary.copy(alpha = 0.35f)
                        ),
                        modifier = Modifier.wrapContentWidth()
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_image),
                                contentDescription = null,
                                tint = AppTheme.color.hint,
                                modifier = Modifier.size(14.dp)
                            )
                            Text(
                                text = fileName,
                                style = AppTheme.textStyle.body.small,
                                color = AppTheme.color.body
                            )
                            IconButton(
                                onClick = listener::onRemoveAttachmentClick,
                                modifier = Modifier.size(16.dp)
                            ) {
                                Text(
                                    text = "×",
                                    color = AppTheme.color.hint,
                                    style = AppTheme.textStyle.body.small
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp),
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
                        modifier = Modifier.weight(1f)
                    )

                    IconButton(
                        onClick = listener::onAttachmentClick,
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
                        enabled = isMessageNotEmpty || state.selectedAttachmentUri != null,
                        modifier = Modifier
                            .size(44.dp)
                            .background(
                                if (isMessageNotEmpty || state.selectedAttachmentUri != null) AppTheme.color.primary else AppTheme.color.hint,
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
}