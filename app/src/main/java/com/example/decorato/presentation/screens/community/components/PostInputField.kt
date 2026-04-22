package com.example.decorato.presentation.screens.community.components

import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.decorato.R
import com.example.decorato.presentation.theme.colors.LocalDecoratoAppColors

@Composable
fun PostInputField(
    text: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = LocalDecoratoAppColors.current

    // الزتونة: BasicTextField هي اللي بتسمح بالتحكم الكامل في الـ Padding
    BasicTextField(
        value = text,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        textStyle = TextStyle(
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            fontSize = 18.sp,
            color = colors.titleL
        ),
        cursorBrush = SolidColor(colors.primary), // لون الكرسر المينت
        decorationBox = { innerTextField ->
            Box(modifier = Modifier.fillMaxWidth()) {
                if (text.isEmpty()) {
                    Text(
                        text = stringResource(R.string.what_are_you_thinking),
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontSize = 18.sp,
                            color = colors.hint
                        )
                    )
                }
                innerTextField() // ده النص اللي اليوزر بيكتبه
            }
        }
    )
}