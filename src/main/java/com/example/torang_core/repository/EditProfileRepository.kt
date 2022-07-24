package com.example.torang_core.repository

import androidx.lifecycle.LiveData
import com.example.torang_core.data.model.LoggedInUserData

/**
 * 프로필 수정 응답
 */
enum class EditProfileResponse {
    SUCCESS,
    NO_USER
}

interface EditProfileRepository {
    suspend fun editProfile(name: String?, profilePictureUrl: String?): EditProfileResponse
    fun getUser(): LiveData<LoggedInUserData?>
}