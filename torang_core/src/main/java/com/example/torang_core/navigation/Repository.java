package com.example.torang_core.navigation;

import com.example.torang_core.data.model.DeviceInfo;
import com.example.torang_core.api.OnRegisterDeviceListener;

public interface Repository {
    void registerDevice(DeviceInfo deviceInfo, OnRegisterDeviceListener onRegisterDeviceListener);
}
