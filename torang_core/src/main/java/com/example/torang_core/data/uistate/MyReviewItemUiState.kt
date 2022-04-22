package com.example.torang_core.data.uistate

/**
 * 내가 쓴 리뷰 리스트가 있고 이 항목에서 필요한 데이터 입니다.
- 리뷰 한 이미지 대표화면
- 업로드한 날짜
- 평점
- 리뷰내용
- 리뷰id(수정 시 id로 상세조회 필요)
 */
data class MyReviewItemUiState(
    val review_id: Int,
    val reviewImageUrl: String? = null,
    val rating: Float,
    val contents: String? = null,
    val uploadDate: String? = null
)
