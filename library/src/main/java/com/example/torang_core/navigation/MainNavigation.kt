package com.example.torang_core.navigation

import android.content.Context
import androidx.fragment.app.FragmentManager

interface MainNavigation {
    fun goMain(fragmentManager: FragmentManager?)

    fun goMain(context: Context)
}