package com.example.torang_core.repository

import androidx.lifecycle.LiveData
import com.example.torang_core.data.model.LoggedInUserData

interface SessionRepository {
    fun getLoginUser() : LiveData<LoggedInUserData?>
    suspend fun setLoggedInUser(loggedInUserData: LoggedInUserData)
}