package com.example.decorato.presentation.viewModel.profile // تأكدي من المسار

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.decorato.presentation.viewModel.profile.InteractionListener.MyRatingInteractionListener
import com.example.decorato.presentation.viewModel.profile.UiState.MyRatingUiState
import com.example.decorato.presentation.viewModel.profile.UiState.RatingItemUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MyRatingViewModel @Inject constructor() : ViewModel(), MyRatingInteractionListener {

    private val _state = MutableStateFlow(MyRatingUiState())
    val state = _state.asStateFlow()

    init {
        // بنحط داتا وهمية عشان الشاشة تنطق معاكي وتجربيها
        getFakeRatings()
    }

    private fun getFakeRatings() {
        _state.update {
            it.copy(
                ratings = listOf(
                    RatingItemUiState(1, "Living Room", "Serenbe, Georgia", 4.5, "https://via.placeholder.com/150"),
                    RatingItemUiState(2, "Modern Bedroom", "Cairo, Egypt", 3.0, "https://via.placeholder.com/150")
                )
            )
        }
    }

    override fun onBackClick() {
        // هندلي الرجوع هنا
    }

    override fun onRatingItemClick(id: Int) {
        // هندلي الضغط على الكارد هنا
    }
}