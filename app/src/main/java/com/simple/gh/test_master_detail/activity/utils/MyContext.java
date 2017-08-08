package com.simple.gh.test_master_detail.activity.utils;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import org.litepal.LitePal;
import org.litepal.LitePalApplication;

/**
 * Created by gh on 2017-08-08.
 */

public class MyContext extends LitePalApplication{
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(MyShowUtil.TAG, "onCreate: " + "mycontext");
        MyContext.context = getApplicationContext();
        LitePal.initialize(this);
//        LitePalApplication.initialize(this);
    }

    public static Context getContext(){
        return context;
    }
}
