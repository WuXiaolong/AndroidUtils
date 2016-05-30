package com.wuxiaolong.androidutils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wuxiaolong.androidutils.library.AppUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppUtils.installAPK(MainActivity.this,"");
    }
}
