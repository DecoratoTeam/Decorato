package com.example.decorato.domain.repository

import com.example.decorato.domain.utils.SessionType


interface AuthenticationRepository {
    suspend fun loginWithPassword(username: String, password: String, )

    suspend fun getSessionId(): String
    suspend fun setSessionType(sessionType: SessionType)
    suspend fun getSessionType(): SessionType?

    suspend fun logout()
}
