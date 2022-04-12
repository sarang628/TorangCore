package com.example.torang_core.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.torang_core.data.model.LoggedInUserData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

@Dao
interface LoggedInUserDao {
    @Query("select * from LoggedInUserData")
    fun getLoggedInUserData(): LiveData<LoggedInUserData?>

    @Query("select * from LoggedInUserData")
    suspend fun getLoggedInUserData1(): LoggedInUserData?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: LoggedInUserData)

    @Query("update LoggedInUserData set userName = :name ,profile_pic_url = :url  where constId = 1")
    suspend fun update(name: String, url: String)

    @Query("delete from LoggedInUserData where constId = 1")
    suspend fun clear()

    @Query("select COUNT(*) from LoggedInUserData")
    fun isLpogin(): Flow<Int>
}