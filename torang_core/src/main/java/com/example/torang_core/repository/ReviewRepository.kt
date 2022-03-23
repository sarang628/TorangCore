package com.example.torang_core.repository

import com.example.torang_core.data.model.Review

interface ReviewRepository {
    suspend fun getReviews(restaurantId: Int) : ArrayList<Review>
}