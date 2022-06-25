package com.example.torang_core.data.data

import androidx.room.Embedded
import androidx.room.Relation
import com.example.torang_core.data.model.*
import okhttp3.MediaType
import okhttp3.RequestBody

data class ReviewAndImage(
    @Embedded val review: FeedData? = null,
    @Relation(
        parentColumn = "review_id",
        entityColumn = "review_id"
    )
    val images: List<ReviewImage>? = null,

    @Relation(
        parentColumn = "user_id",
        entityColumn = "userId"
    )
    val user: UserData? = null
) {
    fun toMap(): HashMap<String, RequestBody> {
        val params: HashMap<String, RequestBody> = HashMap()
        params["review_id"] =
            RequestBody.create(MediaType.parse("text/plain"), "" + review?.review_id)
        params["torang_id"] =
            RequestBody.create(MediaType.parse("text/plain"), "" + review?.restaurant_id)
        user?.userId?.let {
            params["user_id"] = RequestBody.create(MediaType.parse("text/plain"), "" + it)
        }
        params["contents"] =
            RequestBody.create(MediaType.parse("text/plain"), "" + review?.contents)
        params["rating"] = RequestBody.create(MediaType.parse("text/plain"), "" + review?.rating)
        return params
    }

    companion object {
        @JvmStatic
        fun parse(review: Review): ReviewAndImage {
            return ReviewAndImage(
                FeedData.parse(review),
                ArrayList<ReviewImage>().apply {
                    for (picture in review.pictures) {
                        add(ReviewImage.parse(picture))
                    }
                },
                UserData.parse(review.user)
            )
        }
    }
}

//TODO::코틀린 null 처리 방법
fun ReviewAndImage.toFeedUiState(): FeedUiState? {

    if (this.review != null && this.user != null) {
        return FeedUiState(
            reviewId = review.review_id,
            userName = if (user.userName == null) "" else user.userName,
            restaurantName = "" + review.restaurant_id,
            profileImageUrl = if (user.profile_pic_url == null) "" else user.profile_pic_url,
            reivewImages = arrayListOf(""),
            isLike = false,
            isFavorite = false,
            likeCount = 10,
            commentCount = 10
            )
    }
    return null
}

fun List<ReviewAndImage>.toFeedUiStateLis(): List<FeedUiState> {
    val list = ArrayList<FeedUiState>()
    for (reviewAndImage in this) {
        reviewAndImage.toFeedUiState()?.let {
            list.add(it)
        }
    }
    return list
}