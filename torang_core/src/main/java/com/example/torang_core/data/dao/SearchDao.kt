package com.example.torang_core.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.torang_core.data.model.Search

@Dao
interface SearchDao {
    @Query("SELECT * FROM search order by createDate desc")
    fun getHistoryKeywords(): LiveData<List<Search>>

    @Insert
    suspend fun insertAll(vararg searches: Search?)

    @Delete
    suspend fun delete(search: Search?)
}