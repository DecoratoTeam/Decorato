package com.example.decorato.presentation.screens.community.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.decorato.R
import com.example.decorato.presentation.theme.colors.LocalDecoratoAppColors

@Composable
fun ImageAttachment(
    hasSelectedImage: Boolean,
    onAddImageClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = LocalDecoratoAppColors.current

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(colors.surfaceHigh)
            .clickable { onAddImageClick() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        // أيقونة الجاليري (لو عندك فيكتور ملون سيبيه Unspecified)
        Image(
            painter = painterResource(id = R.drawable.ic_gallery_add),
            contentDescription = "Add Image",
            modifier = Modifier.size(24.dp),
            contentScale = ContentScale.Fit //
        )

        Spacer(modifier = Modifier.width(8.dp)) // Gap 8px

        Text(
            text = if (hasSelectedImage)
                stringResource(R.string.add_more) // حالة "Add more"
            else
                stringResource(R.string.image), // حالة "Image"
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                fontWeight = FontWeight.W500,
                fontSize = 16.sp,
                color = colors.titleL.copy(alpha = 0.87f)
            )
        )
    }
}