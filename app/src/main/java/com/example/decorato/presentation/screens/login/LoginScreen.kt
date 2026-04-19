package com.example.decorato.presentation.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.decorato.presentation.application.LocalNavManager
import com.example.decorato.presentation.components.snackBar.SnackBarManager
import com.example.decorato.presentation.viewModel.login.LoginEffect
import com.example.decorato.presentation.viewModel.login.LoginViewModel
import com.example.decorato.R
import com.example.decorato.presentation.components.TextField
import com.example.decorato.presentation.components.TextWithClickablePart
import com.example.decorato.presentation.components.buttons.ButtonDefaults
import com.example.decorato.presentation.components.buttons.ConfirmButton
  import com.example.decorato.presentation.screens.login.component.PrimaryVariantButton
import com.example.decorato.presentation.screens.login.component.getLoginErrorStateMessage
import com.example.decorato.presentation.screens.register.component.getPasswordTextFieldIcon
import com.example.decorato.presentation.theme.AppTheme
import com.example.decorato.presentation.theme.DecoratoTheme
import com.example.decorato.presentation.viewModel.login.LoginInteractionListener
import com.example.decorato.presentation.viewModel.login.LoginUiState
import com.example.decorato.presentation.utils.ThemeAndLocalePreviews


@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val loginErrorState by viewModel.loginErrorState.collectAsState()
    val navigationManager = LocalNavManager.current
    val context = LocalContext.current

    // Handle one-time effects (navigation + success)
    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {

                LoginEffect.NavigateToHome -> navigationManager.toHome(clearBackStack = true)

                LoginEffect.NavigateToRegister -> navigationManager.toRegister()

                LoginEffect.NavigateToContinueAsGuest -> navigationManager.toHome(clearBackStack = true)

                LoginEffect.NavigateToResetPassword -> navigationManager.toResetPassword()

                LoginEffect.LoginSuccess -> {
                    SnackBarManager.showSuccess(
                        context.getString(R.string.login_success)
                    )
                }
            }
        }
    }

    // Handle simple error from state
    LaunchedEffect(state.error) {
        state.error?.let {
            SnackBarManager.showError(it)
            viewModel.onLoginErrorHandled()
        }
    }

    // Handle backend-defined error states
    LaunchedEffect(loginErrorState) {
        loginErrorState?.let { errorState ->
            val errorMessage = getLoginErrorStateMessage(errorState, context)
            SnackBarManager.showError(errorMessage)
            viewModel.onLoginErrorHandled()
        }
    }

    // Screen UI
    LoginScreenContent(
        state = state,
        interactionListener = viewModel
    )
}

@Composable
private fun LoginScreenContent(
    modifier: Modifier = Modifier,
    state: LoginUiState,
    interactionListener: LoginInteractionListener
) {

    val scrollState = rememberScrollState()

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(AppTheme.color.surface)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .statusBarsPadding()
                .navigationBarsPadding()
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
        Column{
            Spacer(modifier = Modifier.height(40.dp))

            // Logo
            Image(
                painter = painterResource(R.drawable.ic_logo),
                contentDescription = stringResource(R.string.app_name),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(140.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = stringResource(R.string.welcome_back),
                style = AppTheme.textStyle.title.large,
                color = AppTheme.color.secondary,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Email Field
            Text(
                text = stringResource(R.string.email_label),
                style = AppTheme.textStyle.label.medium,
                color = AppTheme.color.body,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            TextField(
                text = state.email,
                onValueChange = interactionListener::onEmailUpdated,
                hintText = stringResource(R.string.email_hint),
                leadingIcon = R.drawable.ic_person,
                keyboardType = KeyboardType.Email,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                isError = state.emailError != null,
                errorMessage = state.emailError ?: ""
            )

            // Password Field
            Text(
                text = stringResource(R.string.password_label),
                style = AppTheme.textStyle.label.medium,
                color = AppTheme.color.body,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            TextField(
                text = state.password,
                onValueChange = interactionListener::onPasswordUpdated,
                hintText = stringResource(R.string.password_hint),
                isTrailingClickEnabled = true,
                onTrailingClick = interactionListener::onShowPasswordClicked,
                leadingIcon = R.drawable.ic_lock,
                trailingIcon = getPasswordTextFieldIcon(state.isPasswordVisible),
                isObscured = !state.isPasswordVisible,
                keyboardType = KeyboardType.Password,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                isError = state.passwordError != null,
                errorMessage = state.passwordError ?: ""
            )

            //forget password
            Text(
                text = stringResource(R.string.forgot_password),
                style = AppTheme.textStyle.label.medium,
                color = AppTheme.color.body,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(bottom = 16.dp)
                    .clickable { interactionListener.onForgotPasswordClicked() }
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Login Button
            ConfirmButton(
                title = stringResource(R.string.login),
                onClick = interactionListener::onLoginClicked,
                isEnabled = state.isLoginButtonEnabled,
                isLoading = state.isLoading,
                isNegative = false,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            //Continue as guest

            // الجديد (الموحد)
            PrimaryVariantButton(
                title = stringResource(R.string.continue_as_guest),
                // هنا مش لازم تبعتي textColor لأنه واخد الـ Body كقيمة افتراضية (default)
                onClick = interactionListener::onContinueAsGuestClicked
            )

        }
            // Create account
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp, top = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                TextWithClickablePart(
                    nonClickableText = stringResource(R.string.dont_have_account_l),
                    clickableText = stringResource(R.string.create_account_l),
                    onClick = interactionListener::onCreateAccountClicked,
                    nonClickableTextColor = AppTheme.color.hint,
                    nonClickableTextStyle = AppTheme.textStyle.label.medium,
                    clickableTextColor = ButtonDefaults.textButtonColors().containerColor,
                    clickableTextStyle = AppTheme.textStyle.label.medium
                )
            }
        }
    }
}


@ThemeAndLocalePreviews
@PreviewScreenSizes
@Composable
private fun LoginScreenWithDataPreview() {
    DecoratoTheme {
        LoginScreenContent(
            state = LoginUiState(
                email = "ali@gmail.com",
                password = "password123"
            ),
            interactionListener = object : LoginInteractionListener {
                override fun onEmailUpdated(email: String) {}
                override fun onPasswordUpdated(password: String) {}
                override fun onShowPasswordClicked() {}
                override fun onLoginClicked() {}
                override fun onContinueAsGuestClicked() {}
                override fun onNavigateToRegisterClicked() {}
                override fun onForgotPasswordClicked() {}
                override fun onCreateAccountClicked() {}
            }
        )
    }
}

@ThemeAndLocalePreviews
@PreviewScreenSizes
@Composable
private fun LoginScreenEmptyStatePreview() {
    DecoratoTheme {
        LoginScreenContent(
            state = LoginUiState(),
            interactionListener = object : LoginInteractionListener {
                override fun onEmailUpdated(email: String) {}
                override fun onPasswordUpdated(password: String) {}
                override fun onShowPasswordClicked() {}
                override fun onLoginClicked() {}
                override fun onContinueAsGuestClicked() {}
                override fun onNavigateToRegisterClicked() {}
                override fun onForgotPasswordClicked() {}
                override fun onCreateAccountClicked() {}
            }
        )
    }
}

@ThemeAndLocalePreviews
@PreviewScreenSizes
@Composable
private fun LoginScreenWithErrorsPreview() {
    DecoratoTheme {
        LoginScreenContent(
            state = LoginUiState(
                email = "invalid",
                password = "123",
                emailError = "Invalid email format",
                passwordError = "Password must be at least 6 characters"
            ),
            interactionListener = object : LoginInteractionListener {
                override fun onEmailUpdated(email: String) {}
                override fun onPasswordUpdated(password: String) {}
                override fun onShowPasswordClicked() {}
                override fun onLoginClicked() {}
                override fun onContinueAsGuestClicked() {}
                override fun onNavigateToRegisterClicked() {}
                override fun onForgotPasswordClicked() {}
                override fun onCreateAccountClicked() {}
            }
        )
    }
}
