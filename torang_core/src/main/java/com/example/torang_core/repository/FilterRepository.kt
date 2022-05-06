package com.example.torang_core.repository

import com.example.torang_core.data.model.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface FilterRepository {
    fun getCurrentFilter(): StateFlow<Filter>
    suspend fun selectRestaurantTyoe(food: RestaurantType)
    suspend fun selectPrice(price: Prices)
    suspend fun selectRatings(ratings: Ratings)
    suspend fun selectDistance(distances: Distances)
    suspend fun getFilter(): Filter
}