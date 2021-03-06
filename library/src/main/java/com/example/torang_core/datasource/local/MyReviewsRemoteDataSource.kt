package com.example.torang_core.datasource.local

import com.example.torang_core.data.model.ReviewImage

/**
 * 내 리뷰화면에서 필요한 원격 데이터
 * - 내 리뷰 데이터
 */
interface MyReviewsRemoteDataSource {
    suspend fun getMyReviews() : List<ReviewImage>
}