sealed interface MyPostsEffect {
    object NavigateBack : MyPostsEffect
    data class NavigateToPostDetails(val postId: Int) : MyPostsEffect
}