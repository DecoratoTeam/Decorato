package com.example.decorato.data.repositoryImpl

import com.example.decorato.data.repositoryImpl.security.CryptoManager
import com.example.decorato.domain.repository.AuthenticationRepository
import com.example.decorato.domain.utils.SessionType
import javax.inject.Inject

class AuthenticationRepositoryImpl @Inject constructor(
    val cryptoManager: CryptoManager,
) : AuthenticationRepository {
    override suspend fun loginWithPassword(username: String, password: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getSessionId(): String {
        TODO("Not yet implemented")
    }

    override suspend fun setSessionType(sessionType: SessionType) {
        TODO("Not yet implemented")
    }

    override suspend fun getSessionType(): SessionType? {
        TODO("Not yet implemented")
    }

    override suspend fun logout() {
        TODO("Not yet implemented")
    }

}
