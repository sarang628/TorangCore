package com.example.torang_core.repository

import androidx.lifecycle.LiveData
import com.example.torang_core.data.model.Picture
import com.example.torang_core.data.model.ReviewImage

interface PicturesRepository {
    suspend fun getPictures(restaurantId: Int): ArrayList<Picture>
    fun getFeedPicture(reviewId: Int): LiveData<List<ReviewImage>>
}