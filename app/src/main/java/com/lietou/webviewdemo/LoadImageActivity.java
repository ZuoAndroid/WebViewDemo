package com.lietou.webviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;
import com.lietou.webviewdemo.async.LoadImgAsyncTask;

/**
 * 项目名称：WebViewDemo
 * 类描述：
 * 创建人：ZuoWenBin
 * 创建时间：2016/2/23 13:55
 * 修改人：Administrator
 * 修改时间：2016/2/23 13:55
 * 修改备注：
 */
public class LoadImageActivity extends AppCompatActivity {

    public static final String ImgURL = "https://www.baidu.com/img/baidu_jgylogo3.gif";
    private ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load_img);
        imgView = ((ImageView) findViewById(R.id.img_id));
        findViewById(R.id.load_Btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LoadImgAsyncTask(imgView).execute(ImgURL);
            }
        });


    }
}
