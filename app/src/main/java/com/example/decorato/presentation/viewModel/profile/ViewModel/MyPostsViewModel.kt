package com.example.decorato.presentation.viewModel.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.decorato.domain.repository.DesignRepository
import com.example.decorato.presentation.viewModel.profile.InteractionListener.MyPostsInteractionListener
import com.example.decorato.presentation.viewModel.profile.UiState.MyPostsUiState
import com.example.decorato.presentation.viewModel.profile.UiState.PostItemUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyPostsViewModel @Inject constructor(
    private val designRepository: DesignRepository // ربطناه بالريبوزيتوري بتاع التصميمات
) : ViewModel(), MyPostsInteractionListener {

    private val _state = MutableStateFlow(MyPostsUiState())
    val state = _state.asStateFlow()

    init {
        getUserPosts()
    }

    private fun getUserPosts() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            try {
                // الزيتونة: هنا بنادي الفانكشن اللي بتجيب بوستات اليوزر
                // ملحوظة: لو زميلك لسه مخلصش getMyPosts، سيبي الـ FakeData مؤقتاً
                // val posts = designRepository.getMyPosts()

                // حالياً هنخلي الداتا الوهمية شغالة بس جوه الـ Try عشان لما نربط بجد
                getFakePosts()
            } catch (e: Exception) {
                // هندلة الخطأ
            } finally {
                _state.update { it.copy(isLoading = false) }
            }
        }
    }

    private fun getFakePosts() {
        _state.update {
            it.copy(
                posts = listOf(
                    PostItemUiState(
                        id = 1,
                        userName = "Eng. Decorato",
                        userImage = "https://images.unsplash.com/photo-1500648767791-00dcc994a43e",
                        postImage = "https://images.unsplash.com/photo-1583847268964-b28dc8f51f92",
                        timeAgo = "2 Hours ago",
                        description = "Modern living room design using neutral colors.",
                        likesCount = "361k likes"
                    )
                )
            )
        }
    }

    override fun onClickPost(postId: Int) { /* انتقال لتفاصيل البوست */ }

    override fun onBackClick() { /* رجوع */ }

    override fun onClickDeletePost(postId: Int) {
        viewModelScope.launch {
            // designRepository.deletePost(postId)
        }
    }
}