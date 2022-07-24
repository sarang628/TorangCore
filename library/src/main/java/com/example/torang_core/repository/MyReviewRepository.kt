package com.example.torang_core.repository

import androidx.lifecycle.LiveData
import com.example.torang_core.data.data.ReviewAndImage
import com.example.torang_core.data.model.ModifyFeedData
import com.example.torang_core.data.model.RestaurantData
import com.example.torang_core.data.model.ReviewImage

interface MyReviewRepository {
    fun getMyReview(reviewId: Int): LiveData<ReviewAndImage?>
    fun getUploadedPicture(reviewId: Int): LiveData<List<ReviewImage>>
    fun userId(): Int
    suspend fun userId1(): Int
    suspend fun uploadReview(review: ReviewAndImage)
    suspend fun modifyReview(review: ReviewAndImage)
    suspend fun modifyReview(review: ModifyFeedData)
    suspend fun getRestaurant(restaurantId: Int): RestaurantData? // 식당 ID로 식당 정보 가져오기
}