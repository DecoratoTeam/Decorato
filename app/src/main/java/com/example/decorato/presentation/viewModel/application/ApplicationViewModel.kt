//package com.example.decorato.presentation.viewModel.application
//
//import androidx.lifecycle.viewModelScope
//import androidx.room3.util.copy
//import com.example.decorato.domain.useCase.authentication.GetsSessionTypeUseCase
//import com.example.decorato.presentation.viewModel.utils.dispatcher.DispatcherProvider
//import com.example.decorato.domain.useCase.preferences.GetOnboardingStatusUseCase
//import com.example.decorato.domain.utils.SessionType
//import com.example.decorato.presentation.viewModel.shared.BaseViewModel
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.launch
//import javax.inject.Inject
//import com.example.decorato.domain.model.AppLanguage // ✅ ضيفي ده
//import com.example.decorato.domain.useCase.preferences.ManageLocaleLanguageUseCase
//import kotlinx.coroutines.flow.update
//
//@HiltViewModel
//class ApplicationViewModel @Inject constructor(
//    private val dispatcherProvider: DispatcherProvider,
//    private val getOnboardingStatusUseCase: GetOnboardingStatusUseCase,
//    private val getsSessionType: GetsSessionTypeUseCase,
//    private val manageLocaleLanguageUseCase: ManageLocaleLanguageUseCase // ✅ حقن الـ Use Case هنا
//) : BaseViewModel<ApplicationUiState, Unit>(ApplicationUiState(), dispatcherProvider) {
//
//    init {
//        setStartDestination()
//    }
//
//    // 1. دالة تغيير الدارك مود (الزيتونة: لازم تسيفي في الـ UseCase وتحدثي الـ State)
//    fun onToggleDarkMode(isDark: Boolean) {
//        viewModelScope.launch(dispatcherProvider.IO) {
//            // حفظ الاختيار في الـ Preferences عشان لما يقفل ويفتح يفتكر
//            manageAppThemeUseCase.setAppTheme(isDark)
//
//            // تحديث الـ UI
//            updateState {
//                it.copy(isDarkTheme = isDark)
//            }
//        }
//    }
//
//
//
//    private fun setStartDestination() {
//        viewModelScope.launch(dispatcherProvider.IO) {
//            val isOnboardingCompleted = getOnboardingStatusUseCase()
//
//            if (!isOnboardingCompleted) {
//// First launch → onboarding
//                updateState {
//                    it.copy(
//                        startDestination = ApplicationUiState.StartDestinations.ON_BOARDING ,
//                        isDestinationLoaded = true
//
//                    )
//                }
//            } else {
//                setReturningUserStartDestination()
//            }
//        }
//    }
//
//
//    private suspend fun setReturningUserStartDestination() {
//        val sessionType = getsSessionType()
//
//        val destination = when (sessionType) {
//            SessionType.LOGGED_IN -> ApplicationUiState.StartDestinations.HOME
//            else -> ApplicationUiState.StartDestinations.LOGIN
//        }
//
//        updateState {
//            it.copy(
//                startDestination = destination,
//                isDestinationLoaded = true
//            )
//        }
//    }
//}

package com.example.decorato.presentation.viewModel.application

import androidx.lifecycle.viewModelScope
// ❌ احذفي import androidx.room3.util.copy لو موجود
import com.example.decorato.domain.useCase.authentication.GetsSessionTypeUseCase
import com.example.decorato.presentation.viewModel.utils.dispatcher.DispatcherProvider
import com.example.decorato.domain.useCase.preferences.GetOnboardingStatusUseCase
import com.example.decorato.domain.utils.SessionType
import com.example.decorato.presentation.viewModel.shared.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.decorato.domain.model.AppLanguage
import com.example.decorato.domain.useCase.preferences.ManageLocaleLanguageUseCase
import com.example.decorato.domain.useCase.preferences.ManageAppThemeUseCase // ✅ 1. ضيفي الـ UseCase ده

@HiltViewModel
class ApplicationViewModel @Inject constructor(
    private val dispatcherProvider: DispatcherProvider,
    private val getOnboardingStatusUseCase: GetOnboardingStatusUseCase,
    private val getsSessionType: GetsSessionTypeUseCase,
    private val manageLocaleLanguageUseCase: ManageLocaleLanguageUseCase,
    private val manageAppThemeUseCase: ManageAppThemeUseCase // ✅ 2. لازم يتحقن هنا
) : BaseViewModel<ApplicationUiState, Unit>(ApplicationUiState(), dispatcherProvider) {

    init {
        setStartDestination()

    }

    // ✅ 3. دالة الدارك مود كاملة
    fun onToggleDarkMode(isDark: Boolean) {
        viewModelScope.launch(dispatcherProvider.IO) {
            manageAppThemeUseCase.setAppTheme(isDark)
            updateState {
                it.copy(isDarkTheme = isDark)
            }
        }
    }

    // ✅ 4. دالة اللغة كاملة
    fun onChangeLanguage(language: AppLanguage) {
        viewModelScope.launch(dispatcherProvider.IO) {
            val useCaseLang = if (language == AppLanguage.ARABIC) {
                ManageLocaleLanguageUseCase.Language.ARABIC
            } else {
                ManageLocaleLanguageUseCase.Language.ENGLISH
            }
            manageLocaleLanguageUseCase.setAppLanguage(useCaseLang)
            updateState {
                it.copy(language = language)
            }
        }
    }

    private fun setStartDestination() {
        viewModelScope.launch(dispatcherProvider.IO) {
            val isOnboardingCompleted = getOnboardingStatusUseCase()
            if (!isOnboardingCompleted) {
                updateState {
                    it.copy(
                        startDestination = ApplicationUiState.StartDestinations.ON_BOARDING,
                        isDestinationLoaded = true
                    )
                }
            } else {
                setReturningUserStartDestination()
            }
        }
    }

    private suspend fun setReturningUserStartDestination() {
        val sessionType = getsSessionType()
        val destination = when (sessionType) {
            SessionType.LOGGED_IN -> ApplicationUiState.StartDestinations.HOME
            else -> ApplicationUiState.StartDestinations.LOGIN
        }
        updateState {
            it.copy(
                startDestination = destination,
                isDestinationLoaded = true
            )
        }
    }
}
