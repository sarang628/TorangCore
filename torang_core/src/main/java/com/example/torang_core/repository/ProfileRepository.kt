package com.example.torang_core.repository

import androidx.lifecycle.LiveData
import com.example.torang_core.data.model.*

interface ProfileRepository : FeedListRepository {
    fun getMyProfile(): LiveData<LoggedInUserData?>
    fun loadProfile(userId: Int): LiveData<UserData>
    fun getMyFeed(userId: Int): LiveData<List<Feed>>
    fun getMyFavorite(userId: Int): LiveData<List<Feed>>
    suspend fun logout()
}