package com.wuxiaolong.androidutils;

import android.app.Application;

/**
 * Created by WuXiaolong
 * on 2016/7/7.
 */
public class AndroidUtilsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //崩溃处理
//        CrashHandlerUtil crashHandlerUtil = CrashHandlerUtil.getInstance();
//        crashHandlerUtil.init(this);
//        crashHandlerUtil.setCrashTip("很抱歉，程序出现异常，即将退出！");
    }
}
