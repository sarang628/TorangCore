package com.example.torang_core.data.model

import java.util.*

class MenuReview : BaseDataModel() {
    var menu_review_id = 0
    var contents: String? = null
    var rating = 0f
    var create_date: String? = null
    var user: User? = null
    var menu_id = 0
    var review_id = 0
    var pictures: ArrayList<Picture>? = null
}