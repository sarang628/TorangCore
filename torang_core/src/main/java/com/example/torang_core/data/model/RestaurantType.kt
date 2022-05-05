package com.example.torang_core.data.model

import android.text.TextUtils

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

    override fun toString(): String {
        return this.toName
    }
}

object RestaurantTypeObject {
    fun toName(restaurantType: RestaurantType?): String {
        return restaurantType?.toName ?: ""
    }
}

val ArrayList<RestaurantType>.name: String
    get() = if (this.size == 0) "음식종류" else TextUtils.join(
        ",",
        this
    )