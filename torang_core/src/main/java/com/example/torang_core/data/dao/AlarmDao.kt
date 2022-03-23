package com.example.torang_core.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.torang_core.data.data.AlarmAndUser
import com.example.torang_core.data.model.*

@Dao
interface AlarmDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAlarms(users: List<AlarmData>)

    @Query("select * from AlarmData order by AlarmData.create_date desc")
    fun getAllAlarmData(): LiveData<List<AlarmAndUser>>
}