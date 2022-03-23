package com.example.torang_core.data.model

import com.example.torang_core.data.data.ReviewAndImage
import okhttp3.MediaType
import okhttp3.RequestBody
import java.util.HashMap

data class ModifyFeedData(
    val reviewAndImage: ReviewAndImage,
    val deleteImage: List<ReviewImage>?
) {
    fun toMap(): HashMap<String, RequestBody> {
        var body = reviewAndImage.toMap()

        deleteImage?.let {
            for (i in it.indices) {
                body["deleteImage$i"] = RequestBody.create(
                    MediaType.parse("text/plain"),
                    "" + deleteImage[i].picture_id
                )
            }
        }
        return body
    }
}