package com.example.decorato.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.decorato.R
import com.example.decorato.presentation.theme.AppTheme

@Composable
fun SectionTitle(
    title: String,
    modifier: Modifier = Modifier,
    icon: Painter? = null,
    tintColor: Color = Color(0xFF00CDB8),
    contentDescription: String? = null,
    showAllLabel: Boolean = false,
    onAllLabelClicked: () -> Unit = {},
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(0.90f),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = title,
                color = Color(0xFF1A1A1A),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            icon?.let {
                Icon(
                    painter = icon,
                    tint = tintColor,
                    contentDescription = contentDescription,
                    modifier = Modifier.size(20.dp),
                )
            }
        }

        if (showAllLabel) {
            Text(
                text = stringResource(R.string.show_all),
                color = AppTheme.color.primary,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.clickable(
                    onClick = onAllLabelClicked,
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                ),
            )
        }
    }
}