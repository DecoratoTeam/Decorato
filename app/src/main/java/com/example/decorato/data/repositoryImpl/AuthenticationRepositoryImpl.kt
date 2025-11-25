package com.example.decorato.data.repositoryImpl

import com.example.decorato.domain.repository.AuthenticationRepository
import com.example.decorato.domain.utils.SessionType
import javax.inject.Inject

class AuthenticationRepositoryImpl @Inject constructor(

) : AuthenticationRepository {
    override suspend fun loginWithPassword(username: String, password: String) {

    }

    override suspend fun getSessionId(): String {
        return ""
    }

    override suspend fun setSessionType(sessionType: SessionType) {
    }

    override suspend fun getSessionType(): SessionType? {
        return null
    }

    override suspend fun logout() {
    }

}
