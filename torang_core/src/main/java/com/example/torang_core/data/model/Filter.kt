package com.example.torang_core.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

enum class SearchType {
    AROUND, BOUND
}

data class Filter(
    var searchType: SearchType = SearchType.AROUND,
    var keyword: String? = null,
    var distances: Distances = Distances.NONE,
    var prices: Prices = Prices.NONE,
    var restaurantTypes: ArrayList<RestaurantType> = ArrayList<RestaurantType>(),
    var ratings: ArrayList<Ratings> = ArrayList<Ratings>(),
    var lat: Double = 0.0,
    var lon: Double = 0.0,
    @SerializedName("north")
    var northEastLongitude: Double = 0.0,

    @SerializedName("east")
    var northEastLatitude: Double = 0.0,

    @SerializedName("south")
    var southWestLongitude: Double = 0.0,

    @SerializedName("west")
    var southWestLatitude: Double = 0.0
)