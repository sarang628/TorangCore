package com.example.torang_core.data.model

import android.text.TextUtils

/**
 *
 */
enum class Ratings {
    NONE, ONE, TWO, THREE, FOUR, FIVE;

    val toName: String
        get() {
            return when (this) {
                NONE -> "평점"
                ONE -> "1점대"
                TWO -> "2점대"
                THREE -> "3점대"
                FOUR -> "4점대"
                FIVE -> "5점대"
            }
        }

    override fun toString(): String {
        return toName
    }
}

val ArrayList<Ratings>.name: String
    get() = if (this.size == 0) "평점" else TextUtils.join(
        ",",
        this
    )