package com.example.torang_core.data.model

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
    var north = 0.0
    var east = 0.0
    var south = 0.0
    var west = 0.0
}