package com.example.decorato.presentation.viewModel.profile.InteractionListener

interface EditProfileInteractionListener {
    fun onNameChange(newName: String)
    fun onEmailChange(newEmail: String)
    fun onPasswordChange(newPassword: String)
    fun onSaveClick()
    fun onBackClick()
    fun onUpdateImageClick()
    fun onPasswordVisibilityClick() // ضيفي السطر ده
}