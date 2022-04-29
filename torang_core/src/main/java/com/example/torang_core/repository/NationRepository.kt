package com.example.torang_core.repository

import com.example.torang_core.data.NationItem
import com.example.torang_core.data.model.Restaurant
import kotlinx.coroutines.flow.Flow

interface NationRepository : MapSharedRepository {
    suspend fun getNationItems(): List<NationItem>
    suspend fun findRestaurant(): List<Restaurant>
    fun getSelectNationItem(): Flow<NationItem>
    suspend fun selectNationItem(nationItem: NationItem)
}