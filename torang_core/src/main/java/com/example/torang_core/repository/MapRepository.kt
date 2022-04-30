package com.example.torang_core.repository

import androidx.lifecycle.LiveData
import com.example.torang_core.data.model.RestaurantData
import kotlinx.coroutines.flow.Flow

interface MapRepository {
    fun getRestaurant(): LiveData<List<RestaurantData>>
    suspend fun loadRestaurant()
    fun getClickMap(): Flow<Boolean>
    suspend fun clickMap()
    fun setNorthEastLatitude(latitude: Double)
    fun setNorthEastLongitude(longitude: Double)
    fun setSouthWestLatitude(latitude: Double)
    fun setSouthWestLongitude(longitude: Double)

    fun getNorthEastLatitude(): Double
    fun getNorthEastLongitude(): Double
    fun getSouthWestLatitude(): Double
    fun getSouthWestLongitude(): Double
}