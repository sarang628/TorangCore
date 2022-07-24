package com.example.torang_core.dialog

import com.example.torang_core.data.model.Feed

interface FeedMyDialogEventAdapter {
    /* 다른 앱에 게시.. */
    fun postOtherApp(reviewId:Int)
    /* 보관 */
    fun store(reviewId:Int)
    /* 삭제 */
    fun delete(reviewId:Int)
    /* 수정 */
    fun modify(feed:Feed)
    /* 좋아요 수 숨기기 */
    fun hideLikeCount(reviewId:Int)
    /* 댓글 기능 해제 */
    fun lockReply(reviewId:Int)
    /* 신고 */
    fun report(reviewId: Int)
}

interface FeedDialogEventAdapter {
    /* 이 게시물이 포함되는 이유 */
    fun reasonContainThisPost(reviewId:Int)
    /* 숨기기 */
    fun hide(feed: Feed)
    /* 팔로우 취소 */
    fun unfollow(feed: Feed)
    /* 신고 */
    fun report1(reviewId: Int)
}

interface NotLoggedInFeedDialogEventAdapter {
    /* 신고 */
    fun report2(reviewId: Int)
}