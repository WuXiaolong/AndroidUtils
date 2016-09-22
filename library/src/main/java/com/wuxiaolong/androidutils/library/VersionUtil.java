package com.wuxiaolong.androidutils.library;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by Administrator
 * on 2016/5/24.
 *
 * Android Studio 中会自动生成BuildConfig.java文件
 * 可以通过此文件获得Apk的VersionCode、 VersionName、isDebug
 */
@SuppressWarnings("unused")
public class VersionUtil {
    /**
     * 获取版本号
     * 使用 BuildConfig.VERSION_NAME 替换
     *
     * @param context 上下文
     * @return 版本号
     */
    @Deprecated
    public static String getVersionName(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "1.0.0";
    }

    /**
     * 获取版本code
     * 使用 BuildConfig.VERSION_CODE 替换
     *
     * @param context 上下文
     * @return 版本code
     */
    @Deprecated
    public static int getVersionCode(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 1;
    }
}
