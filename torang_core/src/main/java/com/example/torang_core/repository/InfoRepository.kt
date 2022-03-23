package com.example.torang_core.repository

import com.example.torang_core.data.model.HoursOfOperation
import com.example.torang_core.data.model.Menu
import com.example.torang_core.data.model.Restaurant

interface InfoRepository {
    suspend fun loadRestaurant(restaurantId: Int): Restaurant
    suspend fun loadMenus(restaurantId: Int): ArrayList<Menu>
    suspend fun loadHours(restaurantId: Int): ArrayList<HoursOfOperation>
}