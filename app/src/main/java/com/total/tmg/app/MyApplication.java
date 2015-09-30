package com.total.tmg.app;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;

/**
 * Created by CNRED002 on 2015/9/29.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AVOSCloud.initialize(this, "QodEoQiiYWhiTP5SAeH2LmQc", "dgUSkB4jzJDvMenuDwDjz9VW");
    }
}
