package com.example.decorato.presentation.components.snackBar

import androidx.annotation.DrawableRes
import com.example.decorato.R
import com.example.decorato.presentation.theme.AppTheme
import com.example.decorato.presentation.theme.ColorType

enum class SnackBarStatus(
    @DrawableRes val icon: Int,
    val iconTintColor: ColorType,
    val dropShadowColor: ColorType,
) {
    Success(
        R.drawable.ic_thumbs_up,
        iconTintColor = { AppTheme.color.greenAccent },
        dropShadowColor = { AppTheme.color.successSnackBarShadow },
    ),
    Failure(
        R.drawable.ic_thumbs_down,
        iconTintColor = { AppTheme.color.redAccent },
        dropShadowColor = { AppTheme.color.failureSnackBarShadow },
    ),
}
