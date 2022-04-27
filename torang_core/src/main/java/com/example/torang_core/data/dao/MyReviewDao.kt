package com.example.torang_core.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.torang_core.data.data.ReviewAndImage
import com.example.torang_core.data.model.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MyReviewDao {
    @Query("select * from ReviewImage where review_id = (:reviewId) order by ReviewImage.create_date desc")
    fun getUploadedImage(reviewId: Int): LiveData<List<ReviewImage>>


    @Query("select * from FeedData where user_id = (:userId) and restaurant_id = (:restaurantId) order by FeedData.create_date desc")
    fun getMyReviews(userId: Int, restaurantId: Int): LiveData<List<ReviewAndImage>>


    @Query(
        """
                select FeedData.review_id
                ,picture_url as reviewImageUrl
                ,rating
                ,contents
                ,FeedData.create_date as uploadDate
                ,max(ReviewImage.picture_id) as picture_id
                from FeedData left outer join ReviewImage   
                on FeedData.review_id = ReviewImage.review_id
                and FeedData.user_id = (:userId) and FeedData.restaurant_id = (:restaurantId)
                union
                select FeedData.review_id
                ,picture_url as reviewImageUrl
                ,rating
                ,contents
                ,FeedData.create_date as uploadDate
                ,ReviewImage.picture_id
                from FeedData left outer join ReviewImage   
                on FeedData.review_id = ReviewImage.review_id
                where picture_id is null
                and FeedData.user_id = (:userId) and FeedData.restaurant_id = (:restaurantId)
            """
    )
    fun getMyReviews2(userId: Int, restaurantId: Int): Flow<List<MyReviewItemUiState>>
}