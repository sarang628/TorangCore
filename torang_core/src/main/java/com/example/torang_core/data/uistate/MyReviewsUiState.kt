package com.example.torang_core.data.uistate

import com.example.torang_core.data.data.MyReview

data class MyReviewUiState(
    val isLogin: Boolean? = null,
    val isLoading: Boolean = false,
    val list: List<MyReview>? = null,
    val isfirstLoading: Boolean = false
)

val MyReviewUiState.isEmpty: Boolean get() = (list != null && list.isEmpty())
val MyReviewUiState.isScreenLoading: Boolean get() = (isLogin == null && list == null)
val MyReviewUiState.firstLoadingDate: Boolean get() = (!isfirstLoading && isLogin == true && list == null)
//첫진입 시 로그인 상태이고 리스트가 비어있을 때 데이터 가져오기 필요