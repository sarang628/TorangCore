package com.example.torang_core.data

interface LocationPreferences {
    suspend fun isFirstRequestLocationPermission(): Boolean

    fun requestLocationPermission()
}