package com.wuxiaolong.androidutils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wuxiaolong.androidutils.library.BitmapCompressUtil;
import com.wuxiaolong.androidutils.library.LogUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new BitmapCompressUtil(MainActivity.this).bitmapCompress("/storage/sdcard0/dcim/Camera/IMG_20160518_083759.jpg", new BitmapCompressUtil.BitmapCompressCallback() {
            @Override
            public void onCompressSuccess(String absolutePath) {
                LogUtil.d("absolutePath=" + absolutePath);
            }

            @Override
            public void onCompressFailure(String t) {
                LogUtil.d("onCompressFailure=" + t);
            }
        });
    }
}
