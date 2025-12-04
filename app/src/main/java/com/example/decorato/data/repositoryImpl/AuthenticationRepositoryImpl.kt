package com.example.decorato.data.repositoryImpl

import android.util.Log
import com.example.decorato.data.remote.api.AuthApi
import com.example.decorato.data.remote.dto.RegisterRequestDto
import com.example.decorato.domain.entity.User
import com.example.decorato.domain.repository.AuthenticationRepository
import com.example.decorato.domain.utils.SessionType
import javax.inject.Inject

class AuthenticationRepositoryImpl @Inject constructor(
    private val authApi: AuthApi
) : AuthenticationRepository {
    override suspend fun loginWithPassword(username: String, password: String) {

    }

    override suspend fun register(
        name: String,
        email: String,
        password: String
    ): Result<User> {
        return try {
            val request = RegisterRequestDto(
                name = name,
                email = email,
                password = password
            )

            Log.d("AuthRepo", "Sending register request: $request")
            val response = authApi.register(request)
            Log.d("AuthRepo", "Response code: ${response.code()}")
            Log. d("AuthRepo", "Response body: ${response.body()}")

            if (response.isSuccessful) {
                val body = response.body()

                if (body?. isSuccess == true) {
                    val userData = body.data

                    userData?.token?.let { token ->
                        Log.d("AuthRepo", "Token received: $token")
                        setSessionType(SessionType.USER)
                    }

                    val user = User(
                        id = userData?.userId ?: "",
                        name = userData?.userName ?: name,
                        email = userData?. email ?: email,
                        fullName = name,
                        token = userData?.token,
                        refreshToken = userData?. refreshToken
                    )

                    Result.success(user)
                } else {
                    val errorMessage = body?.message
                        ?: body?.errors?.joinToString(", ")
                        ?: "Registration failed"
                    Log.e("AuthRepo", "Registration failed: $errorMessage")
                    Result.failure(Exception(errorMessage))
                }
            } else {
                val errorBody = response.errorBody()?. string()
                Log.e("AuthRepo", "HTTP Error: ${response.code()}, Body: $errorBody")
                Result.failure(Exception("Registration failed: ${response.message()}"))
            }
        } catch (e: Exception) {
            Log.e("AuthRepo", "Exception during registration", e)
            Result.failure(Exception("Network error: ${e.localizedMessage}"))
        }
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
