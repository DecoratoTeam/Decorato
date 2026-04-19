package com.example.decorato.presentation.viewmodel.community.community_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.decorato.domain.entity.Post
import com.example.decorato.domain.entity.User
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


//@HiltViewModel
class CommunityViewModel : ViewModel(), CommunityInteractionListener {

    private val _state = MutableStateFlow(CommunityUiState())
    val state = _state.asStateFlow()

    // الراديو اللي هيبث أوامر التنقل (حل مشكلة Unresolved reference 'effect')
    private val _effect = MutableSharedFlow<CommunityEffect>()
    val effect = _effect.asSharedFlow()

    init {
        getPosts()
    }

    private fun getPosts() {
        _state.update { it.copy(isLoading = true) }

        val fakePosts = listOf(

            Post(
                id = "4",
                user = User(
                    id = "104",
                    name = "Ahmed Khaled",
                    email = "ahmed@decorato.com",
                    fullName = "Ahmed Khaled",
                    profileImage = "https://images.unsplash.com/photo-1472099645785-5658abf4ff4e"
                ),
                description = "Classic meets Modern. 🏛️✨",
                postImageUrl = "https://images.unsplash.com/photo-1513519245088-0e12902e5a38",
                postDate = "3 days ago",
                likesCount = 89,
                isLiked = true
            ),
            Post(
                id = "2",
                user = User(
                    id = "102",
                    name = "Omar Ali",
                    email = "omar@decorato.com",
                    fullName = "Omar Ali",
                    profileImage = "https://images.unsplash.com/photo-1500648767791-00dcc994a43e"
                ),
                description = "Minimalist Office Setup. Simple and Clean. 💻",
                postImageUrl = "https://images.unsplash.com/photo-1497366216548-37526070297c",
                postDate = "5 hours ago",
                likesCount = 12,
                isLiked = true
            ),

            Post(
                id = "1",
                user = User(
                    id = "101",
                    name = "Sama Ahmed",
                    email = "sama@decorato.com",
                    fullName = "Sama Ahmed",
                    profileImage = "https://images.unsplash.com/photo-1494790108377-be9c29b29330"
                ),
                description = "أول تجربة ليا في تصميم الـ Modern Living Room.. إيه رأيكم في تناسق الألوان؟ ✨ #InteriorDesign",
                postImageUrl = "https://images.unsplash.com/photo-1586023492125-27b2c045efd7",
                postDate = "2 hours ago",
                likesCount = 24,
                isLiked = false
            ),

            Post(
                id = "3",
                user = User(
                    id = "103",
                    name = "Nour Hassan",
                    email = "nour@decorato.com",
                    fullName = "Nour Hassan",
                    profileImage = "https://images.unsplash.com/photo-1438761681033-6461ffad8d80"
                ),
                description = "إزاي تستغل المساحات الضيقة في أوضة النوم؟ تابعوا الثريد ده.. 💡",
                postImageUrl = null, // بوست نصي فقط للتجربة
                postDate = "Yesterday",
                likesCount = 45,
                isLiked = false
            ),

        )

        _state.update {
            it.copy(
                isLoading = false,
                posts = fakePosts,
                userProfileImageUrl = "https://images.unsplash.com/photo-1535713875002-d1d0cf377fde", // صورتك إنتي كـ User
                isGuest = false // عشان سكشن الشير يظهر
            )
        }
    }

    override fun onClickSharePostSection() {
        viewModelScope.launch {
            _effect.emit(CommunityEffect.NavigateToCreatePost)
        }
    }

    override fun onClickLike(postId: String) {
        _state.update { currentState ->
            val updatedPosts = currentState.posts.map { post ->
                if (post.id == postId) {
                    post.copy(
                        isLiked = !post.isLiked,
                        likesCount = if (post.isLiked) post.likesCount - 1 else post.likesCount + 1
                    )
                } else post
            }
            currentState.copy(posts = updatedPosts)
        }
    }



    override fun onClickUserAvatar(userId: String) {
        viewModelScope.launch {
            _effect.emit(CommunityEffect.NavigateToUserProfile(userId))
        }
    }
    fun onClickMyProfile() {
        viewModelScope.launch {
            // إحنا معرفين الـ Effect ده قبل كدة في ملف الـ CommunityEffect
            _effect.emit(CommunityEffect.NavigateToUserProfile("my_id"))
        }
    }

    // ميثود إضافية لفتح تفاصيل التصميم (حل مشكلة NavigateToPostDetails)
    fun onPostClick(postId: String) {
        viewModelScope.launch {
            _effect.emit(CommunityEffect.NavigateToPostDetails(postId))
        }
    }

    override fun onClickDownload(imageUrl: String?) {
        imageUrl?.let { url ->
            viewModelScope.launch {
                _effect.emit(CommunityEffect.DownloadImage(url))
            }
        }
    }


    override fun onRefresh() { getPosts() }
    override fun onClickLogin() { /* Logic for Guest */ }
}