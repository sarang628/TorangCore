package com.example.torang_core.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.torang_core.data.data.ReviewAndImage

@Entity
data class FeedData(
    @PrimaryKey
    val review_id: Int = -1,
    @ColumnInfo(name = "user_id") val userId: Int,
    val is_favority: Boolean? = false,
    val contents: String? = "",
    val create_date: String? = null,
    val rating: Float? = 0f,
    val restaurant_id: Int? = 0,
    val like_amount: Int? = 0,
    val comment_amount: Int? = 0
) {
    companion object {
        fun parse(feed: Feed): FeedData {
            return FeedData(
                review_id = feed.review_id,
                userId = feed.userId,
                rating = feed.rating,
                restaurant_id = feed.restaurantId,
                comment_amount = feed.comment_amount
            )
        }

        fun parse(reviewAndImage: ReviewAndImage): FeedData? {
            return reviewAndImage.review
        }

        fun parse(review: Review): FeedData {
            return FeedData(
                review_id = review.review_id,
                restaurant_id = review.restaurant_id,
                userId = review.user_id,
                contents = review.contents,
                rating = review.feed.rating,
                create_date = review.create_date
            )
        }
    }
}