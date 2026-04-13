package com.example.decorato.presentation.screens.profile.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.decorato.R
import com.example.decorato.domain.model.AppLanguage
import com.example.decorato.presentation.theme.colors.LocalDecoratoAppColors
import com.example.decorato.presentation.theme.textStyle.LocalDecoratoTextStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LanguageBottomSheet(
    selectedLanguage: AppLanguage,
    onLanguageSelected: (AppLanguage) -> Unit,
    onDismiss: () -> Unit
) {
    val colors = LocalDecoratoAppColors.current

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        containerColor = Color.Transparent,
        dragHandle = null,
        scrimColor = Color.Black.copy(alpha = 0.32f)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, bottom = 12.dp),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = colors.surfaceHigh)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, start = 16.dp, end = 16.dp, bottom = 24.dp)
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .width(40.dp)
                        .height(4.dp)
                        .background(colors.hint.copy(alpha = 0.2f), CircleShape)
                )

                Row(
                    modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Spacer(modifier = Modifier.size(24.dp))
                    Text(
                        text = stringResource(R.string.change_language),
                        style = LocalDecoratoTextStyle.current.title.medium,
                        color = colors.titleL
                    )
                    IconButton(onClick = onDismiss) {
                        Icon(Icons.Default.Close, contentDescription = null, tint = colors.body)
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // مناداة الـ LanguageCard للأنجليزية
                    LanguageCard(
                        title = stringResource(R.string.english),
                        flagIcon = R.drawable.ic_flag_uk,
                        isSelected = selectedLanguage == AppLanguage.ENGLISH,
                        modifier = Modifier.weight(1f),
                        onClick = { onLanguageSelected(AppLanguage.ENGLISH) }
                    )
                    // مناداة الـ LanguageCard للعربية
                    LanguageCard(
                        title = stringResource(R.string.arabic),
                        flagIcon = R.drawable.ic_flag_arabic,
                        isSelected = selectedLanguage == AppLanguage.ARABIC,
                        modifier = Modifier.weight(1f),
                        onClick = { onLanguageSelected(AppLanguage.ARABIC) }
                    )
                }
            }
        }
    }
}

// الزيتونة: الدالة دي لازم تكون موجودة هنا عشان الـ Unresolved Reference يختفي
@Composable
fun LanguageCard(
    title: String,
    flagIcon: Int,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val colors = LocalDecoratoAppColors.current
    val borderColor = if (isSelected) colors.primary else colors.stroke.copy(alpha = 0.08f)
    val bgColor = if (isSelected) colors.primaryVariant else colors.surface

    Card(
        modifier = modifier
            .height(87.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, borderColor),
        colors = CardDefaults.cardColors(containerColor = bgColor)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Image(
                painter = painterResource(id = flagIcon),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 26.dp, height = 20.dp)
                    .clip(RoundedCornerShape(3.dp)),
                contentScale = ContentScale.FillBounds
            )
            Text(
                text = title,
                style = LocalDecoratoTextStyle.current.body.small.copy(
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                ),
                color = colors.titleL
            )
        }
    }
}