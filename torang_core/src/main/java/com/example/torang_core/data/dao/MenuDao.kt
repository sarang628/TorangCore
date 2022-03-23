package com.example.torang_core.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.torang_core.data.model.Menu

@Dao
interface MenuDao {
    @Query("SELECT * FROM Menu")
    fun getReviews(): LiveData<List<Menu>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<Menu>)
}