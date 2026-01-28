package com.example.decorato.presentation.screens.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.HorizontalDivider
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
import com.example.decorato.R
import com.example.decorato.presentation.application.LocalNavManager
import com.example.decorato.presentation.components.TextField
import com.example.decorato.presentation.components.TextWithClickablePart
import com.example.decorato.presentation.components.buttons.ButtonDefaults
import com.example.decorato.presentation.components.buttons.ConfirmButton
import com.example.decorato.presentation.components.snackBar.SnackBarManager
import com.example.decorato.presentation.screens.register.component.GoogleSignInButton
import com.example.decorato.presentation.screens.register.component.getPasswordTextFieldIcon
import com.example.decorato.presentation.screens.register.component.getRegisterErrorStateMessage
import com.example.decorato.presentation.theme.AppTheme
import com.example.decorato.presentation.theme.DecoratoTheme
import com.example.decorato.presentation.utils.ThemeAndLocalePreviews
import com.example.decorato.presentation.viewModel.register.RegisterInteractionListener
import com.example.decorato.presentation.viewModel.register.RegisterEffect
import com.example.decorato.presentation.viewModel.register.RegisterUiState
import com.example.decorato.presentation.viewModel.register.RegisterViewModel

@Composable
fun RegisterScreen(
    viewModel: RegisterViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val registerErrorState by viewModel.registerErrorState.collectAsState()
    val navigationManager = LocalNavManager.current
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                RegisterEffect.NavigateToHome -> {
                    navigationManager.toHome(clearBackStack = true)
                }

                RegisterEffect.NavigateToLogin -> {
                    navigationManager.toLogin(clearBackStack = false)
                }

                RegisterEffect.RegistrationSuccess -> {
                    SnackBarManager.showSuccess(
                        context.getString(R.string.registration_success)
                    )
                }
            }
        }
    }

    // Handle field-specific errors from state
    LaunchedEffect(state. error) {
        if (state. error != null) {
            SnackBarManager.showError(state.error ?: "")
            viewModel.onRegisterErrorHandled()
        }
    }

    // Handle RegisterErrorState errors
    LaunchedEffect(registerErrorState) {
        registerErrorState?.let { errorState ->
            val errorMessage = getRegisterErrorStateMessage(errorState, context)
            SnackBarManager.showError(errorMessage)
            viewModel.onRegisterErrorHandled()
        }
    }

    RegisterScreenContent(
        state = state,
        interactionListener = viewModel
    )
}
@Composable
private fun RegisterScreenContent(
    modifier: Modifier = Modifier,
    state: RegisterUiState,
    interactionListener: RegisterInteractionListener
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
            Column {
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
                    text = stringResource(R.string.create_account),
                    style = AppTheme.textStyle.title.large,
                    color = AppTheme.color.secondary,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Name Field
                Text(
                    text = stringResource(R.string.name_label),
                    style = AppTheme.textStyle.label.medium,
                    color = AppTheme.color.body,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                TextField(
                    text = state.name,
                    onValueChange = interactionListener::onNameUpdated,
                    hintText = stringResource(R.string.name_hint),
                    leadingIcon = R.drawable.ic_person,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    isError = state.nameError != null,
                    errorMessage = state.nameError ?: ""
                )

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
                    leadingIcon = R.drawable.ic_mail,
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
                        .padding(bottom = 24.dp),
                    isError = state.passwordError != null,
                    errorMessage = state.passwordError ?: ""
                )

                // Sign Up Button
                ConfirmButton(
                    title = stringResource(R.string.sign_up),
                    onClick = interactionListener::onSignUpClicked,
                    isEnabled = state.isSignUpButtonEnabled,
                    isLoading = state.isLoading,
                    isNegative = false,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Divider with "Or Continue With"
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    HorizontalDivider(
                        modifier = Modifier.weight(1f),
                        color = AppTheme.color.hint.copy(alpha = 0.3f)
                    )
                    Text(
                        text = stringResource(R.string.or_continue_with),
                        style = AppTheme.textStyle.label.medium,
                        color = AppTheme.color.hint,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    HorizontalDivider(
                        modifier = Modifier.weight(1f),
                        color = AppTheme.color.hint.copy(alpha = 0.3f)
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Google Sign In Button
                GoogleSignInButton(
                    onClick = interactionListener::onContinueWithGoogleClicked
                )
            }

            // Already have account
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp, top = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                TextWithClickablePart(
                    nonClickableText = stringResource(R.string.already_have_account),
                    clickableText = stringResource(R.string.log_in),
                    onClick = interactionListener::onAlreadyHaveAccountClicked,
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
private fun RegisterScreenContentPreview() {
    DecoratoTheme {
        RegisterScreenContent(
            state = RegisterUiState(
                name = "Ali Hassan",
                email = "ali@gmail.com",
                password = "password123"
            ),
            interactionListener = object : RegisterInteractionListener {
                override fun onNameUpdated(name: String) {}
                override fun onEmailUpdated(email: String) {}
                override fun onPasswordUpdated(password: String) {}
                override fun onShowPasswordClicked() {}
                override fun onSignUpClicked() {}
                override fun onContinueWithGoogleClicked() {}
                override fun onAlreadyHaveAccountClicked() {}
            }
        )
    }
}

@ThemeAndLocalePreviews
@Composable
private fun RegisterScreenEmptyPreview() {
    DecoratoTheme {
        RegisterScreenContent(
            state = RegisterUiState(),
            interactionListener = object : RegisterInteractionListener {
                override fun onNameUpdated(name: String) {}
                override fun onEmailUpdated(email: String) {}
                override fun onPasswordUpdated(password: String) {}
                override fun onShowPasswordClicked() {}
                override fun onSignUpClicked() {}
                override fun onContinueWithGoogleClicked() {}
                override fun onAlreadyHaveAccountClicked() {}
            }
        )
    }
}

@ThemeAndLocalePreviews
@Composable
private fun RegisterScreenWithErrorsPreview() {
    DecoratoTheme {
        RegisterScreenContent(
            state = RegisterUiState(
                name = "",
                email = "invalid",
                password = "123",
                nameError = "Name is required",
                emailError = "Invalid email format",
                passwordError = "Password must be at least 6 characters"
            ),
            interactionListener = object : RegisterInteractionListener {
                override fun onNameUpdated(name: String) {}
                override fun onEmailUpdated(email: String) {}
                override fun onPasswordUpdated(password: String) {}
                override fun onShowPasswordClicked() {}
                override fun onSignUpClicked() {}
                override fun onContinueWithGoogleClicked() {}
                override fun onAlreadyHaveAccountClicked() {}
            }
        )
    }
}