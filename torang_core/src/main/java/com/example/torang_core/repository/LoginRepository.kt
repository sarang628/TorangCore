package com.example.torang_core.repository

import com.example.torang_core.data.model.User

interface LoginRepository : SessionRepository {
    suspend fun isLogin(): Boolean
    suspend fun facebookLogin(token: String): User?
}