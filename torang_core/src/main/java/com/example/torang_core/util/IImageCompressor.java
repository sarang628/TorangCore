package com.example.torang_core.util;

import java.io.File;
import java.util.ArrayList;

public interface IImageCompressor {
    interface OnCompressedListener{
        void onCompressed(ArrayList<File> pathes);
    }
    void compress(ArrayList<String> selectedImagePath, OnCompressedListener onCompressedListener);
}
