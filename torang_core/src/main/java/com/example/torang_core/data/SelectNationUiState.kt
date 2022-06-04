package com.example.torang_core.data

import androidx.annotation.DrawableRes
import com.example.torang_core.data.data.Location

data class NationLocation(val lat: Double, val lon: Double)

data class NationItem(
    @DrawableRes
    var res: Int = 0,
    var name: String = "",
    var nationLocation: NationLocation? = null,
    var nationBound: NationBound? = null
)

data class NationBound(
    val latitudeSouthWest: Double,
    val latitudeNorthEast: Double,
    val longitudeSouthWest: Double,
    val longitudeNorthEast: Double
)

fun NationLocation.location() : Location {
    return Location(lat, lon)
}