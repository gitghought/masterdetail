package com.simple.gh.test_master_detail.activity.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.simple.gh.test_master_detail.activity.utils.MyShowUtil;

public class MyService extends Service {
    public MyService() {
    }

    public class MyBinder extends Binder {
        public void onFinished() {
            Log.d(MyShowUtil.TAG, "onFinished: " + "MyBinder");
        }
    }

    MyBinder binder = new MyBinder();

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
}
