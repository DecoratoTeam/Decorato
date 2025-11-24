package com.example.decorato.presentation

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DecoratoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}