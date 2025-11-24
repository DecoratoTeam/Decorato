package com.example.decorato.presentation.component.snackBar

data class SnackBarData(
    val message: String,
    val status: SnackBarStatus,
    val duration: Long = 3000L)