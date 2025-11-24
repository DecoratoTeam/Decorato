package com.example.decorato.presentation.viewModel.shared.errorUiState

import com.example.decorato.domain.exceptions.DecoratoException
import com.example.decorato.presentation.viewModel.shared.errorUiState.ErrorUiState.NoInternetError
import java.io.IOException

fun DecoratoException.toErrorUiState(): ErrorUiState {
    return when (this) {
        is IOException -> NoInternetError
        else -> ErrorUiState.UnknownError
    }
}

fun ErrorUiState?.isNull(): Boolean = this == null