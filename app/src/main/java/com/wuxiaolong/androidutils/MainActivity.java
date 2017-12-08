package com.wuxiaolong.androidutils;

import android.app.DownloadManager;
import android.os.Bundle;
import android.view.View;

import com.wuxiaolong.androidutils.library.DownloadUtil;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DownloadUtil downloadUtil = new DownloadUtil(mActivity, "http://app.mi.com/download/25323");
//                //下载显示名字，不能是中文
                downloadUtil.setDownloadFileName("weiyan" + System.currentTimeMillis() + ".apk");
                downloadUtil.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                downloadUtil.start();
            }
        });

    }
}
