package com.example.load_image;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements ImageLoadListener{
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String imageUrl ="https://vapa.vn/wp-content/uploads/2022/12/anh-3d-thien-nhien.jpeg";
        imageView = findViewById(R.id.imageView);
        ImageLoadTask imageLoadTask = new ImageLoadTask((ImageLoadListener) this);
        imageLoadTask.execute(imageUrl);

    }

    @Override
    public void onImageLoaded(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
    }

    @Override
    public void onImageLoadFailed(String errorMessage) {
        Log.e("image failed", errorMessage);
    }
}