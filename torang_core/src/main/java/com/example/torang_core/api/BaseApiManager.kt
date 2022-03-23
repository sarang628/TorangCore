package com.example.torang_core.api

import android.app.Activity
import com.example.torang_core.data.model.*
import java.io.File
import java.util.ArrayList

interface BaseApiManager {
    fun follow(
        userId: Int,
        userId1: Int,
        userBaseCallbackListener: BaseCallbackListener<User?>?
    )

    fun unfollow(
        userId: Int,
        userId1: Int,
        userBaseCallbackListener: BaseCallbackListener<User?>?
    )

    interface OnFileUploadProgressListener {
        fun OnProgress(file: File?, percentage: Float)
    }

    fun getReviews(
        restaurantId: Int,
        callbackListener: BaseCallbackListener<ArrayList<Review?>?>?
    )

    fun getPictures(
        value: Int,
        arrayListCallbackListener: BaseCallbackListener<ArrayList<Picture?>?>?
    )

    fun getHoursOfOperation(
        value: Int,
        arrayListCallbackListener: BaseCallbackListener<ArrayList<HoursOfOperation?>?>?
    )

    fun getMenus(
        value: Int,
        arrayListCallbackListener: BaseCallbackListener<ArrayList<Menu?>?>?
    )

    fun getRestaurant(
        value: Int,
        restaurantBodyCallbackListener: BaseCallbackListener<Restaurant?>?
    )

    fun fileUpload(
        activity: Activity?, reviewBody: Review?,
        reviewBodyCallbackListener: BaseCallbackListener<Review?>?,
        files: ArrayList<File?>?,
        onFileUploadProgressListener: OnFileUploadProgressListener?
    )

    fun addReview(
        reviewBody: Review?,
        reviewBodyCallbackListener: BaseCallbackListener<Review?>?
    )

    fun deletePicture(
        picture_id: Int,
        response_delete_picture: BaseCallbackListener<Void?>?
    )

    fun getMyReview(
        value: Int,
        value1: Int,
        reviewCallbackListener: BaseCallbackListener<Review?>?
    )

    fun getTimelines(callbackListener: BaseCallbackListener<ArrayList<Review?>?>?)
    fun saveMenu(
        pictureBody: Picture?,
        menuReview: MenuReview?,
        callbackListener: BaseCallbackListener<Void?>?
    )

    fun getFeeds(
        user_id: Int,
        callbackListener: BaseCallbackListener<ArrayList<FeedData?>?>?
    )

    fun addMenuReview(
        menuReview: MenuReview?,
        callbackListener: BaseCallbackListener<MenuReview?>?
    )

    fun getMyReviews(
        user_id: Int,
        restaurant_id: Int,
        reviewCallbackListener: BaseCallbackListener<ArrayList<Review?>?>?
    )

    fun getMyReviewsByUserId(
        user_id: Int,
        reviewCallbackListener: BaseCallbackListener<ArrayList<Review?>?>?
    )

    fun getMyMenuReviews(
        review: Review?,
        reviewCallbackListener: BaseCallbackListener<ArrayList<MenuReview?>?>?
    )

    fun getMenuReviews(
        menu_id: Int,
        callbackListener: BaseCallbackListener<ArrayList<MenuReview?>?>?
    )

    fun getFilterRestaurant(
        filter: Filter?,
        callbackListener: BaseCallbackListener<ArrayList<Restaurant?>?>?
    )

    fun facebookLogin(
        accessToken: String?,
        callbackListener: BaseCallbackListener<Response<User?>?>?
    )

    fun deleteReview(
        review: Review?,
        callbackListener: BaseCallbackListener<Review?>?
    )

    fun addComment(
        comment: Comment?,
        callbackListener: com.example.torang_core.api.BaseCallbackListener<Comment?>?
    )

    fun modifyComment(
        comment: Comment?,
        callbackListener: com.example.torang_core.api.BaseCallbackListener<Comment?>?
    )

    fun deleteComment(
        comment: Comment?,
        callbackListener: com.example.torang_core.api.BaseCallbackListener<Comment?>?
    )

    fun getComments(
        feed: FeedData?,
        callbackListener: com.example.torang_core.api.BaseCallbackListener<ArrayList<Comment?>?>?
    )

    fun addLike(
        like: Like?,
        callbackListener: com.example.torang_core.api.BaseCallbackListener<Like?>?
    )

    fun deleteLike(
        like: Like?,
        callbackListener: com.example.torang_core.api.BaseCallbackListener<Like?>?
    )

    fun getMyAlarms(
        user: User?,
        callbackListener: com.example.torang_core.api.BaseCallbackListener<ArrayList<Alarm?>?>?
    )

    fun getFollowers(
        user_id: Int,
        callbackListener: com.example.torang_core.api.BaseCallbackListener<ArrayList<User?>?>?
    )
}