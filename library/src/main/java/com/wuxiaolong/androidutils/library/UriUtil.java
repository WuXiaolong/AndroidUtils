package com.wuxiaolong.androidutils.library;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

/**
 * Created by xdj
 * on 16/8/31.
 */
public class UriUtil {

    /**
     * 将 content://media/external/images/media/32073 格式路径转为文件绝对路径
     * @param uri
     * @return
     */
    public static String convertToFilePath(Context context, Uri uri) {
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = context.getContentResolver().query(uri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            return cursor.getString(cursor.getColumnIndex(MediaStore.MediaColumns.DATA));
        }
        return null;
    }
}
