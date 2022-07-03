package com.example.torang_core.data

import com.example.torang_core.data.model.Feed1Data
import com.example.torang_core.data.model.ReviewImage

data class FeedUiState(
    val profileImageUrl: String,
    val userName: String,
    val rating: Float,
    val restaurantName: String,
    val likeAmount: Int,
    val contents: String,
    val commentAmount: Int,
    val isLike: Boolean,
    val isFavorite: Boolean,
    val reviewImages: List<ReviewImage>,
    val userId: Int,
    val reviewId: Int,
    val restaurantId: Int
) {
    override fun equals(other: Any?): Boolean {
        if (other is FeedUiState) {
            if (profileImageUrl != other.profileImageUrl)
                return false

            if (userName != other.userName)
                return false

            if (rating != other.rating)
                return false

            if (restaurantName != other.restaurantName)
                return false

            if (likeAmount != other.likeAmount)
                return false

            if (contents != other.contents)
                return false

            if (commentAmount != other.commentAmount)
                return false

            if (isLike != other.isLike)
                return false

            if (isFavorite != other.isFavorite)
                return false

            if (contents != other.contents)
                return false

            if (commentAmount != other.commentAmount)
                return false

            if (isLike != other.isLike)
                return false

            if (isFavorite != other.isFavorite)
                return false

            if (userId != other.userId)
                return false

            if (reviewId != other.reviewId)
                return false

            if (restaurantId != other.restaurantId)
                return false

            return true
        }
        return super.equals(other)
    }
}

fun ArrayList<FeedUiState>.add(feed1Data: Feed1Data) {
    add(feed1Data.toFeedUiState())
}

fun Feed1Data.toFeedUiState(): FeedUiState {
    return FeedUiState(
        profileImageUrl = this.user?.profile_pic_url!!,
        userName = this.user.userName!!,
        rating = this.feedData.rating!!,
        restaurantName = this.restaurantName(),
        likeAmount = this.feedData.like_amount!!,
        contents = this.feedData.contents!!,
        commentAmount = this.feedData.comment_amount!!,
        isLike = like != null,
        isFavorite = favorite != null,
        reviewImages = this.images!!,
        userId = this.user.userId,
        reviewId = this.feedData.review_id,
        restaurantId = this.restaurantId()
    )
}


fun Feed1Data.restaurantName(): String {
    if (restaurantData == null)
        return ""

    return restaurantData.restaurant_name
}

fun Feed1Data.restaurantId(): Int {
    if (feedData.restaurant_id == null)
        return 0

    return feedData.restaurant_id
}