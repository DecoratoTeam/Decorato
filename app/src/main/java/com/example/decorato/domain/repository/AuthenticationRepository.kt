package com.example.decorato.domain.repository

import com.example.decorato.domain.entity.User
import com.example.decorato.domain.utils.SessionType


interface AuthenticationRepository {
    suspend fun loginWithPassword(username: String, password: String, )

    suspend fun register(
        name: String,
        email: String,
        password: String
    ): Result<User>

    suspend fun login(
        email: String,
        password: String
    ): Result<User>
    suspend fun getSessionId(): String
    suspend fun setSessionType(sessionType: SessionType)
    suspend fun getSessionType(): SessionType?

    suspend fun logout()
}
