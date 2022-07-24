package com.example.torang_core.navigation

import android.content.Context

interface PicturePageNavigation {
    fun go(context: Context, reviewId: Int, position: Int)
}