import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.decorato.presentation.screens.profile.components.EditProfileFields
import com.example.decorato.presentation.screens.profile.components.EditProfileHeader
import com.example.decorato.presentation.theme.AppTheme
import com.example.decorato.presentation.viewModel.profile.EditProfileViewModel
import com.example.decorato.presentation.viewModel.profile.InteractionListener.EditProfileInteractionListener
import com.example.decorato.presentation.viewModel.profile.UiState.EditProfileUiState

@Composable
fun EditProfileScreen(
    viewModel: EditProfileViewModel = hiltViewModel(), // لازم فاصلة هنا
    onBackClick: () -> Unit // ضفنا الباراميتر ده عشان الـ NavGraph يشوفه
) {
    val state by viewModel.state.collectAsState()

    EditProfileContent(
        state = state,
        listener = viewModel, // لازم فاصلة هنا
        onBackClick = onBackClick // بنبعت الـ back click للـ content
    )
}

@Composable
private fun EditProfileContent(
    state: EditProfileUiState,
    listener: EditProfileInteractionListener,
    onBackClick: () -> Unit // لازم نعرفه هنا كمان
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.color.surface)
            .verticalScroll(scrollState)
    ) {
        // 1. الجزء العلوي
        EditProfileHeader(
            userImage = state.userImage,
            onBackClick = onBackClick, // بنستخدم الـ onBackClick اللي جاية من الـ NavGraph مباشرة
            onUpdateImageClick = listener::onUpdateImageClick
        )

        // 2. الجزء السفلي
        EditProfileFields(
            state = state,
            interactionListener = listener
        )
    }
}