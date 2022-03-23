package com.example.torang_core.repository

import com.example.torang_core.data.model.Menu

/**
 * 메뉴 저장소 인터페이스
 */
interface MenuRepository {
    suspend fun getMenus(restaurantId : Int) : ArrayList<Menu>
}