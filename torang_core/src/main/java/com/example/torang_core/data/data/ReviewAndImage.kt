package com.example.torang_core.data.data

import androidx.room.Embedded
import androidx.room.Relation
import com.example.torang_core.data.model.FeedData
import com.example.torang_core.data.model.Review
import com.example.torang_core.data.model.ReviewImage
import com.example.torang_core.data.model.UserData
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import java.util.HashMap

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

