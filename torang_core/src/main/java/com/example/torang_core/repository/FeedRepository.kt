package com.example.torang_core.repository

interface FeedRepository : FeedListRepository {
    // 내 리뷰 삭제
    suspend fun deleteFeed(reviewId: Int)
}