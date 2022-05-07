package com.example.torang_core.repository

import com.example.torang_core.data.model.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface FindRepository {
    /** 검색 된 맛집 */
    fun getSearchedRestaurant(): Flow<List<Restaurant>>

    /** 맛집 검색 */
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
        searchType: SearchType
    )

    // 최초위치요청 상태 가져오기
    fun getIsFirstRequestLocation(): StateFlow<Boolean>

    // 상태를 가져오고 뷰에서 위치 요청을 했다면 요청했다고 저장소에 알려주기
    suspend fun notifyRequestLocation()

    // 현재 위치를 요청중인지
    fun isRequestingLocation(): StateFlow<Boolean>

    // 위치를 받아왔을때 알려줘야함
    suspend fun notifyReceiveLocation()

    // 이 지역 검색 요청
    suspend fun searchBoundRestaurant()

    /** 검색 요청 트리거 */
    fun getSearchBoundRestaurnatTrigger(): StateFlow<Boolean>

    /** 현재 포커스된 레스토랑의 위치 값 */
    suspend fun setCurrentPosition(position: Int)
    fun getCurrentPosition(): StateFlow<Int>
}