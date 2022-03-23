package com.example.torang_core.repository

import com.example.torang_core.data.NationItem
import com.example.torang_core.data.model.Restaurant

interface NationRepository : MapSharedRepository {
    suspend fun getNationItems(): List<NationItem>

    suspend fun findRestaurant() : List<Restaurant>
}