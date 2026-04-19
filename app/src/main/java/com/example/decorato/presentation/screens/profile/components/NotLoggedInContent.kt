package com.example.decorato.presentation.screens.profile.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource // إضافة مكتبة الترجمة
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.decorato.R
import com.example.decorato.presentation.theme.colors.LocalDecoratoAppColors
import com.example.decorato.presentation.theme.textStyle.LocalDecoratoTextStyle

@Composable
fun NotLoggedInContent(
    onLoginClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = LocalDecoratoAppColors.current
    val typography = LocalDecoratoTextStyle.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // أيقونة الـ Placeholder (اتأكدي إنك سحبتيها SVG من فيجما)
        Icon(
            painter = painterResource(id = R.drawable.ic_profile_placeholder),
            contentDescription = null,
            modifier = Modifier.size(120.dp),
            tint = colors.hint
        )

        Spacer(modifier = Modifier.height(24.dp))

        // نص العنوان (مترجم)
        Text(
            text = stringResource(id = R.string.loginMsg),
            style = typography.title.medium,
            color = colors.titleL,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        // نص الوصف (مترجم)
        Text(
            text = stringResource(id = R.string.loginDesc),
            style = typography.body.small,
            color = colors.body,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(40.dp))

        // زرار الدخول (مترجم ومتظبط الألوان)
        Button(
            onClick = onLoginClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            shape = RoundedCornerShape(12.dp),
            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                containerColor = colors.primary,
                contentColor = colors.onPrimary
            )
        ) {
            Text(
                text = stringResource(id = R.string.loginBtn),
                style = typography.label.medium,
                fontWeight = FontWeight.Bold
            )
        }
    }
}