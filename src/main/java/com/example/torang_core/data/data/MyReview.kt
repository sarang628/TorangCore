package com.example.torang_core.data.data

data class MyReview(
    val review_id: Int,
    val reviewImageUrl: String? = null,
    val rating: Float,
    val contents: String? = null,
    val uploadDate: String? = null
)
