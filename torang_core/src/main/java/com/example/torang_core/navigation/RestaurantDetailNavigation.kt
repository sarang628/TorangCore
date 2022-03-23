package com.example.torang_core.navigation

import android.content.Context

interface RestaurantDetailNavigation {
    fun go(context: Context, restaurantId: Int)
}