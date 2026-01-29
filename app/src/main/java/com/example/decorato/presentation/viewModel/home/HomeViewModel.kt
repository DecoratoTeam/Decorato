package com.example.decorato.presentation.viewModel.home


import com.example.decorato.domain.useCase.GetPopularDesignsUseCase
import com.example.decorato.domain.useCase.GetRecentlyWatchedDesignsUseCase
import com.example.decorato.presentation.viewModel.shared.BaseViewModel
import com.example.decorato.presentation.viewModel.utils.dispatcher.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPopularDesignsUseCase: GetPopularDesignsUseCase,
    private val getRecentlyWatchedDesignsUseCase: GetRecentlyWatchedDesignsUseCase,
    private val homeUiStateMapper: HomeUiStateMapper,
    dispatcherProvider: DispatcherProvider
) : BaseViewModel<HomeUiState, HomeEffect>(
    initialState = HomeUiState(),
    dispatcherProvider = dispatcherProvider
), HomeInteractionListener {

    init {
        loadHomeData()
    }

    private fun loadHomeData() {
        updateState { it.copy(isLoading = true) }
        loadPopularDesigns()
        loadRecentlyWatchedDesigns()
    }

    private fun loadPopularDesigns() {
        updateState { currentState ->
            currentState.copy(
                popularSectionUiState = currentState.popularSectionUiState.copy(
                    isLoading = true
                )
            )
        }

        tryToExecute(
            action = { getPopularDesignsUseCase() },
            onSuccess = { designs ->
                updateState { currentState ->
                    currentState.copy(
                        popularSectionUiState = homeUiStateMapper.toPopularSectionUiState(
                            designs = designs,
                            isLoading = false
                        ),
                        isLoading = false
                    )
                }
            },
            onError = { exception ->
                updateState { currentState ->
                    currentState.copy(
                        popularSectionUiState = currentState.popularSectionUiState.copy(
                            isLoading = false
                        ),
                        isLoading = false
                    )
                }
                sendNewEffect(HomeEffect.ShowErrorSnackBar("Failed to load popular designs"))
            },
            withAutoUpdateErrorState = true
        )
    }

    private fun loadRecentlyWatchedDesigns() {
        updateState { currentState ->
            currentState.copy(
                recentlyWatchedSectionUiState = currentState.recentlyWatchedSectionUiState.copy(
                    isLoading = true
                )
            )
        }

        tryToExecute(
            action = { getRecentlyWatchedDesignsUseCase() },
            onSuccess = { designs ->
                updateState { currentState ->
                    currentState.copy(
                        recentlyWatchedSectionUiState = homeUiStateMapper.toRecentlyWatchedSectionUiState(
                            designs = designs,
                            isLoading = false
                        ),
                        isLoading = false
                    )
                }
            },
            onError = { exception ->
                updateState { currentState ->
                    currentState.copy(
                        recentlyWatchedSectionUiState = currentState.recentlyWatchedSectionUiState.copy(
                            isLoading = false
                        ),
                        isLoading = false
                    )
                }
                sendNewEffect(HomeEffect.ShowErrorSnackBar("Failed to load recently watched"))
            },
            withAutoUpdateErrorState = true
        )
    }

    override fun onClickPopularItem(designId: String) {
        sendNewNavigationEffect(HomeEffect.NavigateToDesignDetails(designId))
    }

    override fun onClickRecentlyWatchedItem(designId: String) {
        sendNewNavigationEffect(HomeEffect.NavigateToDesignDetails(designId))
    }

    override fun onClickShowAllRecentlyWatched() {
        sendNewNavigationEffect(HomeEffect.NavigateToAllRecentlyWatched)
    }

    override fun onTabSelected(tabIndex: Int) {
        updateState { it.copy(selectedBottomNavTab = tabIndex) }
        sendNewNavigationEffect(HomeEffect.NavigateToTab(tabIndex))
    }

    override fun onClickRetryLoading() {
        resetErrorStateToNull()
        loadHomeData()
    }
}