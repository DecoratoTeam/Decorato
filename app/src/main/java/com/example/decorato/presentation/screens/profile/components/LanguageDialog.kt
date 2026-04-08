//package com.example.decorato.presentation.screens.profile.components
//
//import androidx.compose.foundation.border
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.res.stringResource // لازم نضيف ده
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.window.Dialog
//import com.example.decorato.R // استدعاء ملف الـ R
//import com.example.decorato.domain.model.AppLanguage
//import com.example.decorato.presentation.theme.colors.LocalDecoratoAppColors
//import com.example.decorato.presentation.theme.textStyle.LocalDecoratoTextStyle
//
//@Composable
//fun LanguageDialog(
//    currentLanguage: AppLanguage,
//    onConfirm: (AppLanguage) -> Unit,
//    onDismiss: () -> Unit
//) {
//    val colors = LocalDecoratoAppColors.current
//    val typography = LocalDecoratoTextStyle.current
//
//    var tempLanguage by remember { mutableStateOf(currentLanguage) }
//
//    Dialog(onDismissRequest = onDismiss) {
//        Card(
//            shape = RoundedCornerShape(24.dp),
//            colors = CardDefaults.cardColors(containerColor = colors.surface)
//        ) {
//            Column(modifier = Modifier.padding(24.dp)) {
//                Text(
//                    // استخدام الـ string من الملف
//                    text = stringResource(id = R.string.selectLanguage),
//                    style = typography.title.medium,
//                    color = colors.titleL
//                )
//
//                Spacer(Modifier.height(16.dp))
//
//                AppLanguage.values().forEach { language ->
//                    LanguageOptionRow(
//                        language = language,
//                        isSelected = tempLanguage == language,
//                        onClick = { tempLanguage = language }
//                    )
//                    Spacer(Modifier.height(8.dp))
//                }
//
//                Spacer(Modifier.height(24.dp))
//
//                Button(
//                    onClick = { onConfirm(tempLanguage) },
//                    modifier = Modifier.fillMaxWidth().height(50.dp),
//                    // استخدام المسار الكامل لتجنب الـ Type Mismatch
//                    colors = androidx.compose.material3.ButtonDefaults.buttonColors(
//                        containerColor = colors.primary,
//                        contentColor = colors.onPrimary
//                    ),
//                    shape = RoundedCornerShape(12.dp)
//                ) {
//                    Text(
//                        // استخدام الـ string من الملف للزرار
//                        text = stringResource(id = R.string.confirm),
//                        style = typography.label.medium
//                    )
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun LanguageOptionRow(
//    language: AppLanguage,
//    isSelected: Boolean,
//    onClick: () -> Unit
//) {
//    val colors = LocalDecoratoAppColors.current
//    val typography = LocalDecoratoTextStyle.current
//
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .border(
//                width = 1.dp,
//                color = if (isSelected) colors.primary else colors.stroke,
//                shape = RoundedCornerShape(12.dp)
//            )
//            .clickable { onClick() }
//            .padding(16.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Text(
//            text = language.displayName,
//            style = typography.body.medium,
//            color = if (isSelected) colors.primary else colors.body,
//            modifier = Modifier.weight(1f)
//        )
//        RadioButton(
//            selected = isSelected,
//            onClick = onClick,
//            colors = RadioButtonDefaults.colors(selectedColor = colors.primary)
//        )
//    }
//}