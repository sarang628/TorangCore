package com.example.torang_core.repository

import com.example.torang_core.data.model.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface FilterRepository {
    /** 현재 필터 상태 */
    fun getCurrentFilter(): StateFlow<Filter>
    /** 음식 종류 선택 */
    suspend fun selectRestaurantType(food: RestaurantType)
    /** 가격대 선택 */
    suspend fun selectPrice(price: Prices)
    /** 평점 선택 */
    suspend fun selectRatings(ratings: Ratings)
    /** 거리 선택 */
    suspend fun selectDistance(distances: Distances)
    /** 현재 필터 값 얻기 */
    suspend fun getFilter(): Filter
}