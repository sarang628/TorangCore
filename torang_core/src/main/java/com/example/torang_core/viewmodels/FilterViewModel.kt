package com.example.torang_core.viewmodels

import android.text.TextUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.torang_core.data.model.*
import com.example.torang_core.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FilterViewModel @Inject constructor() : ViewModel() {
    val food = MutableLiveData<String>()
    val ratings = MutableLiveData<String>()

    /** 거리 필터 */
    val selectedDistances = MutableLiveData<Distances>()

    /** 가격 필터 */
    val selectedPrice = MutableLiveData<Prices>()

    /** 음식종류 필터 */
    val selectedFoods = MutableLiveData<ArrayList<RestaurantType>>()

    /** 평점필터 */
    val selectedRatings = MutableLiveData<ArrayList<Ratings>>()

    /** 거리 필터 클릭 */
    private val _clickDistance = MutableLiveData<Event<Unit>>()
    val clickDistance: LiveData<Event<Unit>> = _clickDistance

    /** 가격 필터 클릭 */
    private val _clickPrice = MutableLiveData<Event<Unit>>()
    val clickPrice: LiveData<Event<Unit>> = _clickPrice

    /** 평점 필터 클릭 */
    private val _clickRating = MutableLiveData<Event<Unit>>()
    val clickRating: LiveData<Event<Unit>> = _clickRating

    /** 음식 필터 클릭 */
    private val _clickFood = MutableLiveData<Event<Unit>>()
    val clickFood: LiveData<Event<Unit>> = _clickFood

    /** 재검색 클릭 */
    private val _clickSearch = MutableLiveData<Event<Unit>>()
    val clickSearch: LiveData<Event<Unit>> = _clickSearch

    /** 이 지역 클릭 */
    private val _clickThisArea = MutableLiveData<Event<Unit>>()
    val clickThisArea: LiveData<Event<Unit>> = _clickThisArea

    /** 내 위치 */
    var latitudeMyLocation: Double = 0.0
    var longitudeMyLocation: Double = 0.0

    /** 이 지역 위치 */
    var latitudeNorthWest: Double = 0.0
    var longitudeNorthWest: Double = 0.0
    var latitudeSouthEast: Double = 0.0
    var longitudeSouthEast: Double = 0.0

    private val isShow = MutableLiveData<Boolean>()

    fun setFood(food: RestaurantType) {
        val foodsArrayList = selectedFoods.value!!
        if (foodsArrayList.contains(food)) {
            foodsArrayList.remove(food)
        } else {
            foodsArrayList.add(food)
        }
        val arr = ArrayList<String?>()
        for (foods in foodsArrayList) {
            arr.add(foods.toName)
        }
        selectedFoods.value = foodsArrayList
        this.food.value = if (selectedFoods.value!!.size == 0) "음식종류" else TextUtils.join(",", arr)
    }

    fun setSelectedPrice(price: Prices) {
        if (selectedPrice.value == price) selectedPrice.setValue(Prices.NONE) else selectedPrice.setValue(
            price
        )
    }

    fun setSelectRatings(ratings: Ratings) {
        val ratingsArrayList = selectedRatings.value!!
        if (ratingsArrayList.contains(ratings)) {
            ratingsArrayList.remove(ratings)
        } else {
            ratingsArrayList.add(ratings)
        }
        val arr = ArrayList<String?>()
        for (rating in ratingsArrayList) {
            arr.add(rating.toName)
        }
        selectedRatings.value = ratingsArrayList
        this.ratings.value = if (ratingsArrayList.size == 0) "평점" else TextUtils.join(",", arr)
    }

    fun setSelectedDistances(distances: Distances) {
        if (selectedDistances.value == distances) selectedDistances.setValue(Distances.NONE) else selectedDistances.setValue(
            distances
        )
    }

    val filter: Filter
        get() {
            val filter = Filter()
            filter.distances = selectedDistances.value!!
            filter.prices = selectedPrice.value!!
            filter.restaurantTypes = selectedFoods.value!!
            filter.ratings = selectedRatings.value!!
            return filter
        }

    init {
        food.value = "음식종류"
        ratings.value = "평점"
        selectedPrice.value = Prices.NONE
        selectedDistances.value = Distances.NONE
        selectedRatings.value = ArrayList()
        selectedFoods.value = ArrayList()
        isShow.value = false
    }

    fun clickDistance() {
        _clickDistance.value = Event(Unit)
    }

    fun clickFood() {
        _clickFood.value = Event(Unit)
    }

    fun clickPrice() {
        _clickPrice.value = Event(Unit)
    }

    fun clickRating() {
        _clickRating.value = Event(Unit)
    }

    fun clickSearch() {
        _clickSearch.value = Event(Unit)
    }

    fun clickThisArea() {
        _clickThisArea.value = Event(Unit)
    }

}