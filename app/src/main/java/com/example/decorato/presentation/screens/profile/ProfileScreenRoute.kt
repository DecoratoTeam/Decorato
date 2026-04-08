import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.decorato.presentation.navigation.NavigationManager
import com.example.decorato.presentation.screens.profile.ProfileScreen
import com.example.decorato.presentation.screens.profile.ProfileViewModel

@Composable
fun ProfileScreenRoute(
    navigationManager: NavigationManager,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is ProfileEffect.NavigationToLogin -> {
                    navigationManager.toLogin(clearBackStack = true)
                }
                is ProfileEffect.NavigationToEditProfile -> {
                    navigationManager.toEditProfile()
                }
                is ProfileEffect.NavigationToMyPosts -> {
                    navigationManager.toMyPosts()
                }
                is ProfileEffect.NavigationToMyRating -> {
                    navigationManager.toMyRating()
                }
                is ProfileEffect.ShowMessage -> {
                    // هندلة الرسائل
                }

                // الزيتونة: ضيفي الحالة دي عشان الكومبيلر يسكت
                is ProfileEffect.ChangeLanguage -> {
                    // عادةً تغيير اللغة بنهندله في الـ Activity أو ApplicationViewModel
                    // فممكن تسيبيها فاضية هنا لو مش محتاجة أكشن معين في الشاشة دي
                }
            }
        }
    }

    ProfileScreen(
        state = state,
        listener = viewModel
    )
}
