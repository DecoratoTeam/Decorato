package com.example.decorato.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization. Serializable

@Serializable
data class RegisterResponseDto(
    @SerialName("isSuccess")
    val isSuccess: Boolean,

    @SerialName("message")
    val message: String?  = null,

    @SerialName("data")
    val data: RegisterDataDto? = null,

    @SerialName("error")
    val errorCode: Int? = null,

    @SerialName("errors")
    val errors: List<String>? = null
)

@Serializable
data class RegisterDataDto(
    @SerialName("id")
    val id: String? = null,

    @SerialName("userName")
    val userName: String? = null,

    @SerialName("email")
    val email: String? = null,

    @SerialName("token")
    val token: String? = null,

    @SerialName("refreshToken")
    val refreshToken: String? = null
)