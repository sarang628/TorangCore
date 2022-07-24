package com.example.torang_core.data.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DeletedRestaurantDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllRestaurant(restaurants: ArrayList<RestaurantData>)

    @Query("select * from RestaurantData order by restaurant_name desc")
    fun getRestaurant(): LiveData<List<RestaurantData>>

    @Query("select * from RestaurantData order by restaurant_name desc")
    suspend fun getRestaurantDistance(): List<RestaurantData>


    @Query("select * from RestaurantData Where restaurant_id = (SELECT restaurant_id FROM ReviewData WHERE review_id = :reviewId)")
    fun getRestaurantByReviewId(reviewId: Int): LiveData<RestaurantData>
}