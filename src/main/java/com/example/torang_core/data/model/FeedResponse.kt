package com.example.torang_core.data.model

class FeedResponse  //public Like like;
    : BaseDataModel() {
    var isFavority = false
    var review_id = -1
    var pictures: ArrayList<Picture>? = null
    var medias: ArrayList<AdMedia>? = null
    var restaurant: Restaurant? = null
    var user: User? = null

    //public ArrayList<Picture> pictures;
    //public ArrayList<AdMedia> medias;
    //public Restaurant restaurant;
    //public User user;
    var contents: String? = null
    var create_date: String? = null
    var rating = 0f
    var like: Like? = null
    var favorite: Favorite? = null
    val like_amount: Int = 0
    fun hasMedia(): Boolean {
        return false
    }
    val comment_amount: Int = 0

    fun toFeedData(): FeedData {
        return FeedData(
            review_id = review_id,
            userId = user!!.userId,
            is_favority = isFavority,
            contents = contents,
            create_date = create_date,
            rating = rating,
            restaurant_id = restaurant?.restaurant_id,
            like_amount = like_amount,
            comment_amount = comment_amount
        )
    }
}