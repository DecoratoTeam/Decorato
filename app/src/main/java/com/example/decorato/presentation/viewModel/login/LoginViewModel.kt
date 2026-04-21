package com.example.decorato.presentation.viewModel.login

import android.util.Patterns
import com.example.decorato.domain.useCase.authentication.LoginUseCase
import com.example.decorato.presentation.viewModel.shared.BaseViewModel
import com.example.decorato.presentation.viewModel.utils.dispatcher.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    dispatcherProvider: DispatcherProvider
) : BaseViewModel<LoginUiState, LoginEffect>(
    LoginUiState(),
    dispatcherProvider
), LoginInteractionListener {

    private val _loginErrorState = MutableStateFlow<LoginErrorState?>(null)
    val loginErrorState = _loginErrorState.asStateFlow()

    override fun onEmailUpdated(email: String) {
        updateState { it.copy(email = email, emailError = null) }
        _loginErrorState.value = null
    }

    override fun onPasswordUpdated(password: String) {
        updateState { it.copy(password = password, passwordError = null) }
        _loginErrorState.value = null
    }

    override fun onShowPasswordClicked() {
        updateState { it.copy(isPasswordVisible = !it.isPasswordVisible) }
    }

    override fun onLoginClicked() {
        if (!validateInputs()) return
        updateState { it.copy(isLoading = true) }

        tryToExecute(
            action = {
                loginUseCase(
                    email = state.value.email,
                    password = state.value.password
                )
            },
            onSuccess = { result ->
                result.onSuccess {
                    sendNewNavigationEffect(LoginEffect.NavigateToHome)
                }.onFailure { err ->
                    updateState { it.copy(error = err.message) }
                }
            },
            onError = { exception ->
                _loginErrorState.value = exception.toLoginErrorUiState()
            },
            withAutoUpdateErrorState = false,
            onCompletion = {
                updateState { it.copy(isLoading = false) }
            }
        )
    }

    override fun onCreateAccountClicked() {
        sendNewNavigationEffect(LoginEffect.NavigateToRegister)
    }


    override fun onForgotPasswordClicked() {
        sendNewNavigationEffect(LoginEffect.NavigateToResetPassword)
    }


    override fun onContinueAsGuestClicked() {
        sendNewNavigationEffect(LoginEffect.NavigateToHome)
    }

    override fun onNavigateToRegisterClicked() {
        sendNewNavigationEffect(LoginEffect.NavigateToRegister)
    }

    fun onLoginErrorHandled() {
        updateState { it.copy(error = null) }
        _loginErrorState.value = null
    }

    private fun validateInputs(): Boolean {
        val st = state.value
        var valid = true

        if (st.email.isBlank()) {
            updateState { it.copy(emailError = "Email required") }
            valid = false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(st.email).matches()) {
            updateState { it.copy(emailError = "Invalid email format") }
            valid = false
        }

        if (st.password.isBlank()) {
            updateState { it.copy(passwordError = "Password required") }
            valid = false
        }

        return valid
    }
}
