import com.example.decorato.domain.model.AppLanguage

interface ProfileInteractionListener  {
    fun onClickLogin()

    fun onClickLogout()
    fun onConfirmLogout()
    fun onDismissLogoutDialog()

    fun onClickEditProfile()
    fun onClickMyPosts()
    fun onClickMyRating()

    fun onClickLanguage()
    fun onSelectLanguage(language: AppLanguage)
    fun onConfirmLanguage()
    fun onDismissLanguageDialog()

    fun onToggleDarkMode(isDark: Boolean)
}