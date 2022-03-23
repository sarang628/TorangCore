package com.example.torang_core.util;

import android.app.Application;

public class TorangApplication extends Application {
    private int userId = -1;

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
