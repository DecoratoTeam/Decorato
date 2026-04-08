package com.example.decorato.presentation.viewModel.profile // تأكدي إن المسار ده صح عندك

import androidx.lifecycle.ViewModel
import com.example.decorato.presentation.viewModel.profile.InteractionListener.MyPostsInteractionListener
import com.example.decorato.presentation.viewModel.profile.UiState.MyPostsUiState
import com.example.decorato.presentation.viewModel.profile.UiState.PostItemUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MyPostsViewModel @Inject constructor() : ViewModel(), MyPostsInteractionListener {

    private val _state = MutableStateFlow(MyPostsUiState())
    val state = _state.asStateFlow()

    init {
        // بنملى داتا وهمية مطابقة للفيجما
        getFakePosts()
    }

    private fun getFakePosts() {
        _state.update {
            it.copy(
                posts = listOf(
                    PostItemUiState(
                        id = 1,
                        userName = "Mohammed Ali",
                        userImage = "https://images.unsplash.com/photo-1500648767791-00dcc994a43e",
                        postImage = "https://images.unsplash.com/photo-1583847268964-b28dc8f51f92",
                        timeAgo = "2 Hours ago",
                        description = "Lorem ipsum dolor sit amet consectetur. Ut velit platea imperdiet quam quis quam at.",
                        likesCount = "Q&A with Mark & 361k others"
                    ),
                    PostItemUiState(
                        id = 2,
                        userName = "Mohammed Ali",
                        userImage = "https://images.unsplash.com/photo-1500648767791-00dcc994a43e",
                        postImage = "https://images.unsplash.com/photo-1522771739844-6a9f6d5f14af",
                        timeAgo = "5 Hours ago",
                        description = "Another amazing interior design for the living room.",
                        likesCount = "120 likes"
                    )
                )
            )
        }
    }

    override fun onClickPost(postId: Int) {
        // هندلي الضغط على البوست هنا
    }

    override fun onBackClick() {
        // هندلي الرجوع هنا
    }

    override fun onClickDeletePost(postId: Int) {
        // هندلي المسح هنا
    }
}