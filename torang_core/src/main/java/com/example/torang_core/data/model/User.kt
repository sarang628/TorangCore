package com.example.torang_core.data.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

/**
 *
 */
class User : BaseDataModel() {
    /**
     * Default constructor
     */
    /** */
    @SerializedName("user_id")
    var userId = -1

    /** */
    @SerializedName("user_name")
    var userName: String? = null

    /** */
    var email: String? = null

    /** */
    var login_platform: String? = null

    /** */
    var create_date: String? = null
    var access_token: String? = null
    var profile_pic_url: String? = null
    var point = "5050"
    var review_count = 0
    var followers = 0
    var following = 0
    var isFollow = false

    class Builder {
        var user = User()
        fun userId(userId: Int): Builder {
            user.userId = userId
            return this
        }

        fun userName(userName: String?): Builder {
            user.userName = userName
            return this
        }

        fun follower(follower: Int): Builder {
            user.followers = follower
            return this
        }

        fun profilePic(url: String?): Builder {
            user.profile_pic_url = url
            return this
        }

        fun build(): User {
            return user
        }
    }

    companion object {
        fun fromJson(s: String?): User {
            return Gson().fromJson(s, User::class.java)
        }

        val dummy: User
            get() = Builder()
                .userName("Sryang")
                .follower(10)
                .profilePic("https://pbs.twimg.com/profile_images/1186245554948296710/S9j_reWx_400x400.jpg")
                .build()

        fun listDummy(): ArrayList<User> {
            val users = ArrayList<User>()
            users.add(dummy)
            users.add(dummy)
            users.add(dummy)
            users.add(dummy)
            users.add(dummy)
            users.add(dummy)
            users.add(dummy)
            users.add(dummy)
            users.add(dummy)
            users.add(dummy)
            users.add(dummy)
            users.add(dummy)
            return users
        }
    }
}