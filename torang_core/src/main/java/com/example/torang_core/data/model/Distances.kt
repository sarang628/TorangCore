package com.example.torang_core.data.model

/**
 *
 */
enum class Distances {
    NONE, _100M, _300M, _500M, _1KM, _3KM;

    val toName: String
        get() {
            return when (this) {
                NONE -> "반경"
                _100M -> "100M"
                _300M -> "300M"
                _500M -> "500M"
                _1KM -> "1KM"
                _3KM -> "3KM"
            }
        }
    val meter: Double
        get() {
            return when (this) {
                NONE -> 0.0
                _100M -> 100.0
                _300M -> 300.0
                _500M -> 500.0
                _1KM -> 1000.0
                _3KM -> 3000.0
            }
        }
}