package com.wuxiaolong.androidutils.library;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by Administrator
 * on 2016/5/24.
 */
public class VersionUtil {
    /**
     * 获取版本号
     *
     * @param activity
     * @return
     */
    public static String getVersionName(Activity activity) {
        PackageManager packageManager = activity.getPackageManager();
        String packageName = activity.getPackageName();
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
     *
     * @param activity
     * @return
     */
    public static int getVersionCode(Activity activity) {
        PackageManager packageManager = activity.getPackageManager();
        String packageName = activity.getPackageName();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 1;
    }
}
