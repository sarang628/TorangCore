package com.example.torang_core.navigation

import android.content.Context

interface WriteReviewNavigation {
    fun go(context: Context, reviewId: Int)
}