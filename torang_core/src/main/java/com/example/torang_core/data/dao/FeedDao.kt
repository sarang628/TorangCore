package com.example.torang_core.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.torang_core.data.model.Feed
import com.example.torang_core.data.model.Feed1Data
import com.example.torang_core.data.model.FeedData
import com.example.torang_core.data.model.Like
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

@Dao
interface FeedDao {
    @Query(
        """
        SELECT FeedData.*, userdata.profile_pic_url, userdata.userName, userdata.userId, RestaurantData.restaurant_name, RestaurantData.restaurant_id
        FROM FeedData 
        JOIN userdata ON FeedData.user_id =  userdata.userId
        LEFT OUTER JOIN RestaurantData ON FeedData.restaurant_id = restaurantdata.restaurant_id
        WHERE user_id = (:userId)
        ORDER BY create_date DESC
        """
    )
    fun getMyFeed(userId: Int): LiveData<List<Feed>>

    @Query(
        """
        SELECT FeedData.*, userdata.profile_pic_url, userdata.userName, userdata.userId, RestaurantData.restaurant_name, RestaurantData.restaurant_id
        FROM FeedData 
        JOIN userdata ON FeedData.user_id =  userdata.userId
        LEFT OUTER JOIN RestaurantData ON FeedData.restaurant_id = restaurantdata.restaurant_id
        WHERE review_id IN (Select review_id from Favorite where user_id = (:userId) )
        ORDER BY create_date DESC
        """
    )
    fun getMyFavorite(userId: Int): LiveData<List<Feed>>

    @Query("DELETE FROM FeedData where review_id = (:reviewId)")
    suspend fun deleteFeed(reviewId: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(plantList: List<FeedData>)

    @Query("""
       SELECT * FROM FeedData
    """)
    fun getFeed(): LiveData<List<Feed1Data>>

    @Query("""
       SELECT * FROM FeedData
    """)
    fun getFeed1(): Flow<List<Feed1Data>>
}