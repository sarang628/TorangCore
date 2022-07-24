package com.example.torang_core.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *
 */
@Entity
class Menu {
    /**  */
    @PrimaryKey
    var menu_id: Int? = null

    /**  */
    var restaurant_id: String? = null

    /**  */
    var menu_name: String? = null

    /**  */
    var menu_price: String? = null

    /**  */
    var menu_pic_url: String? = null

    /**  */
    var rating = 0f
}