package com.wuxiaolong.androidutils.library;


/**
 * Created by Administrator on 2016/4/28.
 */
public class LogUtil {
    private static final String TAG = BuildConfig.TAG;
    private static final boolean LOG = BuildConfig.LOG;

    public static void i(String msg) {
        if (LOG)
            android.util.Log.i(TAG, msg);
    }

    public static void i(String tag, String msg) {
        if (LOG)
            android.util.Log.i(tag, msg);
    }

    public static void d(String msg) {
        if (LOG)
            android.util.Log.d(TAG, msg);
    }

    public static void d(String tag, String msg) {
        if (LOG)
            android.util.Log.d(tag, msg);
    }

    public static void w(String msg) {
        if (LOG)
            android.util.Log.w(TAG, msg);
    }

    public static void w(String tag, String msg) {
        if (LOG)
            android.util.Log.w(tag, msg);
    }

    public static void v(String msg) {
        if (LOG)
            android.util.Log.v(TAG, msg);
    }

    public static void v(String tag, String msg) {
        if (LOG)
            android.util.Log.v(tag, msg);
    }

    public static void e(String msg) {
        android.util.Log.e(TAG, msg);
    }

    public static void e(String tag, String msg) {
        android.util.Log.e(tag, msg);
    }
}
