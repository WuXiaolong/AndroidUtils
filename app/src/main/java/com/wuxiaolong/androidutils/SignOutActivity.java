package com.wuxiaolong.androidutils;

import android.os.Bundle;
import android.view.View;

import java.util.List;

public class SignOutActivity extends BaseActivity {
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_out);
        findViewById(R.id.signOut).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityManagerUtil.appExit();
            }
        });
        findViewById(R.id.crashHandler).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.size();
            }
        });
    }
}
