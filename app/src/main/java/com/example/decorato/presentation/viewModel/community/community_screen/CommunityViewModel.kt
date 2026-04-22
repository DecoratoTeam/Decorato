package com.example.decorato.presentation.viewModel.community.community_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.decorato.domain.entity.Post
import com.example.decorato.domain.entity.User
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

            Post(
                id = "5",
                user = User(
                    id = "105",
                    name = "Mariam Tarek",
                    email = "mariam@decorato.com",
                    fullName = "Mariam Tarek",
                    profileImage = "https://images.unsplash.com/photo-1544005313-94ddf0286df2"
                ),
                description = "حوّلت ركن صغير في البيت لـ Cozy Reading Corner 📚✨",
                postImageUrl = "https://images.unsplash.com/photo-1505693416388-ac5ce068fe85",
                postDate = "1 hour ago",
                likesCount = 18,
                isLiked = false
            ),
            Post(
                id = "6",
                user = User(
                    id = "106",
                    name = "Youssef Adel",
                    email = "youssef@decorato.com",
                    fullName = "Youssef Adel",
                    profileImage = "https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d"
                ),
                description = "Kitchen makeover before/after 🔥",
                postImageUrl = "https://images.unsplash.com/photo-1556911220-bff31c812dba",
                postDate = "30 minutes ago",
                likesCount = 31,
                isLiked = true
            ),
            Post(
                id = "7",
                user = User(
                    id = "107",
                    name = "Laila Samy",
                    email = "laila@decorato.com",
                    fullName = "Laila Samy",
                    profileImage = "https://images.unsplash.com/photo-1487412720507-e7ab37603c6f"
                ),
                description = "Neutral tones + wood textures = perfect calm bedroom 🤍",
                postImageUrl = "https://images.unsplash.com/photo-1616594039964-3d5d6e9f6f8f",
                postDate = "Today",
                likesCount = 56,
                isLiked = false
            ),
            Post(
                id = "8",
                user = User(
                    id = "108",
                    name = "Karim Nabil",
                    email = "karim@decorato.com",
                    fullName = "Karim Nabil",
                    profileImage = "https://images.unsplash.com/photo-1463453091185-61582044d556"
                ),
                description = "أفضل توزيع للإضاءة في الـ living room؟",
                postImageUrl = null,
                postDate = "4 hours ago",
                likesCount = 9,
                isLiked = false
            ),
            Post(
                id = "9",
                user = User(
                    id = "109",
                    name = "Hana Wael",
                    email = "hana@decorato.com",
                    fullName = "Hana Wael",
                    profileImage = "https://images.unsplash.com/photo-1524504388940-b1c1722653e1"
                ),
                description = "Bathroom refresh بأقل تكلفة 🚿🌿",
                postImageUrl = "https://images.unsplash.com/photo-1584622781564-1d987f7333c1",
                postDate = "Yesterday",
                likesCount = 40,
                isLiked = true
            ),
            Post(
                id = "10",
                user = User(
                    id = "110",
                    name = "Mostafa Hany",
                    email = "mostafa@decorato.com",
                    fullName = "Mostafa Hany",
                    profileImage = "https://images.unsplash.com/photo-1506794778202-cad84cf45f1d"
                ),
                description = "Home office setup for productivity ⚡",
                postImageUrl = "https://images.unsplash.com/photo-1497366216548-37526070297c",
                postDate = "2 days ago",
                likesCount = 67,
                isLiked = false
            )
        )

        _state.update {
            it.copy(
                isLoading = false,
                posts = fakePosts,
                userProfileImageUrl = "https://media.istockphoto.com/id/474001966/photo/female-portrait-icon-as-avatar-or-profile-picture.webp?a=1&b=1&s=612x612&w=0&k=20&c=9GKRXt0EXhESvwJgRg-__xIYom3qMwkLQA-TpGmScfc=",
                isGuest = false
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