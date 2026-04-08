import com.example.decorato.domain.model.AppLanguage

sealed class ProfileEffect{
    object NavigationToLogin : ProfileEffect()
    object NavigationToEditProfile : ProfileEffect()
    object NavigationToMyPosts : ProfileEffect()
    object NavigationToMyRating : ProfileEffect()
    data class ShowMessage(val message: String) : ProfileEffect()
    data class ChangeLanguage(val language: AppLanguage) : ProfileEffect() // ضيفي ده
}