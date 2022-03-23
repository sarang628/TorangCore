package com.example.torang_core.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.torang_core.data.data.ReviewAndImage
import com.example.torang_core.data.model.*

@Dao
interface MyReviewDao {
    @Query("select * from ReviewImage where review_id = (:reviewId) order by ReviewImage.create_date desc")
    fun getUploadedImage(reviewId: Int): LiveData<List<ReviewImage>>


    @Query("select * from FeedData where user_id = (:userId) and restaurant_id = (:restaurantId) order by FeedData.create_date desc")
    fun getMyReviews(userId: Int, restaurantId: Int): LiveData<List<ReviewAndImage>>
}