package com.example.torang_core.repository

import androidx.lifecycle.LiveData
import com.example.torang_core.data.model.Alarm
import com.example.torang_core.data.model.LoggedInUserData

interface AlarmRepository : LoginCheckableRepository {
    suspend fun loadAlarm(): ArrayList<Alarm>

    suspend fun deleteAlarm()

    fun user() : LiveData<LoggedInUserData?>

    suspend fun testLogout()
}