package com.example.torang_core.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.torang_core.data.data.ReviewAndImage
import com.example.torang_core.data.model.*

@Dao
interface ReviewDao {
    @Query("SELECT * FROM feeddata")
    fun getReviews(): LiveData<List<Feed>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<ReviewData>)

    @Query("select * from FeedData where review_id = (:reviewId) order by FeedData.create_date desc")
    fun getFeedbyReviewId(reviewId: Int): LiveData<ReviewAndImage?>
}