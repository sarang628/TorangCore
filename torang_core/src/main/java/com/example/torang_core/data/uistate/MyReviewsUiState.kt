package com.example.torang_core.data.uistate

import com.example.torang_core.data.data.MyReview

data class MyReviewUiState(
    val isLogin: Boolean = false,
    val isLoading: Boolean = false,
    val list: List<MyReview>? = null,
)

val MyReviewUiState.isEmpty: Boolean get() = (list != null && list.isEmpty())