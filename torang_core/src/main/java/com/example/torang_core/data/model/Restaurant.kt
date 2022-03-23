package com.example.torang_core.data.model

import java.util.*

/**
 *
 */
class Restaurant
/**
 * Default constructor
 */
    : BaseDataModel() {
    var restaurant_id = 0
    var restaurant_name: String = ""
    var address: String? = null
    var lat = 0.0
    var lon = 0.0
    var rating = 0f
    var tel: String? = null
    var prices: Prices = Prices.AROUND_10K
    var restaurant_type: RestaurantType = RestaurantType.KOREAN
    var region_code = 0
    var review_count = 0
    var site: String? = null
    var website: String? = null
    var img_url1: String? = null
    var img_url2: String? = null
    var img_url3: String? = null
    var img_url4: String? = null
    var img_url5: String? = null
    var img_url6: String? = null
    var pictureList: ArrayList<Picture>? = null
    fun distance(): String {
        return "100m"
    }
}