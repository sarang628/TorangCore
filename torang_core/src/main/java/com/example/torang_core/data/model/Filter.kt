package com.example.torang_core.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

class Filter : BaseDataModel() {
    enum class SearchType {
        AROUND, BOUND
    }

    var searchType = SearchType.AROUND
    var keyword: String? = null
    var distances = Distances.NONE
    var prices: Prices = Prices.NONE
    var restaurantTypes = ArrayList<RestaurantType>()
    var ratings = ArrayList<Ratings>()
    var lat = 0.0
    var lon = 0.0
    @SerializedName("north")
    var northEastLongitude = 0.0
    @SerializedName("east")
    var northEastLatitude = 0.0
    @SerializedName("south")
    var southWestLongitude = 0.0
    @SerializedName("west")
    var southWestLatitude = 0.0
}