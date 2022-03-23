package com.example.torang_core.util

import android.content.Context
import android.location.Location

interface ITorangLocationManager {
    fun init(context: Context)

    fun requestLocation()
    fun getLastLatitude() : Double
    fun getLastLongitude() : Double
    fun setOnPermissionListener(callback: (Int) -> Unit)
    fun setOnLocationListener(callback: (Location) -> Unit)

}