package com.example.decorato.presentation.viewModel.generate.chat

interface GenerateChatInteractionListener {
    fun onMessageChanged(value: String)
    fun onSendClick()
    fun onMicClick()
    fun onDismissAttachmentSheet()
    fun onTakePhotographClick()
    fun onRemoveAttachmentClick()
    fun onAddFromAlbumClick()
    fun onBackClick()
}