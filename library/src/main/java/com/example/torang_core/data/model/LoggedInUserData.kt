package com.example.torang_core.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LoggedInUserData(
    @PrimaryKey val constId: Int = 1,
    @ColumnInfo val userId: Int,
    @ColumnInfo(name = "userName") val userName: String? = null,
    @ColumnInfo(name = "email") val email: String? = null,
    @ColumnInfo(name = "login_platform") val loginPlatform: String? = null,
    @ColumnInfo(name = "create_date") val create_date: String? = null,
    @ColumnInfo(name = "access_token") val access_token: String? = null,
    @ColumnInfo(name = "profile_pic_url") val profile_pic_url: String? = null,
    @ColumnInfo(name = "point") val point: String? = null,
    @ColumnInfo(name = "review_count") val review_count: String? = null,
    @ColumnInfo(name = "followers") val followers: String? = null,
    @ColumnInfo(name = "following") val following: String? = null
) {
    override fun equals(other: Any?): Boolean {
        if (other is LoggedInUserData) {
            return userId == other.userId
        }
        return super.equals(other)
    }

    companion object {
        fun parse(user: User?): LoggedInUserData? {
            if (user == null)
                return null

            return LoggedInUserData(
                userId = user.userId,
                email = user.email,
                userName = user.userName,
                loginPlatform = user.login_platform,
                create_date = user.create_date,
                access_token = user.access_token,
                profile_pic_url = user.profile_pic_url,
                point = user.point,
                review_count = user.review_count.toString(),
                followers = user.followers.toString(),
                following = user.following.toString()
            )
        }
    }

    fun toUserData(): UserData {
        return UserData(
            userId = userId!!,
            email = email,
            userName = userName,
            loginPlatform = loginPlatform,
            create_date = create_date,
            access_token = access_token,
            profile_pic_url = profile_pic_url,
            point = point,
            review_count = review_count,
            followers = followers,
            following = following
        )
    }
}