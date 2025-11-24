package com.example.decorato.presentation.screens.onBoarding

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.decorato.R

data class OnboardingScreenData(
    @DrawableRes val imageResId: Int,
    @StringRes val titleResId: Int,
    @StringRes val descriptionResId: Int
)

object OnboardingData {
    val screens = listOf(
        OnboardingScreenData(
            imageResId = R.drawable.on_boarding1,
            titleResId = R.string.onboarding1_title,
            descriptionResId = R.string.onboarding1_description
        ),
        OnboardingScreenData(
            imageResId = R.drawable.on_boarding2,
            titleResId = R.string.onboarding2_title,
            descriptionResId = R.string.onboarding2_description
        ),
        OnboardingScreenData(
            imageResId = R.drawable.on_boarding3,
            titleResId = R.string.onboarding3_title,
            descriptionResId = R.string.onboarding3_description
        ),
    )
}