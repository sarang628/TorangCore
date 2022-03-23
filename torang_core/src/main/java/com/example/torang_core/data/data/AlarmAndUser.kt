package com.example.torang_core.data.data

import androidx.room.Embedded
import androidx.room.Relation
import com.example.torang_core.data.model.AlarmData
import com.example.torang_core.data.model.UserData

data class AlarmAndUser(
    @Embedded val alarm: AlarmData,
    @Relation(
        parentColumn = "user_id",
        entityColumn = "userId"
    )
    val user: UserData?,
    @Relation(
        parentColumn = "other_user_id",
        entityColumn = "userId"
    )
    val another: UserData?

)