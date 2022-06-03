package com.example.torang_core.repository

import com.example.torang_core.data.model.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface FindRepository {
    /** 맛집 검색 */
    suspend fun searchRestaurant(distances: Distances? = null, restaurantType: ArrayList<RestaurantType>? = null, prices: Prices? = null, ratings: ArrayList<Ratings>? = null, latitude: Double = 0.0, longitude: Double = 0.0, northEastLatitude: Double = 0.0, northEastLongitude: Double = 0.0, southWestLatitude: Double = 0.0, southWestLongitude: Double = 0.0, searchType: SearchType)
    /** 상태를 가져오고 뷰에서 위치 요청을 했다면 요청했다고 저장소에 알려주기 */
    suspend fun notifyRequestLocation(): RequestLocationResult
    /** 위치를 받아왔을때 알려줘야함 */
    suspend fun notifyReceiveLocation()
    /** 이 지역 검색 요청 */
    suspend fun searchBoundRestaurant()
    /** 현재 포커스된 레스토랑의 위치 값 */
    suspend fun setCurrentPosition(position: Int)
    /** 위치원한 요청에 대한 사용자 응답 */
    suspend fun requestLocationPermission(b: Boolean)
    /** */
    suspend fun permissionGranated()
    /** 맵 클릭 시 맛집카드, 필터 보여지는 기능과 관련되어 추가 */
    suspend fun clickMap()
    /** */
    suspend fun searchIfRestaurantEmpty()

    /** 검색 된 맛집 */
    fun getSearchedRestaurant(): Flow<List<Restaurant>>
    /** 최초위치요청 상태 가져오기 */
    fun getIsFirstRequestLocation(): StateFlow<Boolean>
    /** 현재 위치를 요청중인지 */
    fun isRequestingLocation(): StateFlow<Boolean>
    /** 검색 요청 트리거 */
    fun getSearchBoundRestaurnatTrigger(): StateFlow<Boolean>
    /** 현재 포커스된 맛집 위치 */
    fun getCurrentPosition(): StateFlow<Int>
    /** 권한 소유 여부 */
    fun hasGrantPermission(): MutableStateFlow<Int>
    /** 맛집카드, 필터 보여지는 여부 */
    fun showRestaurantCardAndFilter(): Flow<Boolean>
}

enum class RequestLocationResult {
    NEED_LOCATION_PERMISSION, // 처음 요청 시 위치 권한 필요 팝업이 필요할 시
    PERMISSION_DENIED, // 처음 권한 알림팝업을 취소하거나 위치권한을 거부했을 경우
    GPS_OFF, // GPS가 꺼져있음
    SUCCESS // 위치 권한을 얻었을 때
}