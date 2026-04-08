import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.decorato.presentation.components.Text
import com.example.decorato.presentation.theme.colors.LocalDecoratoAppColors
import com.example.decorato.presentation.theme.textStyle.LocalDecoratoTextStyle

@Composable
fun OptionRow(
    title: String,
    painter: androidx.compose.ui.graphics.painter.Painter, // بنستخدم Painter بدل ImageVector
    onClick: () -> Unit,
    iconTint: androidx.compose.ui.graphics.Color = LocalDecoratoAppColors.current.primary,
    trailingContent: @Composable (() -> Unit)? = null
) {
    val colors = LocalDecoratoAppColors.current
    val typography = LocalDecoratoTextStyle.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable { onClick() }
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painter, // تعديل هنا ليستخدم الـ painter
            contentDescription = null,
            tint = iconTint,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = title,
            style = typography.body.medium,
            color = colors.body,
            modifier = Modifier.weight(1f)
        )
        trailingContent?.invoke()
    }
}