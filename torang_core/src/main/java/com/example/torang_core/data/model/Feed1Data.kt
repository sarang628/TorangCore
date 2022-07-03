package com.example.torang_core.data.model

import androidx.room.Embedded
import androidx.room.Relation

data class Feed1Data(
    @Embedded val feedData: FeedData,
    @Relation(
        parentColumn = "user_id",
        entityColumn = "userId"
    )
    val user: UserData?,
    @Relation(
        parentColumn = "review_id",
        entityColumn = "review_id"
    )
    val like: Like?,
    @Relation(
        parentColumn = "review_id",
        entityColumn = "review_id"
    )
    val favorite: Favorite?,
    @Relation(
        parentColumn = "review_id",
        entityColumn = "review_id"
    )
    val images: List<ReviewImage>? = null,
    @Relation(
        parentColumn = "restaurant_id",
        entityColumn = "restaurant_id"
    )
    val restaurantData: RestaurantData?,
)
