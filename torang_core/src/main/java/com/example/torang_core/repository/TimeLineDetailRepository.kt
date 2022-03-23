package com.example.torang_core.repository

import androidx.lifecycle.LiveData
import com.example.torang_core.data.data.ReviewAndImage
import com.example.torang_core.data.model.Comment
import com.example.torang_core.data.model.CommentData
import com.example.torang_core.data.model.FeedData
import com.example.torang_core.data.model.RestaurantData

interface TimeLineDetailRepository : LoginCheckableRepository {
    suspend fun getComments(reviewId: String): ArrayList<Comment>
    fun getReview(): LiveData<FeedData>
    fun getRestaurant(reviewId: Int): LiveData<RestaurantData>
    fun getFeed(reviewId: Int): LiveData<ReviewAndImage?>
    suspend fun addComment(reviewId: Int, value: String) : Comment
    fun getComments(reviewId: Int) : LiveData<List<CommentData>>
}