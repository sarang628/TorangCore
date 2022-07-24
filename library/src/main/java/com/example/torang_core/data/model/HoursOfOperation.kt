package com.example.torang_core.data.model

/**
 *
 */
class HoursOfOperation : BaseDataModel() {
    var restaurant_id = 0
    var start_time: String? = null
    var end_time: String? = null
    var day: DAYS? = null
    fun operatingHour(): String {
        return "$start_time-$end_time"
    }
}