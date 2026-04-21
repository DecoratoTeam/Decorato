package com.example.decorato.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginResponseDto(
    @SerialName("Data")
    val data: LoginUserDataDto? = null,

    @SerialName("IsSuccess")
    val isSuccess: Boolean = false,

    @SerialName("Error")
    val errorCode: Int? = null,

    @SerialName("Message")
    val message: String? = null
)

@Serializable
data class LoginUserDataDto(
    @SerialName("Id")
    val id: String? = null,

    @SerialName("UserName")
    val userName: String? = null,

    @SerialName("Email")
    val email: String? = null,

    @SerialName("Token")
    val token: String? = null,

    @SerialName("ExpiresIn")
    val expiresIn: Int? = null
)