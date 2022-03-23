package com.example.torang_core.repository

import androidx.lifecycle.LiveData
import com.example.torang_core.data.model.Search

interface SearchRepository {
    fun getHistoryKeywords(): LiveData<List<Search>>
    suspend fun saveHistory(keyword: String)
    suspend fun removeKeyword(search: Search)
}