package com.example.decorato.presentation.screens.generate.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.decorato.R
import com.example.decorato.presentation.components.Text
import com.example.decorato.presentation.theme.AppTheme
import com.example.decorato.presentation.viewModel.generate.chat.GenerateChatInteractionListener

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AttachmentBottomSheet(
    listener: GenerateChatInteractionListener
) {
    ModalBottomSheet(
        onDismissRequest = listener::onDismissAttachmentSheet,
        containerColor = AppTheme.color.onPrimary,
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        dragHandle = {
            Box(
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 6.dp)
                    .size(width = 40.dp, height = 4.dp)
                    .background(AppTheme.color.disable, RoundedCornerShape(50))
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.add_attachment),
                style = AppTheme.textStyle.body.medium,
                color = AppTheme.color.body
            )

            Spacer(modifier = Modifier.height(14.dp))

            Button(
                onClick = listener::onTakePhotographClick,
                colors = ButtonDefaults.buttonColors(containerColor = AppTheme.color.greenVariant),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.take_photograph),
                    color = AppTheme.color.primary
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = listener::onAddFromAlbumClick,
                colors = ButtonDefaults.buttonColors(containerColor = AppTheme.color.greenVariant),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.add_from_album),
                    color = AppTheme.color.primary
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}