package com.example.decorato.presentation.viewModel.home

import com.example.decorato.domain.useCase.GetPopularDesignsUseCase
import com.example.decorato.domain.useCase.GetRecentlyWatchedDesignsUseCase
import com.example.decorato.domain.useCase.GetStylesUseCase
import com.example.decorato.domain.useCase.GetRoomTypesUseCase
import com.example.decorato.domain.useCase.GetRoomDesignsByTypeUseCase
import com.example.decorato.presentation.viewModel.shared.BaseViewModel
import com.example.decorato.presentation.viewModel.utils.dispatcher.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPopularDesignsUseCase: GetPopularDesignsUseCase,
    private val getRecentlyWatchedDesignsUseCase: GetRecentlyWatchedDesignsUseCase,
    private val getStylesUseCase: GetStylesUseCase,
    private val getRoomTypesUseCase: GetRoomTypesUseCase,
    private val getRoomDesignsByTypeUseCase: GetRoomDesignsByTypeUseCase,
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
        loadStyles()
        loadRoomTypes()
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

    private fun loadStyles() {
        updateState { currentState ->
            currentState.copy(
                styleSectionUiState = currentState.styleSectionUiState.copy(
                    isLoading = true
                )
            )
        }

        tryToExecute(
            action = { getStylesUseCase() },
            onSuccess = { styles ->
                updateState { currentState ->
                    currentState.copy(
                        styleSectionUiState = homeUiStateMapper.toStyleSectionUiState(
                            styles = styles,
                            isLoading = false
                        ),
                        isLoading = false
                    )
                }
            },
            onError = { exception ->
                updateState { currentState ->
                    currentState.copy(
                        styleSectionUiState = currentState.styleSectionUiState.copy(
                            isLoading = false
                        ),
                        isLoading = false
                    )
                }
                sendNewEffect(HomeEffect.ShowErrorSnackBar("Failed to load styles"))
            },
            withAutoUpdateErrorState = true
        )
    }

    private fun loadRoomTypes() {
        updateState { currentState ->
            currentState.copy(
                roomTypeSectionUiState = currentState.roomTypeSectionUiState.copy(
                    isLoading = true
                )
            )
        }

        tryToExecute(
            action = { getRoomTypesUseCase() },
            onSuccess = { roomTypes ->
                updateState { currentState ->
                    currentState.copy(
                        roomTypeSectionUiState = homeUiStateMapper.toRoomTypeSectionUiState(
                            roomTypes = roomTypes,
                            isLoading = false
                        ),
                        isLoading = false
                    )
                }
                loadRoomDesignsByType(roomTypes.firstOrNull()?.id ?: "1")
            },
            onError = { exception ->
                updateState { currentState ->
                    currentState.copy(
                        roomTypeSectionUiState = currentState.roomTypeSectionUiState.copy(
                            isLoading = false
                        ),
                        isLoading = false
                    )
                }
                sendNewEffect(HomeEffect.ShowErrorSnackBar("Failed to load room types"))
            },
            withAutoUpdateErrorState = true
        )
    }

    private fun loadRoomDesignsByType(roomTypeId: String) {
        updateState { currentState ->
            currentState.copy(
                roomDesignsSectionUiState = currentState.roomDesignsSectionUiState.copy(
                    isLoading = true
                )
            )
        }

        tryToExecute(
            action = { getRoomDesignsByTypeUseCase(roomTypeId) },
            onSuccess = { designs ->
                updateState { currentState ->
                    currentState.copy(
                        roomDesignsSectionUiState = homeUiStateMapper.toRoomDesignsSectionUiState(
                            roomDesigns = designs,
                            isLoading = false
                        )
                    )
                }
            },
            onError = { exception ->
                updateState { currentState ->
                    currentState.copy(
                        roomDesignsSectionUiState = currentState.roomDesignsSectionUiState.copy(
                            isLoading = false
                        )
                    )
                }
                sendNewEffect(HomeEffect.ShowErrorSnackBar("Failed to load room designs"))
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

    override fun onClickStyleItem(styleId: String) {
        sendNewNavigationEffect(HomeEffect.NavigateToStyleDetails(styleId))
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

    override fun onRoomTypeSelected(roomTypeId: String) {
        updateState { currentState ->
            currentState.copy(
                roomTypeSectionUiState = currentState.roomTypeSectionUiState.copy(
                    selectedRoomTypeId = roomTypeId,
                    items = currentState.roomTypeSectionUiState.items.map { item ->
                        item.copy(isSelected = item.id == roomTypeId)
                    }
                )
            )
        }
        loadRoomDesignsByType(roomTypeId)
    }

    override fun onClickRoomDesign(designId: String) {
        sendNewNavigationEffect(HomeEffect.NavigateToDesignDetails(designId))
    }
}