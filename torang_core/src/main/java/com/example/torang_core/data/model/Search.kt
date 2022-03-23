package com.example.torang_core.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.*

@Entity(
    indices = arrayOf(
        Index(
            value = ["keyword"],
            unique = true
        )
    )
)
data class Search(
    @PrimaryKey
    val key: Long = System.currentTimeMillis(),
    @ColumnInfo(name = "keyword")
    var keyword: String,
    @ColumnInfo(name = "createDate")
    var createDate: String = key.toString()
) {
    override fun toString(): String {
        return keyword
    }

    fun getDate(): String {
        return SimpleDateFormat("M.dd").format(Date(key))
    }
}