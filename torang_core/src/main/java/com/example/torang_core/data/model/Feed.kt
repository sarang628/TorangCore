package com.example.torang_core.data.model

import androidx.room.ColumnInfo
import com.example.torang_core.data.data.ReviewAndImage

data class Feed(
    val review_id: Int = -1,
    @ColumnInfo(name = "user_id") val userId: Int,
    val is_favority: Boolean? = false,
    val contents: String? = null,
    val create_date: String? = null,
    val rating: Float? = 0f,
    val userName: String? = null,
    val profile_pic_url: String? = null,
    val like_amount: Int? = 0,
    val comment_amount: Int? = 0,
    @ColumnInfo(name = "restaurant_name") val restaurantName: String? = null,
    @ColumnInfo(name = "restaurant_id") val restaurantId: Int? = 0
) {
    fun toReview(): Review {
        return Review().apply {
            this.review_id = this@Feed.review_id
        }
    }

    companion object{
        fun parse(reviewAndImage: ReviewAndImage) : Feed{
            return Feed(
                userId = reviewAndImage.user!!.userId,
                review_id = reviewAndImage.review!!.review_id
            )
        }
    }
}
