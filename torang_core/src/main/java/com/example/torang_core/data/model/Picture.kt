package com.example.torang_core.data.model

/**
 *
 */
class Picture(
    /**
     *
     */
    var picture_url: String = ""
) : BaseDataModel() {
    var picture_id = 0

    /**
     *
     */
    var restaurant_id = 0

    /**
     *
     */
    var user_id = 0

    /**
     *
     */
    var create_date: String = ""

    /**
     *
     */
    var review_id = 0
    var menu_id = 0
    fun getPictureUrl(): String {
        var url: String = picture_url as String
        if (!url.contains("http")) {
            url = "http://sarang628.iptime.org:91/review_images/$url"
        }
        return url
    }

    fun setPictureUrl(picture_url: String) {
        this.picture_url = picture_url
    }

    var menu: Menu? = null
}