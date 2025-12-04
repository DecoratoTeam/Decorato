package com.example.decorato.presentation.viewModel.register

import android.util.Patterns
import com.example.decorato.domain.useCase.authentication.RegisterUseCase
import com.example.decorato.presentation.viewModel.shared.BaseViewModel
import com.example.decorato.presentation.viewModel.utils. dispatcher.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow. MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow. asStateFlow
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase,
    dispatcherProvider: DispatcherProvider
) : BaseViewModel<RegisterUiState, RegisterEffect>(
    RegisterUiState(),
    dispatcherProvider
), RegisterInteractionListener {

    private val _registerErrorState = MutableStateFlow<RegisterErrorState?>(null)
    val registerErrorState: StateFlow<RegisterErrorState?> = _registerErrorState.asStateFlow()

    override fun onNameUpdated(name: String) {
        updateState {
            it.copy(
                name = name,
                nameError = null
            )
        }
        _registerErrorState.value = null
    }

    override fun onEmailUpdated(email: String) {
        updateState {
            it.copy(
                email = email,
                emailError = null
            )
        }
        _registerErrorState.value = null
    }

    override fun onPasswordUpdated(password: String) {
        updateState {
            it.copy(
                password = password,
                passwordError = null
            )
        }
        _registerErrorState.value = null
    }

    override fun onShowPasswordClicked() {
        updateState {
            it. copy(isPasswordVisible = !it.isPasswordVisible)
        }
    }

    override fun onSignUpClicked() {
        if (!validateInputs()) return

        updateState { it.copy(isLoading = true) }
        _registerErrorState.value = null

        tryToExecute(
            action = {
                registerUseCase(
                    name = state.value.name,
                    email = state.value.email,
                    password = state.value.password
                )
            },
            onSuccess = { result ->
                result.onSuccess {
                    sendNewNavigationEffect(RegisterEffect.RegistrationSuccess)
                    sendNewNavigationEffect(RegisterEffect.NavigateToHome)
                }. onFailure { error ->
                    updateState {
                        it.copy(error = error.message ?: "Registration failed")
                    }
                }
            },
            onError = { exception ->
                _registerErrorState.value = exception.toRegisterErrorUiState()
            },
            withAutoUpdateErrorState = false,
            onCompletion = {
                updateState { it.copy(isLoading = false) }
            }
        )
    }

    override fun onContinueWithGoogleClicked() {
        // TODO: Implement Google Sign In
    }

    override fun onAlreadyHaveAccountClicked() {
        sendNewNavigationEffect(RegisterEffect.NavigateToLogin)
    }

    private fun validateInputs(): Boolean {
        val currentState = state.value
        var isValid = true

        if (currentState.name.isBlank()) {
            updateState { it. copy(nameError = "Name is required") }
            isValid = false
        }

        if (currentState.email.isBlank()) {
            updateState { it.copy(emailError = "Email is required") }
            isValid = false
        } else if (! Patterns.EMAIL_ADDRESS.matcher(currentState.email).matches()) {
            updateState { it. copy(emailError = "Invalid email format") }
            isValid = false
        }

        if (currentState.password.isBlank()) {
            updateState { it.copy(passwordError = "Password is required") }
            isValid = false
        } else if (currentState.password.length < 6) {
            updateState { it.copy(passwordError = "Password must be at least 6 characters") }
            isValid = false
        }

        return isValid
    }

    fun onRegisterErrorHandled() {
        updateState { it.copy(error = null) }
        _registerErrorState.value = null
    }
}