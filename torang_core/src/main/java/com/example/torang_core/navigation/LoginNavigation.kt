package com.example.torang_core.navigation

import android.content.Context
import androidx.fragment.app.FragmentManager

interface LoginNavigation {
    fun goLogin(fragmentManager: FragmentManager?)
    fun goLogin(context: Context)
}