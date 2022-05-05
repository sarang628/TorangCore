package com.example.torang_core.repository

import com.example.torang_core.data.model.Filter
import com.example.torang_core.data.model.RestaurantType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface FilterRepository {
    fun getCurrentFilter(): StateFlow<Filter>
    suspend fun selectRestaurantTyoe(food: RestaurantType)
}