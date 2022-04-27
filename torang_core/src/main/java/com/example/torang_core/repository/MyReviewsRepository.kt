package com.example.torang_core.repository

import androidx.lifecycle.LiveData
import com.example.torang_core.data.data.MyReview
import com.example.torang_core.data.data.ReviewAndImage
import kotlinx.coroutines.flow.Flow

interface MyReviewsRepository {
    @Deprecated("유물", ReplaceWith("getMyReviews2로 바꿔쓰세요", "import?"), DeprecationLevel.WARNING)
    suspend fun getMyReviews(restaurantId: Int): List<ReviewAndImage>

    @Deprecated(
        "유물",
        ReplaceWith("getMyReviews2로 바꿔쓰세요", "import?", "import??"),
        DeprecationLevel.WARNING
    )
    fun getMyReviews1(restaurantId: Int): LiveData<List<ReviewAndImage>>

    // 리뷰 제공 데이터 개선
    fun getMyReviews2(restaurantId: Int): Flow<List<MyReviewItemUiState>>

    // (2022-04-21) 원격 데이터소스와 로컬 데이터소스를 함께 사용해야할 때 Flow를 사용하기 어려움
    suspend fun getMyReviews3(restaurantId: Int): List<MyReview>
}