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

public class BaiduActivity extends AppCompatActivity {
    private TextView tvInfo;

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

        SDKInitializer.initialize(this.getApplicationContext());

        setContentView(R.layout.activity_baidu);

        Log.d(MyShowUtil.TAG, "onCreate baidu");

        bView = (MapView) findViewById(R.id.bmapview);


//        client = new LocationClient(this);
//        client.registerLocationListener(new BDLocationListener() {
//            @Override
//            public void onReceiveLocation(BDLocation bdLocation) {
//                Log.d(MyShowUtil.TAG, "onReceiveLocation: " + "onReceiveLocation");
//                StringBuilder sb = new StringBuilder();
//                sb.append("经度").append( bdLocation.getLatitude() );
//                sb.append("纬度").append( bdLocation.getLatitude() );
//
//                Log.d(MyShowUtil.TAG, "onReceiveLocation: latitude = " + sb.toString());
//            }
//
//            @Override
//            public void onConnectHotSpotMessage(String s, int i) {
//
//            }
//        });
//
//        client.start();
//
//        tvInfo = (TextView) findViewById(R.id.tv_info);
    }
}
