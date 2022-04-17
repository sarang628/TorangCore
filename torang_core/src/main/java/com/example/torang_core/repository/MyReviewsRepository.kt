package com.example.torang_core.repository

import androidx.lifecycle.LiveData
import com.example.torang_core.data.data.ReviewAndImage
import com.example.torang_core.data.uistate.MyReviewItemUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

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
}