package com.example.torang_core.data.model

import com.example.torang_core.data.data.MyReview
import okhttp3.MediaType
import okhttp3.RequestBody
import java.util.*
import kotlin.collections.ArrayList

class Review {
    /**
     *
     */
    var user_id = 0

    /**
     *
     */
    var restaurant_id = 0
    var review_id = 0
    var feed: Feed = Feed(userId = 0)
    var selectedImagePath = ArrayList<String>()
    val pictures = ArrayList<Picture>()
    val restaurant = Restaurant()
    val user = User()
    val contents = ""
    val create_date = ""
    val like_amount: Int = 0

    fun toMap(): Map<String, RequestBody> {
        val params: MutableMap<String, RequestBody> = HashMap()
        params["torang_id"] =
            RequestBody.create(MediaType.parse("text/plain"), "" + restaurant_id)
        params["user_id"] =
            RequestBody.create(MediaType.parse("text/plain"), "" + user_id)
        //if (contents != null)
        //  params.put("contents", RequestBody.create(MediaType.parse("text/plain"), contents));
        //params.put("review_id", RequestBody.create(MediaType.parse("text/plain"), "" + review_id));
        //params.put("rating", RequestBody.create(MediaType.parse("text/plain"), "" + rating));
        return params
    }

    fun toMyReview(): MyReview {
        return MyReview(
            review_id = this.review_id,
            reviewImageUrl = pictures[0].picture_url,
            rating = if (feed.rating != null) feed.rating!! else 0f,
            contents = this.contents,
            uploadDate = this.create_date
        )
    }

    /*if (like == null) {
            like = new Like();
            like.reviewId = review_id;
        }
        return like;*/
    val like: Like
        get() =/*if (like == null) {
            like = new Like();
            like.reviewId = review_id;
        }
        return like;*/
            Like()
}