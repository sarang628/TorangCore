package com.example.torang_core.repository

import androidx.lifecycle.LiveData
import com.example.torang_core.data.model.Alarm
import com.example.torang_core.data.model.LoggedInUserData

interface AlarmRepository : LoginCheckableRepository {
    suspend fun loadAlarm(): ArrayList<Alarm>

    suspend fun deleteAlarm()

    //사용자 로그인상태를 판단하는 데이터
    fun user() : LiveData<LoggedInUserData?>
}