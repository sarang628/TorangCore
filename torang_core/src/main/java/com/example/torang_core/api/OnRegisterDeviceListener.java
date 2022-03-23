package com.example.torang_core.api;

public interface OnRegisterDeviceListener {
    void onRegistered();

    void onFailed(String errMsg);
}
