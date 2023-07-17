package com.example.load_image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageLoadTask extends AsyncTask<String,Void, Bitmap> {
    private ImageLoadListener listener;

    public ImageLoadTask(ImageLoadListener listener) {
        this.listener = listener;
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        String imageUrl = strings[0];
        Bitmap bitmap = null;
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            bitmap = BitmapFactory.decodeStream(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }


    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if (bitmap != null) {
            listener.onImageLoaded(bitmap);
        } else {
            listener.onImageLoadFailed("Failed to load image");
        }
    }
}
