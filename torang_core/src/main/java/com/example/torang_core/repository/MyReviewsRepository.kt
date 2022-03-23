package com.example.torang_core.repository

import androidx.lifecycle.LiveData
import com.example.torang_core.data.data.ReviewAndImage

interface MyReviewsRepository {
    suspend fun getMyReviews(restaurantId : Int): List<ReviewAndImage>

    fun getMyReviews1(restaurantId : Int): LiveData<List<ReviewAndImage>>
}