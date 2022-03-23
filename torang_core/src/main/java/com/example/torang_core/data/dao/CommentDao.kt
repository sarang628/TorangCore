package com.example.torang_core.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.torang_core.data.data.ReviewAndImage
import com.example.torang_core.data.model.*

@Dao
interface CommentDao {
    @Query(
        """
        SELECT *
        FROM CommentData
        WHERE reviewId = (:reviewId)
        ORDER BY createDate DESC
        """
    )
    fun getComments(reviewId: Int): LiveData<List<CommentData>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComments(list: List<CommentData>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComment(commentData: CommentData)
}