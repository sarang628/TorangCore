package com.example.torang_core.api;

public interface LoginInterface {
    interface OnFacebookLoginListener {
        void onFacebookLogin(String token);
    }

    void requestFacebookLogin(OnFacebookLoginListener onFacebookLoginListener);
}
