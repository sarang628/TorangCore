package com.example.torang_core.repository

import androidx.lifecycle.LiveData
import com.example.torang_core.data.model.RestaurantData

interface MapRepository {
    fun getRestaurant(): LiveData<List<RestaurantData>>
    suspend fun loadRestaurant()
}