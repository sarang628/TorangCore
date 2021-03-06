package com.example.torang_core.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ReviewImage(
    @PrimaryKey val picture_id: Int,
    val restaurant_id: Int,
    val user_id: Int,
    val review_id: Int,
    val picture_url: String,
    val create_date: String,
    val menu_id: Int,
    val menu: Int
) {
    fun getPictureUrl(){

    }
    companion object {
        fun Picture.toReviewImage(): ReviewImage {
            return ReviewImage(
                picture_id = this.picture_id,
                restaurant_id = this.restaurant_id,
                user_id = this.user_id,
                review_id = this.review_id,
                picture_url = this.picture_url,
                create_date = this.create_date,
                menu_id = this.menu_id,
                menu = 1
            )
        }

        fun parse(picture: Picture): ReviewImage {
            return ReviewImage(
                picture_id = picture.picture_id,
                restaurant_id = picture.restaurant_id,
                review_id = picture.review_id,
                picture_url = picture.picture_url,
                create_date = picture.create_date,
                menu_id = picture.menu_id,
                menu = 0,
                user_id = picture.user_id
            )
        }

        fun uploadParam(path: String): ReviewImage {
            return ReviewImage(
                picture_id = -1,
                restaurant_id = -1,
                review_id = -1,
                picture_url = path,
                create_date = "",
                menu_id = -1,
                menu = 0,
                user_id = -1
            )
        }
    }
}