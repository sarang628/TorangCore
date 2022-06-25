package com.example.torang_core.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.torang_core.data.data.ReviewAndImage
import com.example.torang_core.data.model.*

@Dao
interface UserDao {
    @Query("SELECT * FROM userdata")
    fun getAll(): LiveData<List<UserData>>

    @Query("SELECT * FROM userdata WHERE userId IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<UserData>

    /*@Query("SELECT * FROM userdata WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): UserData*/

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<UserData>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserAndPictureAndLikeAndRestaurantAndFeed(
        users: List<UserData>,
        reviewImages: List<ReviewImage>,
        likes: List<Like>,
        restaurants: List<RestaurantData>,
        feedData: List<FeedData>,
        favorites: List<Favorite>,
    )

    @Transaction
    suspend fun deleteAllAndInsertAll(
        users: List<UserData>,
        reviewImages: List<ReviewImage>,
        likes: List<Like>,
        restaurants: List<RestaurantData>,
        feedData: List<FeedData>,
        favorites: List<Favorite>,
        deleteLikes: List<Like>,
    ) {
        deleteLikes(deleteLikes)
        deleteAll()
        insertUserAndPictureAndLikeAndRestaurantAndFeed(users,reviewImages, likes, restaurants,feedData, favorites)
    }

    @Delete
    suspend fun delete(user: UserData)

    @Query(
        """
            SELECT FeedData.*, userdata.profile_pic_url, userdata.userName, userdata.userId, RestaurantData.restaurant_name, RestaurantData.restaurant_id  
            FROM FeedData  
            JOIN userdata ON FeedData.user_id =  userdata.userId 
            LEFT OUTER JOIN RestaurantData ON FeedData.restaurant_id = restaurantdata.restaurant_id 
            ORDER BY create_date DESC
            """
    )
    fun getAllFeed(): LiveData<List<Feed>>

    @Query("""
        SELECT * 
        FROM FeedData 
        ORDER BY FeedData.create_date DESC
        """)
    fun getAllFeedAndImage(): LiveData<List<ReviewAndImage>>


    @Query("select * from FeedData where review_id = (:reviewId) order by FeedData.create_date desc")
    fun getFeed(reviewId: Int): LiveData<ReviewAndImage>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFeed(feedData: List<FeedData>)

    @Query("DELETE FROM FeedData where review_id = (:reviewId)")
    suspend fun deleteFeed(reviewId: Int)

    @Query("DELETE FROM FeedData")
    suspend fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPictures(reviewImages: List<ReviewImage>)

    @Query("DELETE FROM ReviewImage where review_id = (:reviewId)")
    suspend fun deletePicturesByReviewId(reviewId: Int)


    @Query("select * from ReviewImage where review_id = (:reviewId)")
    fun getReviewImages(reviewId: Int): LiveData<List<ReviewImage>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLikes(users: List<Like>)

    @Delete
    suspend fun deleteLike(like: Like)

    @Delete
    suspend fun deleteLikes(users: List<Like>)

    @Query("select * from `Like` where review_id = (:reviewId)")
    fun getLike(reviewId: Int): LiveData<Like>

    @Query("select * from `Like` where review_id = (:reviewId)")
    suspend fun getLike1(reviewId: Int): Like

    @Query("select count(*) from `like` where review_id = (:reviewId)")
    suspend fun hasLike(reviewId: Int): Int

    @Query("select * from userdata where userId = (:userId)")
    fun getUser(userId: Int): LiveData<UserData>

    @Query("select * from FeedData order by FeedData.create_date desc")
    fun getAllFeedWithUser(): LiveData<List<ReviewAndImage>>

    @Query("update UserData set userName = :userName ,profile_pic_url = :profilePicUrl  where userId = :userId")
    suspend fun update(userId: Int, userName: String, profilePicUrl: String)

    @Insert
    suspend fun insertLike(resultLike: Like)

    @Query("select count(*) from Favorite where review_id = (:reviewId)")
    suspend fun hasFavorite(reviewId: Int): Int


    @Delete
    suspend fun deleteFavorite(favorite: Favorite)

    @Query("select * from Favorite where review_id = (:reviewId)")
    suspend fun getFavorite1(reviewId: Int): Favorite

    @Insert
    suspend fun insertFavorite(favorite: Favorite)

    @Query("select * from Favorite where review_id = (:reviewId)")
    fun getFavorite(reviewId: Int): LiveData<Favorite>
}