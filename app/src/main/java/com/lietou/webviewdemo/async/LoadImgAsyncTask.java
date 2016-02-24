package com.lietou.webviewdemo.async;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 项目名称：WebViewDemo
 * 类描述：
 * 创建人：ZuoWenBin
 * 创建时间：2016/2/23 14:02
 * 修改人：Administrator
 * 修改时间：2016/2/23 14:02
 * 修改备注：
 */
public class LoadImgAsyncTask extends AsyncTask<String , Void , Bitmap> {

    private ImageView imageView;

    public LoadImgAsyncTask(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        URL imgUrl = null;
        Bitmap bmp = null;
        InputStream is = null;
        try {
            imgUrl = new URL(params[0]);
            HttpURLConnection connection = (HttpURLConnection) imgUrl.openConnection();
            connection.setDoOutput(true);
            connection.connect();
            is = connection.getInputStream();
            bmp = BitmapFactory.decodeStream(is);
            is.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bmp;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
    }
}
