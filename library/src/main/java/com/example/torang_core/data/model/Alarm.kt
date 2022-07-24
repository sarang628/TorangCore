package com.example.torang_core.data.model

class Alarm : BaseDataModel() {
    var alarm_id = 0
    var user_id = 0
    var other_user_id = 0

    /*if (alarm_type != null) {
            switch (alarm_type) {
                case LIKE:
                    String userName = (otherUser != null && otherUser.userName != null) ? otherUser.userName : "";
                    String contents = String.format("%s님이 게시물에 좋아요를 눌렀습니다.", userName);
                    return contents;
                case FOLLOW:
                    return "";
                case COMMENT:
                    return "";
            }
        }*/
    var contents: String? = null
    var user: User? = null
    var otherUser: User? = null
    var alarm_type: AlarmType? = null
    var review_id = 0
    var create_date: String? = null
}