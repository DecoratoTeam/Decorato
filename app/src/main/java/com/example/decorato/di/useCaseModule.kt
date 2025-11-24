package com.example.decorato.di


import com.example.decorato.domain.repository.AppPreferencesRepository
import com.example.decorato.domain.repository.AuthenticationRepository
import com.example.decorato.domain.useCase.authentication.GetsSessionTypeUseCase
import com.example.decorato.domain.useCase.authentication.LoginAsGuestUseCase
import com.example.decorato.domain.useCase.authentication.LoginWithPasswordUseCase
import com.example.decorato.domain.useCase.authentication.LogoutUseCase
import com.example.decorato.domain.useCase.preferences.GetOnboardingStatusUseCase
import com.example.decorato.domain.useCase.preferences.ManageAppThemeUseCase
import com.example.decorato.domain.useCase.preferences.ManageLocaleLanguageUseCase
import com.example.decorato.domain.useCase.preferences.ManageRestrictionLevelUseCase
import com.example.decorato.domain.useCase.preferences.SetOnboardingCompletedUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun provideManageRestrictionLevelUseCase(appPreferencesRepository: AppPreferencesRepository): ManageRestrictionLevelUseCase =
        ManageRestrictionLevelUseCase(appPreferencesRepository)


    @Provides
    fun provideGetsSessionType(authenticationRepository: AuthenticationRepository): GetsSessionTypeUseCase =
        GetsSessionTypeUseCase(authenticationRepository)

    @Provides
    fun provideGetOnboardingStatusUseCase(appPreferencesRepository: AppPreferencesRepository): GetOnboardingStatusUseCase =
        GetOnboardingStatusUseCase(appPreferencesRepository)

    @Provides
    fun provideSetOnboardingCompletedUseCase(appPreferencesRepository: AppPreferencesRepository): SetOnboardingCompletedUseCase =
        SetOnboardingCompletedUseCase(appPreferencesRepository)


    @Provides
    fun provideSetCurrentLanguage(appPreferencesRepository: AppPreferencesRepository): ManageLocaleLanguageUseCase =
        ManageLocaleLanguageUseCase(appPreferencesRepository)

    @Provides
    fun provideLoginAsGuestUseCase(authenticationRepository: AuthenticationRepository): LoginAsGuestUseCase =
        LoginAsGuestUseCase(authenticationRepository)

    @Provides
    fun provideManageAppThemeUseCase(repo: AppPreferencesRepository): ManageAppThemeUseCase =
        ManageAppThemeUseCase(repo)

    @Provides
    fun provideLoginWithPasswordUseCase(authenticationRepository: AuthenticationRepository): LoginWithPasswordUseCase =
        LoginWithPasswordUseCase(authenticationRepository)

    @Provides
    fun provideLogoutUseCase(authenticationRepository: AuthenticationRepository): LogoutUseCase =
        LogoutUseCase(authenticationRepository)

}



