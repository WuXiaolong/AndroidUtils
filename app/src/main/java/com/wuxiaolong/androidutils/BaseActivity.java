package com.wuxiaolong.androidutils;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class BaseActivity extends AppCompatActivity {
//    public ActivityManagerUtil activityManagerUtil;
    public Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        mActivity = this;
//        activityManagerUtil = ActivityManagerUtil.getInstance();
//        activityManagerUtil.pushOneActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //结束Activity&从栈中移除该Activity
//        activityManagerUtil.popOneActivity(this);
    }

}
