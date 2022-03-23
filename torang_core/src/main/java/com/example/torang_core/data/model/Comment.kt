package com.example.torang_core.data.model

import com.google.gson.annotations.SerializedName

class Comment : BaseDataModel() {
    var comment_id = 0
    var review_id = 0
    var user: User? = null
    var comment: String? = null

    @SerializedName("create_date")
    var createDate: String? = null

    class Builder {
        var comment = Comment()
        fun user(user: User?): Builder {
            comment.user = user
            return this
        }

        fun comment(comment: String?): Builder {
            this.comment.comment = comment
            return this
        }

        fun createDate(createDate: String?): Builder {
            comment.createDate = createDate
            return this
        }

        fun build(): Comment {
            return comment
        }

        fun commentId(id: Int): Builder {
            comment.comment_id = id
            return this
        }
    }

    companion object {
        fun parse(list: List<CommentData>): ArrayList<Comment> {
            val commentList = ArrayList<Comment>()
            for (commentData in list) {
                commentList.add(parse(commentData = commentData))
            }
            return commentList
        }

        fun parse(commentData: CommentData): Comment {
            return Comment().apply {
                comment_id = commentData.commentId
                review_id = commentData.reviewId
                comment = commentData.comment
                user = User().apply {
                    userId = commentData.userId
                    userName = commentData.userName
                    profile_pic_url = commentData.profilePicUrl
                }
            }
        }
    }
}