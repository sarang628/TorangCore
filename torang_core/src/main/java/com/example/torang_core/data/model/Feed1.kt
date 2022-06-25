package com.example.torang_core.data.model

import androidx.room.Embedded
import androidx.room.Relation

data class Feed1(
    @Embedded val feed: FeedData?,
    @Relation(
        parentColumn = "user_id",
        entityColumn = "userId"
    )
    val user: UserData?,

    @Relation(
        parentColumn = "review_id",
        entityColumn = "review_id"
    )
    val images: List<ReviewImage>? = null,

    @Relation(
        parentColumn = "restaurant_id",
        entityColumn = "restaurant_id"
    )
    val restaurant: RestaurantData?,

    @Relation(
        parentColumn = "review_id",
        entityColumn = "review_id"
    )
    val like: Like?,

    @Relation(
        parentColumn = "review_id",
        entityColumn = "review_id"
    )
    val favorite: Favorite?


)


fun Feed1.toFeedUiState(): FeedUiState {
    return FeedUiState(
        reviewId = this.feed?.review_id,
        userName = this.user?.userName,
        restaurantName = this.restaurant?.restaurant_name,
        profileImageUrl = this.user?.profile_pic_url,
        reivewImages = this.images?.toStringArray(),
        isLike = this.like != null,
        isFavorite = this.favorite != null,
        likeCount = this.feed?.like_amount
    )
}

fun List<Feed1>.toFeedUiStateLis(): List<FeedUiState> {
    val list = ArrayList<FeedUiState>()
    for (feed in this) {
        list.add(feed.toFeedUiState())
    }
    return list
}