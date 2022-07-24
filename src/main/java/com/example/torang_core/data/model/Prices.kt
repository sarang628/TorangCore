package com.example.torang_core.data.model

/**
 *
 */
enum class Prices {
    NONE, UNDER_10K, AROUND_10K, AROUND_20K, AROUND_30K, OVER_30K;

    val toName: String
        get() {
            return when (this) {
                NONE -> "가격"
                UNDER_10K -> "만원미만"
                AROUND_10K -> "1만원대"
                AROUND_20K -> "2만원대"
                AROUND_30K -> "3만원대"
                OVER_30K -> "3만원이상"
            }
        }
}

object PriceObject {
    fun toName(prices: Prices?): String {
        return prices?.toName ?: ""
    }
}