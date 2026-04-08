package com.example.decorato.presentation.screens.profile.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.decorato.R
import com.example.decorato.presentation.components.TextField
import com.example.decorato.presentation.components.buttons.ConfirmButton
import com.example.decorato.presentation.screens.register.component.getPasswordTextFieldIcon
import com.example.decorato.presentation.theme.AppTheme
import com.example.decorato.presentation.viewModel.profile.InteractionListener.EditProfileInteractionListener
import com.example.decorato.presentation.viewModel.profile.UiState.EditProfileUiState

@Composable
fun EditProfileFields(
    state: EditProfileUiState,
    interactionListener: EditProfileInteractionListener
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 24.dp)
    ) {
        // --- Name Field ---
        Text(
            text = stringResource(R.string.name_label),
            style = AppTheme.textStyle.label.medium,
            color = AppTheme.color.body,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        TextField(
            text = state.userName,
            onValueChange = interactionListener::onNameChange,
            hintText = stringResource(R.string.name_hint),
            leadingIcon = R.drawable.ic_person,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            isError = false, // لغينا المتغير اللي عامل مشكلة
            errorMessage = ""
        )

        // --- Email Field ---
        Text(
            text = stringResource(R.string.email_label),
            style = AppTheme.textStyle.label.medium,
            color = AppTheme.color.body,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        TextField(
            text = state.email,
            onValueChange = interactionListener::onEmailChange,
            hintText = stringResource(R.string.email_hint),
            leadingIcon = R.drawable.ic_mail,
            keyboardType = KeyboardType.Email,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            isError = false,
            errorMessage = ""
        )

        // --- Password Field ---
        Text(
            text = stringResource(R.string.password_label),
            style = AppTheme.textStyle.label.medium,
            color = AppTheme.color.body,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        TextField(
            text = state.password,
            onValueChange = interactionListener::onPasswordChange,
            hintText = "********",
            isTrailingClickEnabled = true,
            onTrailingClick = interactionListener::onPasswordVisibilityClick,
            leadingIcon = R.drawable.ic_lock,
            trailingIcon = getPasswordTextFieldIcon(state.isPasswordVisible),
            isObscured = !state.isPasswordVisible,
            keyboardType = KeyboardType.Password,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 40.dp),
            isError = false,
            errorMessage = ""
        )

        // --- Save Button ---
        ConfirmButton(
            title = "Save",
            onClick = interactionListener::onSaveClick,
            isEnabled = true, // خليناها true عشان يشتغل فوراً
            isLoading = state.isLoading,
            isNegative = false,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))
    }
}