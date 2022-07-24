package com.example.torang_core.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.torang_core.data.model.FeedData
import com.example.torang_core.data.model.RestaurantData
import com.example.torang_core.data.model.ReviewImage

@Dao
interface PictureDao {
    @Query("select * from ReviewImage Where review_id = :reviewId")
    fun getFeedImage(reviewId: Int): LiveData<List<ReviewImage>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(plantList: List<ReviewImage>)
}