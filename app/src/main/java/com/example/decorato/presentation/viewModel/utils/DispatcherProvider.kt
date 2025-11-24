package com.example.decorato.presentation.viewModel.utils

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {
    val Main: CoroutineDispatcher
    val MainImmediate: CoroutineDispatcher
    val Default: CoroutineDispatcher
    val IO: CoroutineDispatcher
}