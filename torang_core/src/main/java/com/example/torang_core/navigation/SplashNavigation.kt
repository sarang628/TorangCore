package com.example.torang_core.navigation

interface SplashNavigation : LoginNavigation, MainNavigation {
    interface OnRegisteredFingerPringListener {
        fun onRegistered()
    }
    fun registerDeviceFingerPrint(onRegisteredFingerPringListener: OnRegisteredFingerPringListener?)
    val isLogin: Boolean
}