package com.example.torang_core.data.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SearchDao {
    @Query("SELECT * FROM search")
    fun getHistoryKeywords(): LiveData<List<Search>>

    @Insert
    suspend fun insertAll(vararg searches: Search?)

    @Delete
    suspend fun delete(search: Search?)
}