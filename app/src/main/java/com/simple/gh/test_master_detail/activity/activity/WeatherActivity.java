package com.simple.gh.test_master_detail.activity.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.simple.gh.test_master_detail.R;
import com.simple.gh.test_master_detail.activity.frag.SubDetailFrag;
import com.simple.gh.test_master_detail.activity.frag.weather.WeatherForecastItemFragment;
import com.simple.gh.test_master_detail.activity.frag.weather.WeatherNowFragment;
import com.simple.gh.test_master_detail.activity.frag.weather.WeatherTitleFrag;
import com.simple.gh.test_master_detail.activity.objs.Weather;
import com.simple.gh.test_master_detail.activity.utils.MyJsonUtil;
import com.simple.gh.test_master_detail.activity.utils.MyShowUtil;
import com.simple.gh.test_master_detail.activity.utils.http.MyHttpUtil;

import org.json.JSONException;

public class WeatherActivity extends AppCompatActivity {

    public static final String USERID = "996a262d9f854c5baf75d844c8dc7c24";
    public static final String WEATHER_URL =
            "http://guolin.tech/api/weather?cityid=CN101010200&key=996a262d9f854c5baf75d844c8dc7c24";
    public static final String URL_PREFIX = "http://guolin.tech/api/weather?";
    public static final String URL_END = "&key=996a262d9f854c5baf75d844c8dc7c24";

    public Weather weather;

    public Fragment createFragment() {
        return new WeatherTitleFrag();
    }

    public int getFragmentContainer() {
        return R.id.fragment_title_container;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_fragment_layout);

        Intent intent = this.getIntent();
//        int weatherID = intent.getIntExtra(SubDetailFrag.EXTRA_WEATHER_ID, 0);
        String weatherID = intent.getStringExtra(SubDetailFrag.EXTRA_WEATHER_ID);

        String url = URL_PREFIX+"cityid=" +weatherID + URL_END;
        Log.d(MyShowUtil.TAG, "onCreate: weatherid = " + weatherID);
        Log.d(MyShowUtil.TAG, "onCreate: url = " + url);

        MyHttpUtil.sendRequest(url ,new MyHttpUtil.MyCallBack() {
            @Override
            public void onFinished(String val) {
                Log.d(MyShowUtil.TAG, "onFinished: val = " + val);
                try {
                    weather = MyJsonUtil.parseWeatherWithGson(val);
                    String status = weather.getStatus();
                    Log.d(MyShowUtil.TAG, "onFinished: status = " + status);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Exception e) {

            }
        });

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction bt = fm.beginTransaction();

        WeatherTitleFrag frag = (WeatherTitleFrag) fm.findFragmentById(getFragmentContainer());
        if (frag == null) {
            frag = (WeatherTitleFrag) createFragment();
            bt.add(getFragmentContainer(), frag);
        }

        WeatherNowFragment fragNow = (WeatherNowFragment) fm.findFragmentById(R.id.fragment_now_container);
        if (fragNow == null) {
            fragNow = new WeatherNowFragment();
            bt.add(R.id.fragment_now_container, fragNow);
        }


        WeatherForecastItemFragment fragForeItem = (WeatherForecastItemFragment) fm.findFragmentById(R.id.fragment_forecast_item_container);
        if (fragForeItem == null) {
            fragForeItem = new WeatherForecastItemFragment();
            bt.add(R.id.fragment_forecast_item_container, fragForeItem);
        }

        bt.commit();
    }
}
