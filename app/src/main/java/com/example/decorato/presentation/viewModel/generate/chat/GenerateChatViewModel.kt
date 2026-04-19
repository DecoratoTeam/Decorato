package com.example.decorato.presentation.viewModel.generate.chat

import androidx.lifecycle.viewModelScope
import com.example.decorato.presentation.viewModel.shared.BaseViewModel
import com.example.decorato.presentation.viewModel.utils.dispatcher.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GenerateChatViewModel @Inject constructor(
    dispatcherProvider: DispatcherProvider
) : BaseViewModel<GenerateChatUiState, GenerateChatEffect>(
    initialState = GenerateChatUiState(),
    dispatcherProvider = dispatcherProvider
), GenerateChatInteractionListener {

    override fun onMessageChanged(value: String) {
        updateState { it.copy(message = value) }
    }

    override fun onSendClick() {
        val prompt = state.value.message.trim()
        val attachmentUri = state.value.selectedAttachmentUri
        val attachmentName = state.value.selectedAttachmentName ?: "Image.jpeg"

        if ((prompt.isBlank() && attachmentUri == null) || state.value.isSending) return

        val outMessages = mutableListOf<GenerateChatMessageUiState>()

        if (attachmentUri != null) {
            outMessages += GenerateChatMessageUiState(
                id = System.currentTimeMillis(),
                type = GenerateChatMessageType.USER_IMAGE,
                localImageUri = attachmentUri,
                fileName = attachmentName
            )
        }

        if (prompt.isNotBlank()) {
            outMessages += GenerateChatMessageUiState(
                id = System.currentTimeMillis() + 1,
                type = GenerateChatMessageType.USER_TEXT,
                text = prompt
            )
        }

        updateState {
            it.copy(
                message = "",
                selectedAttachmentName = null,
                selectedAttachmentUri = null,
                isSending = true,
                messages = it.messages + outMessages
            )
        }

        viewModelScope.launch {
            delay(700)

            val finalPrompt = if (prompt.isBlank()) "your image" else prompt

            val botText = GenerateChatMessageUiState(
                id = System.currentTimeMillis() + 2,
                type = GenerateChatMessageType.BOT_TEXT,
                text = buildReply(finalPrompt)
            )

            val botImage = GenerateChatMessageUiState(
                id = System.currentTimeMillis() + 3,
                type = GenerateChatMessageType.BOT_IMAGE,
                imageUrl = pickLocalImage(finalPrompt)
            )

            updateState {
                it.copy(
                    isSending = false,
                    messages = it.messages + botText + botImage
                )
            }
        }
    }

    override fun onAttachmentClick() {
        updateState { it.copy(showAttachmentSheet = true) }
    }

    override fun onDismissAttachmentSheet() {
        updateState { it.copy(showAttachmentSheet = false) }
    }

    override fun onTakePhotographClick() {
        updateState { it.copy(showAttachmentSheet = false) }
        sendNewEffect(GenerateChatEffect.OpenCamera)
    }

    override fun onAddFromAlbumClick() {
        updateState { it.copy(showAttachmentSheet = false) }
        sendNewEffect(GenerateChatEffect.OpenGallery) // ✅ جديد
    }

    override fun onRemoveAttachmentClick() {
        updateState { it.copy(selectedAttachmentName = null, selectedAttachmentUri = null) }
    }

    fun onCameraImageCaptured(uri: String) {
        updateState {
            it.copy(
                selectedAttachmentName = "Image.jpeg",
                selectedAttachmentUri = uri
            )
        }
    }

    fun onGalleryImagePicked(uri: String) {
        updateState {
            it.copy(
                selectedAttachmentName = "Image.jpeg",
                selectedAttachmentUri = uri
            )
        }
    }

    override fun onBackClick() {
        sendNewEffect(GenerateChatEffect.NavigateBack)
    }

    private fun buildReply(prompt: String): String {
        return "Hello! I understand your request perfectly. I will generate a design for \"$prompt\" with suitable colors and style. Generating..."
    }

    private fun pickLocalImage(prompt: String): String {
        val p = prompt.lowercase()

        val bedroomImages = listOf(
            "https://plus.unsplash.com/premium_photo-1661963239507-7bdf41a5e66b?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8SW50ZXJpb3IlMjBEZXNpZ24lMjBCZWRyb29tfGVufDB8fDB8fHww",
            "https://plus.unsplash.com/premium_photo-1661877303180-19a028c21048?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8TW9kZXJuJTIwTWFzdGVyJTIwQmVkcm9vbXxlbnwwfHwwfHx8MA%3D%3D",
            "https://media.istockphoto.com/id/2219306327/photo/urban-loft-bedroom-with-exposed-brick-and-concrete-walls.jpg?s=1024x1024&w=is&k=20&c=Q8T4kIMFZ2yhXgmL7PH0graG8-FxCnbc_cf_wBtLzmU=",
            "https://images.unsplash.com/photo-1765862835193-3c37388a409e?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8TWluaW1hbGlzdCUyMFplbiUyMEJlZHJvb218ZW58MHx8MHx8fDA%3D",
            "https://images.unsplash.com/photo-1583845112203-29329902332e?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OHx8Qm9oZW1pYW4lMjBEcmVhbSUyMEJlZHJvb218ZW58MHx8MHx8fDA%3D",
            "https://images.unsplash.com/photo-1610307522657-8c0304960189?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8U2NhbmRpbmF2aWFuJTIwQmVkcm9vbXxlbnwwfHwwfHx8MA%3D%3D",
            "https://images.unsplash.com/photo-1616594039964-3d5d6e9f6f8f?auto=format&fit=crop&w=900&q=80",
            "https://images.unsplash.com/photo-1616627561839-074385245ff6?auto=format&fit=crop&w=900&q=80",
            "https://images.unsplash.com/photo-1616047006789-b7af7fddf4e4?auto=format&fit=crop&w=900&q=80",
            "https://images.unsplash.com/photo-1505693416388-ac5ce068fe85?auto=format&fit=crop&w=900&q=80",
            "https://images.unsplash.com/photo-1617104551722-3b2d51366400?auto=format&fit=crop&w=900&q=80"
        )

        val kitchenImages = listOf(
            "https://images.unsplash.com/photo-1502005097973-6a7082348e28?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTd8fEludGVyaW9yJTIwRGVzaWdufGVufDB8fDB8fHww",
            "https://images.unsplash.com/photo-1669046222569-a7672da06e12?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8QnJpZ2h0JTIwTWluaW1hbGlzdCUyMEtpdGNoZW58ZW58MHx8MHx8fDA%3D",
            "https://media.istockphoto.com/id/1337181547/photo/vaulted-ceiling-in-modern-kitchen.webp?a=1&b=1&s=612x612&w=0&k=20&c=r0oKCgHxKUg3PPkPHtQMPiNVMxCST6P8jgDtQmFQefI=",
            "https://plus.unsplash.com/premium_photo-1661779601614-9206e0451077?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8TW9kZXJuJTIwS2l0Y2hlbiUyMERlc2lnbnxlbnwwfHwwfHx8MA%3D%3D",
            "https://images.unsplash.com/photo-1589109807644-924edf14ee09?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8SW5kdXN0cmlhbCUyMEtpdGNoZW58ZW58MHx8MHx8fDA%3D",
            "https://images.unsplash.com/photo-1658280911730-467b4764c09c?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTV8fEx1eHVyeSUyMENoZWYncyUyMEtpdGNoZW58ZW58MHx8MHx8fDA%3D",
            "https://images.unsplash.com/photo-1556911220-bff31c812dba?auto=format&fit=crop&w=900&q=80",
            "https://images.unsplash.com/photo-1556909212-d5b604d0c90d?auto=format&fit=crop&w=900&q=80",
            "https://images.unsplash.com/photo-1600489000022-c2086d79f9d4?auto=format&fit=crop&w=900&q=80",
            "https://images.unsplash.com/photo-1565538810643-b5bdb714032a?auto=format&fit=crop&w=900&q=80",
            "https://images.unsplash.com/photo-1600573472550-8090b5e0745e?auto=format&fit=crop&w=900&q=80"
        )

        val livingImages = listOf(
            "https://plus.unsplash.com/premium_photo-1664300969611-f3745a737234?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1yZWxhdGVkfDV8fHxlbnwwfHx8fHw%3D",
            "https://images.unsplash.com/photo-1757439402190-99b73ac8e807?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8TWVkaXRlcnJhbmVhbiUyMExpdmluZyUyMFNwYWNlfGVufDB8fDB8fHww",
            "https://plus.unsplash.com/premium_photo-1733320822557-e4ccfb5f20d1?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8THV4dXJ5JTIwUGVudGhvdXNlJTIwTGl2aW5nfGVufDB8fDB8fHww",
            "https://images.unsplash.com/photo-1764010533326-c6916f3d6252?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8QXJ0aXN0aWMlMjBMaXZpbmclMjBHYWxsZXJ5fGVufDB8fDB8fHww",
            "https://images.unsplash.com/photo-1493857671505-72967e2e2760?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8Q29hc3RhbCUyMExpdmluZXxlbnwwfHwwfHx8MA%3D%3D",
            "https://plus.unsplash.com/premium_photo-1744839107780-2eefa443f4a8?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8Q29udGVtcG9yYXJ5JTIwTGl2aW5nJTIwU3BhY2V8ZW58MHx8MHx8fDA%3D",
            "https://plus.unsplash.com/premium_photo-1723901830004-3012de1ed13d?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8U2NhbmRpbmF2aWFuJTIwTGl2aW5nJTIwUm9vbXxlbnwwfHwwfHx8MA%3D%3D",
            "https://plus.unsplash.com/premium_photo-1661963118331-26a530ed4637?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8SW5kdXN0cmlhbCUyME1vZGVybiUyMExpdmluZ3xlbnwwfHwwfHx8MA%3D%3D",
            "https://images.unsplash.com/photo-1593696140826-c58b021acf8b?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTV8fE1pbmltYWxpc3QlMjBMaXZpbmclMjBSb29tfGVufDB8fDB8fHww",
            "https://media.istockphoto.com/id/2161509009/photo/warm-and-inviting-bohemian-living-room-interior-design.webp?a=1&b=1&s=612x612&w=0&k=20&c=Cp6a9zyOIknuTIrzfWyTgSPjO80xwgN_4LYUZ-2tPJ8=",
            "https://images.unsplash.com/photo-1761662826410-3218852da3bf?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8UnVzdGljJTIwQ296eSUyMExpdmluZ3xlbnwwfHwwfHx8MA%3D%3D",
            "https://plus.unsplash.com/premium_photo-1661879463320-27174a27d668?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8RWNsZWN0aWMlMjBMaXZpbmclMjBSb29tfGVufDB8fDB8fHww",
            "https://images.unsplash.com/photo-1616486029423-aaa4789e8c9a?auto=format&fit=crop&w=900&q=80",
            "https://images.unsplash.com/photo-1618220179428-22790b461013?auto=format&fit=crop&w=900&q=80",
            "https://images.unsplash.com/photo-1615874959474-d609969a20ed?auto=format&fit=crop&w=900&q=80",
            "https://images.unsplash.com/photo-1616047006789-b7af7fddf4e4?auto=format&fit=crop&w=900&q=80",
            "https://images.unsplash.com/photo-1600210492493-0946911123ea?auto=format&fit=crop&w=900&q=80",
        )

        val bathroomImages = listOf(
            "https://plus.unsplash.com/premium_photo-1661963215502-dc2bc471ab2a?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8THV4dXJpb3VzJTIwQmF0aHJvb218ZW58MHx8MHx8fDA%3D",
            "https://media.istockphoto.com/id/2216890622/photo/modern-boho-bathroom-with-soft-lighting.webp?a=1&b=1&s=612x612&w=0&k=20&c=uwVVl1cvbADZ3f1YAuSP0gK9Jxfa_eMGAN3F2xu9pfo=",
            "https://images.unsplash.com/photo-1771239048293-72abf673adb2?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8TW9kZXJuJTIwU3BhJTIwQmF0aHJvb218ZW58MHx8MHx8fDA%3D",
            "https://plus.unsplash.com/premium_photo-1721274105657-0751a5f42eb8?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8TWluaW1hbGlzdCUyMEJhdGhyb29tfGVufDB8fDB8fHww",
            "https://media.istockphoto.com/id/1082345206/photo/interior-design-of-a-bathroom-3d-illustration-in-a-scandinavian-style.webp?a=1&b=1&s=612x612&w=0&k=20&c=lPz1Lit04QuScHSyL3zm__epywU61pbzpbhfZsOvxpY=",
            "https://media.istockphoto.com/id/1152076563/photo/luxurious-bathroom.webp?a=1&b=1&s=612x612&w=0&k=20&c=NtM5hqCYBbauVKT8did24VG27fsrTKkmku8wh5EsA2o=",
            "https://images.unsplash.com/photo-1604709177225-055f99402ea3?auto=format&fit=crop&w=900&q=80",
            "https://images.unsplash.com/photo-1584622781564-1d987f7333c1?auto=format&fit=crop&w=900&q=80",
            "https://images.unsplash.com/photo-1620626011761-996317b8d101?auto=format&fit=crop&w=900&q=80",
            "https://images.unsplash.com/photo-1564540583246-934409427776?auto=format&fit=crop&w=900&q=80",
            "https://images.unsplash.com/photo-1576698483491-8c43f0862543?auto=format&fit=crop&w=900&q=80"
        )

        val diningRoomImages = listOf(
            "https://images.unsplash.com/photo-1723750290151-164cb19ebab7?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8U2NhbmRpbmF2aWFuJTIwRGluaW5nJTIwUm9vbXxlbnwwfHwwfHx8MA%3D%3D",
            "https://images.unsplash.com/photo-1760431194370-48fe900d09f7?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8TW9kZXJuJTIwRGluaW5nJTIwU3BhY2V8ZW58MHx8MHx8fDA%3D",
            "https://plus.unsplash.com/premium_photo-1661962461938-b3a74097d946?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8THV4dXJ5JTIwRGluaW5nJTIwUm9vbXxlbnwwfHwwfHx8MA%3D%3D",
            "https://plus.unsplash.com/premium_photo-1661962305366-0c62646fd249?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTd8fEluZHVzdHJpYWwlMjBEaW5pbmd8ZW58MHx8MHx8fDA%3D",
            "https://media.istockphoto.com/id/2213976761/photo/compact-black-kitchen-and-dining-area-in-scandinavian-log-cabin-with-sea-view.webp?a=1&b=1&s=612x612&w=0&k=20&c=kkTZnWqyAJ_n0Rw8x4GWwj8duGh2FFKGbPOJHlMiT20=",
            "https://images.unsplash.com/photo-1771371639198-6c044fed1941?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8Q29udGVtcG9yYXJ5JTIwRGluaW5nJTIwU3BhY2V8ZW58MHx8MHx8fDA%3D",
            "https://images.unsplash.com/photo-1617806118233-18e1de247200?auto=format&fit=crop&w=900&q=80",
            "https://images.unsplash.com/photo-1617098474202-0d0d7f60f9c2?auto=format&fit=crop&w=900&q=80",
            "https://images.unsplash.com/photo-1616137466211-f939a420be84?auto=format&fit=crop&w=900&q=80",
            "https://images.unsplash.com/photo-1618220179428-22790b461013?auto=format&fit=crop&w=900&q=80",
            "https://images.unsplash.com/photo-1615873968403-89e068629265?auto=format&fit=crop&w=900&q=80"
        )

        val nurseryImages = listOf(
            "https://images.unsplash.com/photo-1588854337127-a7cdcabfd7ac?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8TnVyc2VyeXxlbnwwfHwwfHx8MA%3D%3D",
            "https://media.istockphoto.com/id/1938954118/photo/modern-baby-room-interior-with-messy-crib-cabinet-armchair-toys-and-plants.webp?a=1&b=1&s=612x612&w=0&k=20&c=9aBy6rW4r8eRYvonDnmMmYQn3k_aokHTHq08o6fbSjc=",
            "https://plus.unsplash.com/premium_photo-1684779979840-0285cb45ea71?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTN8fE1pbmltYWxpc3QlMjBOdXJzZXJ5fGVufDB8fDB8fHww",
            "https://media.istockphoto.com/id/940134520/photo/pastel-kids-playroom-interior.webp?a=1&b=1&s=612x612&w=0&k=20&c=qSNn_9fzSif5W2F5DAcQoRQTnoRJyokMOreF-HbD3Us=",
            "https://media.istockphoto.com/id/1345191888/photo/cute-baby-room-interior-with-crib-and-big-window.webp?a=1&b=1&s=612x612&w=0&k=20&c=ECIWD3kepDvHXvimS62eyhRW-K9PXSD1Q_GZ4YLLoss=",
            "https://media.istockphoto.com/id/1174243995/photo/this-room-will-be-filled-with-laughter-and-cries-soon.webp?a=1&b=1&s=612x612&w=0&k=20&c=ZxX60iOK9jsZsL_zdMCfgMoITkfRCPTnLMdbg9ullmc=",
            "https://images.unsplash.com/photo-1513694203232-719a280e022f?auto=format&fit=crop&w=900&q=80",
            "https://images.unsplash.com/photo-1505691938895-1758d7feb511?auto=format&fit=crop&w=900&q=80",
            "https://images.unsplash.com/photo-1596464716127-f2a82984de30?auto=format&fit=crop&w=900&q=80",
            "https://images.unsplash.com/photo-1565538420870-da08ff96a207?auto=format&fit=crop&w=900&q=80",
            "https://images.unsplash.com/photo-1616627452094-9f9f4b6f6d3d?auto=format&fit=crop&w=900&q=80"
        )

        val officeImages = listOf(
            "https://plus.unsplash.com/premium_photo-1664304082823-035775a3c141?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8SW5kdXN0cmlhbCUyME9mZmljZSUyMFNwYWNlfGVufDB8fDB8fHww",
            "https://plus.unsplash.com/premium_photo-1676823552727-89722eb5f72e?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8Q29udGVtcG9yYXJ5JTIwSG9tZSUyME9mZmljZXxlbnwwfHwwfHx8MA%3D%3D",
            "https://images.unsplash.com/photo-1718220216044-006f43e3a9b1?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8N3x8TWluaW1hbGlzdCUyME9mZmljZXxlbnwwfHwwfHx8MA%3D%3D",
            "https://images.unsplash.com/photo-1693159682618-074078ed271e?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8Q3JlYXRpdmUlMjBXb3Jrc3BhY2V8ZW58MHx8MHx8fDA%3D",
            "https://images.unsplash.com/photo-1558959356-2f36c7322d3b?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTF8fE1vZGVybiUyMFN0YXJ0dXAlMjBPZmZpY2V8ZW58MHx8MHx8fDA%3D",
            "https://images.unsplash.com/photo-1623916799434-114e844becc2?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8UHJvZHVjdGl2ZSUyMEhvbWUlMjBEZXNrfGVufDB8fDB8fHww",
            "https://images.unsplash.com/photo-1497366811353-6870744d04b2?auto=format&fit=crop&w=900&q=80",
            "https://images.unsplash.com/photo-1497215842964-222b430dc094?auto=format&fit=crop&w=900&q=80",
            "https://images.unsplash.com/photo-1497366754035-f200968a6e72?auto=format&fit=crop&w=900&q=80",
            "https://images.unsplash.com/photo-1593476550610-87baa860004a?auto=format&fit=crop&w=900&q=80",
            "https://images.unsplash.com/photo-1604328698692-f76ea9498e76?auto=format&fit=crop&w=900&q=80"
        )

        val defaultImages = listOf(
            "https://images.unsplash.com/photo-1616046229478-9901c5536a45?auto=format&fit=crop&w=900&q=80",
            "https://images.unsplash.com/photo-1617104551722-3b2d51366400?auto=format&fit=crop&w=900&q=80",
            "https://images.unsplash.com/photo-1618220179428-22790b461013?auto=format&fit=crop&w=900&q=80",
            "https://images.unsplash.com/photo-1600210492493-0946911123ea?auto=format&fit=crop&w=900&q=80",
            "https://images.unsplash.com/photo-1616593969747-4797dc75033e?auto=format&fit=crop&w=900&q=80"
        )

        val selectedList = when {
            listOf("bedroom", "bed room", "sleep").any { it in p } -> bedroomImages
            listOf("kitchen", "cooking").any { it in p } -> kitchenImages
            listOf("living", "living room", "hall").any { it in p } -> livingImages
            listOf("bathroom", "bath room", "toilet", "washroom").any { it in p } -> bathroomImages
            listOf("dining", "dining room", "diningroom").any { it in p } -> diningRoomImages
            listOf("nursery", "nurser", "baby room", "kids room", "child room").any { it in p } -> nurseryImages
            listOf("office", "work", "workspace", "home office").any { it in p } -> officeImages
            else -> defaultImages
        }

        return selectedList.random()
    }
}