package com.wuxiaolong.androidutils.library;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by WuXiaolong on 2016/3/22.
 */
public class AppUtils {
    /**
     * 启动相机
     */

    public static String startCamera(Activity activity, int requestCode) {
        // 指定相机拍摄照片保存地址
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            Intent intent = new Intent();
            // 指定开启系统相机的Action
            intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
            File outDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            if (!outDir.exists()) {
                outDir.mkdirs();
            }
            File outFile = new File(outDir, System.currentTimeMillis() + ".jpg");
            // 把文件地址转换成Uri格式
            Uri uri = Uri.fromFile(outFile);
            // 设置系统相机拍摄照片完成后图片文件的存放地址
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            // 此值在最低质量最小文件尺寸时是0，在最高质量最大文件尺寸时是１
            intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 0);
            activity.startActivityForResult(intent, requestCode);
            return outFile.getAbsolutePath();
        } else {
            Toast.makeText(activity, "请确认已经插入SD卡",
                    Toast.LENGTH_LONG).show();
            return null;
        }

    }

    /**
     * 打开相册
     */
    public static void startAlbum(Activity activity, int requestCode) {
        Intent intent = new Intent(Intent.ACTION_PICK, null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        activity.startActivityForResult(intent, requestCode);
    }

    /**
     * 验证手机
     *
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO(String mobiles) {
        String expression = "((^(13|15|18)[0-9]{9}$)|(^0[1,2]{1}\\d{1}-?\\d{8}$)" +
                "|(^0[3-9] {1}\\d{2}-?\\d{7,8}$)|(^0[1,2]{1}\\d{1}-?\\d{8}-(\\d{1,4})$)" +
                "|(^0[3-9]{1}\\d{2}-? \\d{7,8}-(\\d{1,4})$))";
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(mobiles);
        return matcher.matches();
    }

    /**
     * FilePath To Bitmap
     */
    public static Bitmap getBitmapFromFilePath(Activity activity, String filePath) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;

        int bmpWidth = options.outWidth;
        int bmpHeght = options.outHeight;

        WindowManager windowManager = (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);
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
        Bitmap bitmap = BitmapFactory.decodeFile(filePath, options);
        return bitmap;
    }

    /**
     * Bitmap to File
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
     * @param plainText
     * @return
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


}
