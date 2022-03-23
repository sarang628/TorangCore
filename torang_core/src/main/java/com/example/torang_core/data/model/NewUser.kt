package com.example.torang_core.data.model

import java.net.MalformedURLException
import java.net.URL
import kotlin.jvm.Throws

/**
 * 모바일에서 사용할 User객체 서버쪽에서 전달하는 데이터와
 */
data class NewUser(
    val userId: Int,
    private val pictureUrl: String
){
    @Throws(MalformedURLException::class)
    fun getPictureUrl() : URL {
        return URL(pictureUrl)
    }
}