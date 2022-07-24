package com.example.torang_core.data.remote

data class RemoteFeed(
    val name: String,
    val reviewId: Int,
    val restaurantName: String,
    val rating: Float,
    val profilePictureUrl: String,
    val reviewImages: ArrayList<String>
)