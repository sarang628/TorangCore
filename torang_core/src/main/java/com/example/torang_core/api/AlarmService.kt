package com.example.torang_core.api

import com.example.torang_core.data.model.User

interface AlarmService {
    suspend fun getMyAlarms(user: User)
}