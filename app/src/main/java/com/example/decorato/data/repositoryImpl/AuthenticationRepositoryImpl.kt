package com.example.decorato.data.repositoryImpl

import android.util.Log
import com.example.decorato.data.mapper.RegisterErrorMapper
import com.example.decorato.data.remote.api.AuthApi
import com.example.decorato.data.remote.dto.LoginRequestDto
import com.example.decorato.data.remote.dto.RegisterRequestDto
import com.example.decorato.domain.entity.User
import com.example.decorato.domain.exceptions.AccountDisabledException
import com.example.decorato.domain.exceptions.DecoratoException
import com.example.decorato.domain.exceptions.EmailAlreadyExistsException
import com.example.decorato.domain.exceptions.NoInternetException
import com.example.decorato.domain.exceptions.ServerErrorException
import com.example.decorato.domain.exceptions.UnknownException
import com.example.decorato.domain.exceptions.VerificationRequiredException
import com.example.decorato.domain.exceptions.WeakPasswordException
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
            Log.d("AuthRepo", "Response body: ${response.body()}")

            if (response.isSuccessful) {
                val body = response.body()

                if (body?.isSuccess == true) {
                    val userData = body.data

                    userData?.token?.let { token ->
                        Log.d("AuthRepo", "Token received: $token")
                        setSessionType(SessionType.USER)
                    }

                    val user = User(
                        id = userData?.id ?: "",
                        name = userData?.userName ?: "",
                        email = userData?.email ?: email,
                        fullName = "",
                        token = userData?.token,
                        refreshToken = userData?.refreshToken
                    )

                    Result.success(user)
                } else {
                    val errorMessage = when {
                        !body?.message.isNullOrEmpty() -> body?.message!!
                        !body?.errors.isNullOrEmpty() -> body?.errors?.joinToString(", ")!!
                        body?.errorCode != null -> mapErrorCodeToMessage(body.errorCode)
                        else -> "Registration failed"
                    }

                    Log.e("AuthRepo", "Registration failed: $errorMessage, errorCode: ${body?.errorCode}")

                    val exception = RegisterErrorMapper.mapToException(
                        message = errorMessage,
                        errorCode = body?.errorCode
                    )
                    Result.failure(exception)
                }
            } else {
                val errorBody = response.errorBody()?.string()
                Log.e("AuthRepo", "HTTP Error: ${response.code()}, Body: $errorBody")
                Result.failure(ServerErrorException())
            }
        } catch (e: Exception) {
            Log.e("AuthRepo", "Exception during registration", e)
            Result.failure(NoInternetException())
        }
    }

    private fun mapErrorCodeToMessage(errorCode: Int?): String {
        return when (errorCode) {
            100 -> "Email already exists"
            101 -> "Invalid email format"
            102 -> "Weak password"
            103 -> "Account disabled"
            104 -> "Verification required"
            else -> "Registration failed"
        }
    }

    private fun mapToAuthException(message: String, errorCode: Int?): DecoratoException {
        return when (errorCode) {
            100 -> EmailAlreadyExistsException()
            102 -> WeakPasswordException()
            103 -> AccountDisabledException()
            104 -> VerificationRequiredException()
            else -> {
                when {
                    message.contains("email", ignoreCase = true) &&
                            message.contains("exist", ignoreCase = true) ->
                        EmailAlreadyExistsException()

                    message.contains("email", ignoreCase = true) &&
                            message.contains("already", ignoreCase = true) ->
                        EmailAlreadyExistsException()

                    message.contains("password", ignoreCase = true) &&
                            message.contains("weak", ignoreCase = true) ->
                        WeakPasswordException()

                    message.contains("disabled", ignoreCase = true) ->
                        AccountDisabledException()

                    message.contains("verification", ignoreCase = true) ||
                            message.contains("verify", ignoreCase = true) ->
                        VerificationRequiredException()

                    else -> UnknownException()
                }
            }
        }
    }


    override suspend fun login(email: String, password: String): Result<User> {
        return try {
            val request = LoginRequestDto(email = email, password = password)
            val response = authApi.login(request)

            if (response.isSuccessful) {
                val body = response.body()
                if (body?.isSuccess == true) {
                    val userData = body.data
                    userData?.token?.let { token ->
                        setSessionType(SessionType.USER)
                    }
                    val user = User(
                        id = userData?.id ?: "",
                        name = userData?.userName ?: "",
                        email = userData?.email ?: email,
                        fullName = "",
                        token = userData?.token,
                        refreshToken = userData?.refreshToken
                    )
                    Result.success(user)
                } else {
                    Result.failure(Exception(body?.message ?: "Login failed"))
                }
            } else {
                Result.failure(Exception("HTTP Error: ${response.code()}"))
            }
        } catch (e: Exception) {
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
