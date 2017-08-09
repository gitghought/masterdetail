package com.simple.gh.test_master_detail.activity.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.MapView;
import com.simple.gh.test_master_detail.R;
import com.simple.gh.test_master_detail.activity.utils.MyShowUtil;

public class BaiduActivity extends AppCompatActivity /*implements BDLocationListener*/{
    private LocationClient client;
    private MapView bView;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bView = null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //notice here
        SDKInitializer.initialize(this.getApplicationContext());
        setContentView(R.layout.activity_baidu);

        Log.d(MyShowUtil.TAG, "onCreate baidu");
        bView = (MapView) findViewById(R.id.bmapview);
    }

}
