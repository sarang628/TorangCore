package com.example.torang_core.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(indices = arrayOf(Index(value = ["like_id"],
        unique = true)))
data class Like (
        @PrimaryKey
        @ColumnInfo(name = "review_id")
        @SerializedName("review_id")
        var reviewId: Int = 0,
        var like_id: Int = 0,
        var user_id: Int = 0,
        var create_date: String? = null
) : BaseDataModel()