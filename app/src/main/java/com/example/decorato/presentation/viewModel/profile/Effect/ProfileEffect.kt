import com.example.decorato.domain.model.AppLanguage

sealed class ProfileEffect {
    object NavigationToLogin : ProfileEffect()
    object NavigationToEditProfile : ProfileEffect()
    object NavigationToMyPosts : ProfileEffect()
    object NavigationToMyRating : ProfileEffect()
    data class ShowMessage(val message: String) : ProfileEffect()

    // الزيتونة: ضفنا القوسين () بعد ProfileEffect عشان ده Class مش Interface
    data class ChangeLanguage(val language: AppLanguage) : ProfileEffect()
    data class ChangeTheme(val isDark: Boolean) : ProfileEffect()
}