package com.example.torang_core.repository

import com.example.torang_core.data.model.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface FindRepository {
    fun getSearchedRestaurant(): Flow<List<Restaurant>>
    suspend fun searchRestaurant(
        distances: Distances? = null,
        restaurantType: ArrayList<RestaurantType>? = null,
        prices: Prices? = null,
        ratings: ArrayList<Ratings>? = null,
        latitude: Double = 0.0,
        longitude: Double = 0.0,
        northEastLatitude: Double = 0.0,
        northEastLongitude: Double = 0.0,
        southWestLatitude: Double = 0.0,
        southWestLongitude: Double = 0.0,
        searchType: Filter.SearchType
    )

    // 최초위치요청 상태 가져오기
    fun getIsFirstRequestLocation(): StateFlow<Boolean>

    // 상태를 가져오고 뷰에서 위치 요청을 했다면 요청했다고 저장소에 알려주기
    suspend fun notifyRequestedLocation()

    fun isRequestingLocation(): StateFlow<Boolean>
    suspend fun onReceiveLocation()
}