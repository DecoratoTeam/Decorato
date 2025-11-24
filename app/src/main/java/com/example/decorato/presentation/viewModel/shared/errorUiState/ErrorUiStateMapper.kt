package com.example.decorato.presentation.viewModel.shared.errorUiState

import android.net.http.NetworkException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.decorato.domain.exceptions.DecoratoException
import com.example.decorato.presentation.viewModel.shared.errorUiState.ErrorUiState.NoInternetError

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
fun DecoratoException.toErrorUiState(): ErrorUiState {
    return when (this) {
        is NetworkException -> NoInternetError
        else -> ErrorUiState.UnknownError
    }
}

fun ErrorUiState?.isNull(): Boolean = this == null