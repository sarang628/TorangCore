package com.example.torang_core.login

import android.app.Activity
import android.content.Intent
import com.example.torang_core.data.model.User

/**
 * 로그인 제공자가 갖춰야할 기능 인터페이스
 * 1. 로그인 요청
 * 2. 로그인 성공 시 사용자 정보요청
 * - 이메일, 사용자 이름, 사용자 프로필 이미지
 * 3. 현재 로그인 상태인지
 * 4. 로그아웃
 */
interface LoginProvider {
    /** 로그인 요청 */
    fun login(activity: Activity, onResultLoginListener: OnResultLoginListener)

    /** 현재 로그인 상태 */
    fun isLoggedIn(): Boolean

    /** 로그아웃 요청 */
    fun logout(onResultLogoutListener: OnResultLogoutListener)

    /** 유저 정보 요청 */
    fun requestUser(onReceiveUserListener: OnReceiveUserListener)

    fun onCreate()
    fun onDestory()
    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent)
}

interface FacebookLoginProvider : LoginProvider
interface KakaoLoginProvider : LoginProvider
interface GoogleLoginProvider : LoginProvider


//interface FaceBookLoginProviderForView : LoginProviderForView {
//
//}

//interface FaceBookLoginProviderForRepository : LoginProviderForRepository {
//
//}

interface LoginProviderForView {
    /**
     * 로그인 요청
     */
    fun login(activity: Activity, onResultLoginListener: OnResultLoginListener)

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent)

    fun onCreate()
    fun onDestory()
}

interface LoginProviderForRepository {
    /**
     * 유저 정보 요청
     */
    fun requestUser(onReceiveUserListener: OnReceiveUserListener)

    /**
     * 현재 로그인 상태
     *
     * @return
     */
    fun isLoggedIn(): Boolean

    /**
     * 로그아웃 요청
     *
     * @param onResultLogoutListener
     */
    fun logout(onResultLogoutListener: OnResultLogoutListener)
}

interface OnResultLoginListener {
    fun onResult(result: Int, user: User)
}

interface OnResultLogoutListener {
    fun onResult(result: Int)
}

interface OnReceiveUserListener {
    fun onReceive(user: User)
}

interface OnLoginResultListener {
    fun onResult(result: Int, resultMsg: String)
}