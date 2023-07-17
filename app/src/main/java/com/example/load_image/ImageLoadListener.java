package com.example.load_image;

import android.graphics.Bitmap;

public interface ImageLoadListener {
    void onImageLoaded(Bitmap bitmap);
    void onImageLoadFailed(String errorMessage);
}

