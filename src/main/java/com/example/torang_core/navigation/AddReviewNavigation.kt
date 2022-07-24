package com.example.torang_core.navigation

import android.content.Context

interface AddReviewNavigation {
    fun go(context: Context, restaurantId: Int? = -1, reviewId: Int = -1)
}