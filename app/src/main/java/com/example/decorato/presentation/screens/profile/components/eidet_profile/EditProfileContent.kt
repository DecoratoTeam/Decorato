import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.decorato.presentation.screens.profile.components.EditProfileFields
import com.example.decorato.presentation.screens.profile.components.EditProfileHeader
import com.example.decorato.presentation.viewModel.profile.InteractionListener.EditProfileInteractionListener
import com.example.decorato.presentation.viewModel.profile.UiState.EditProfileUiState

@Composable
private fun EditProfileContent(
    state: EditProfileUiState,
    listener: EditProfileInteractionListener
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        EditProfileHeader(
            userImage = state.userImage,
            onBackClick = listener::onBackClick,
            onUpdateImageClick = listener::onUpdateImageClick
        )

        // التعديل هنا: غيرنا اسم الباراميتر لـ interactionListener عشان يطابق الـ Component
        EditProfileFields(
            state = state,
            interactionListener = listener
        )
    }
}