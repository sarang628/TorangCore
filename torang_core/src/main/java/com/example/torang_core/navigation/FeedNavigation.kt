package com.example.torang_core.navigation

import androidx.fragment.app.FragmentManager

interface FeedNavigation {
    fun go(fragmentManager: FragmentManager, container: Int)
}