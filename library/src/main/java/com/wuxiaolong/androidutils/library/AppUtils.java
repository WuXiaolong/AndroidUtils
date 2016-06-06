package com.wuxiaolong.androidutils.library;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;

/**
 * Created by WuXiaolong
 * on 2016/3/22.
 */
public class AppUtils {
    /**
     * 关闭键盘
     *
     * @param activity Activity
     */
    public static void hideSoftInput(Activity activity) {
        if (activity.getCurrentFocus() != null)
            ((InputMethodManager) activity
                    .getSystemService(Context.INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(activity.getCurrentFocus()
                            .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * 指定小数输出
     *
     * @param s      输入
     * @param format 小数格式，比如保留两位0.00
     * @return 输出结果
     */
    public static String decimalFormat(String s, String format) {
        DecimalFormat decimalFormat = new DecimalFormat(format);
        return decimalFormat.format(s);
    }

    /**
     * FilePath To Bitmap
     *
     * @param context  上下文
     * @param filePath 文件路径
     */
    public static Bitmap getBitmapFromFilePath(Context context, String filePath) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;

        int bmpWidth = options.outWidth;
        int bmpHeght = options.outHeight;

        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(metrics);
        int screenWidth = metrics.widthPixels;
        int screenHeight = metrics.heightPixels;

        options.inSampleSize = 1;
        if (bmpWidth > bmpHeght) {
            if (bmpWidth > screenWidth)
                options.inSampleSize = bmpWidth / screenWidth;
        } else {
            if (bmpHeght > screenHeight)
                options.inSampleSize = bmpHeght / screenHeight;
        }
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(filePath, options);
    }

    /**
     * Bitmap to File
     *
     * @param bitmap
     */
    public static String bitmap2File(Bitmap bitmap) {

        File outDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        if (!outDir.exists()) {
            outDir.mkdirs();
        }
        File outFile = new File(outDir, System.currentTimeMillis() + ".jpg");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(outFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 40, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outFile.getAbsolutePath();
    }

    /**
     * 把Bitmap转Byte
     */
    public static byte[] bitmap2Bytes(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }


    /**
     * MD5加密
     *
     * @param plainText 需要加密的字符串
     * @return 加密后字符串
     */
    public static String md5(String plainText) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString().toLowerCase();// 32位的加密（转成小写）

            buf.toString().substring(8, 24);// 16位的加密

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 安装apk
     *
     * @param context 上下文
     * @param path    文件路劲
     */
    public static void installAPK(Context context, String path) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(android.content.Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(new File(path)), "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

    /**
     * 直接拨号，需要增加CALL_PHONE权限
     *
     * @param context 上下文
     * @param phone   手机号码
     */
    public static void actionCall(Context context, String phone) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
        intent.setAction(Intent.ACTION_CALL);// 直接拨号
        context.startActivity(intent);
    }

    /**
     * 跳到拨号盘-拨打电话
     *
     * @param context 上下文
     * @param phone   手机号码
     */
    public static void actionDial(Context context, String phone) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
        intent.setAction(Intent.ACTION_DIAL);// 拨号盘
        context.startActivity(intent);
    }

}
