package com.example.torang_core.data.model

/**
 *
 */
enum class RestaurantType {
    NONE, KOREAN, JAPANESE, CHINESE, FOREIGN, DRINK, CAFE;

    val toName: String
        get() {
            return when (this) {
                KOREAN -> "한식"
                CAFE -> "카페"
                DRINK -> "주점"
                CHINESE -> "중식"
                FOREIGN -> "양식"
                JAPANESE -> "일식"
                NONE -> ""
            }
        }
}

object RestaurantTypeObject {
    fun toName(restaurantType: RestaurantType?): String {
        return restaurantType?.toName ?: ""
    }
}