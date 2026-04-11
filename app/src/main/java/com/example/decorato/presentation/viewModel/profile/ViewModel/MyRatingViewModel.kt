package com.example.decorato.presentation.viewModel.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.decorato.domain.repository.DesignRepository
import com.example.decorato.presentation.viewModel.profile.Effect.MyRatingEffect
import com.example.decorato.presentation.viewModel.profile.InteractionListener.MyRatingInteractionListener
import com.example.decorato.presentation.viewModel.profile.UiState.MyRatingUiState
import com.example.decorato.presentation.viewModel.profile.UiState.RatingItemUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyRatingViewModel @Inject constructor(
    private val designRepository: DesignRepository
) : ViewModel(), MyRatingInteractionListener {

    private val _state = MutableStateFlow(MyRatingUiState())
    val state = _state.asStateFlow()

    // 🔥 الـ Effect Flow عشان الـ Navigation
    private val _effect = MutableSharedFlow<MyRatingEffect>()
    val effect = _effect.asSharedFlow()

    init {
        getUserRatings()
    }

    private fun getUserRatings() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            try {
                // هنا مستقبلاً هنستخدم الـ designRepository.getUserRatings()
                getFakeRatings()
            } catch (e: Exception) {
                // handle error
            } finally {
                _state.update { it.copy(isLoading = false) }
            }
        }
    }

    private fun getFakeRatings() {
        _state.update {
            it.copy(
                ratings = listOf(
                    RatingItemUiState(1, "Classic Kitchen", "Fayoum, Egypt", 4.8, "https://via.placeholder.com/150"),
                    RatingItemUiState(2, "Modern Office", "Cairo, Egypt", 4.0, "https://via.placeholder.com/150")
                )
            )
        }
    }

    override fun onBackClick() {
        viewModelScope.launch {
            // 🔥 بنبعت الـ Effect اللي إنتِ عرفتيه في الـ Interface
            _effect.emit(MyRatingEffect.NavigateBack)
        }
    }

    override fun onRatingItemClick(id: Int) {
        viewModelScope.launch {
            _effect.emit(MyRatingEffect.NavigateToRatingDetails(id))
        }
    }
}