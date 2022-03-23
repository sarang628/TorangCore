package com.example.torang_core.repository

import com.example.torang_core.data.model.Filter
import com.example.torang_core.data.model.RestaurantData

interface MapSharedRepository {
    suspend fun searchRestaurant(latitude: Double, longitude: Double): List<RestaurantData>
    suspend fun searchRestaurant(keyword: String): List<RestaurantData>
    suspend fun getFilterRestaurant(filter: Filter): List<RestaurantData>
}