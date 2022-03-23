package com.example.torang_core.navigation

import android.content.Context
import com.example.torang_core.data.model.Feed
import com.example.torang_core.dialog.FeedDialogEventAdapter
import com.example.torang_core.dialog.FeedMyDialogEventAdapter
import com.example.torang_core.dialog.NotLoggedInFeedDialogEventAdapter

interface MenuBottomSheetNavigation {
    fun show(context: Context, dialogEventAdapter: FeedDialogEventAdapter, feed : Feed)
    fun dismiss()
}

interface MyMenuBottomSheetNavigation {
    fun show(context: Context, myDialogEventAdapter: FeedMyDialogEventAdapter, feed : Feed)
    fun dismiss()
}

interface NotLoggedInMenuBottomSheetNavigation {
    fun show(context: Context, myDialogEventAdapter: NotLoggedInFeedDialogEventAdapter, feed : Feed)
    fun dismiss()
}