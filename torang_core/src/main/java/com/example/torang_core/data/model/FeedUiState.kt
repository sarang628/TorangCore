package com.example.torang_core.data.model

data class FeedUiState(
    val reviewId: Int? = 0,
    val userName: String?,
    val restaurantName: String?,
    val profileImageUrl: String?,
    val reivewImages: List<String>?,
    val isLike: Boolean,
    val isFavorite: Boolean,
    val likeCount: Int? = 0,
    val commentCount: Int = 0,
    val writerComment: CommentUiState? = null,
    val comments: Array<CommentUiState>? = null
)

data class CommentUiState(
    val userName: String,
    val comment: String
)