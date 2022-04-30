package com.example.torang_core.repository

import com.example.torang_core.data.model.*
import kotlinx.coroutines.flow.Flow

interface FindRepository {
    fun getSearchedRestaurant(): Flow<List<Restaurant>>
    suspend fun searchRestaurant(distances: Distances? = null,
                                 restaurantType: ArrayList<RestaurantType>? = null,
                                 prices: Prices? = null,
                                 ratings: ArrayList<Ratings>? = null,
                                 latitude: Double = 0.0,
                                 longitude: Double = 0.0,
                                 northEastLatitude: Double = 0.0,
                                 northEastLongitude: Double = 0.0,
                                 southWestLatitude: Double = 0.0,
                                 southWestLongitude: Double = 0.0,
                                 searchType: Filter.SearchType)
}