package com.example.decorato.data.remote.api

import com.example.decorato.data.remote.dto.LoginRequestDto
import com.example.decorato.data.remote.dto.LoginResponseDto
import com.example.decorato.data.remote.dto.RegisterRequestDto
import com.example.decorato.data.remote.dto.RegisterResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("Auth")
    suspend fun login(
        @Body request: LoginRequestDto
    ): Response<LoginResponseDto>


    @POST("Auth/Register")
    suspend fun register(
        @Body request: RegisterRequestDto
    ): Response<RegisterResponseDto>
}