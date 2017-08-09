package com.simple.gh.test_master_detail.activity.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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

import static com.simple.gh.test_master_detail.activity.utils.MyContext.context;

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

    private Button btnShowNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_fragment_layout);

        btnShowNotification = (Button) findViewById(R.id.btn_show_notification);
        btnShowNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager manager = (NotificationManager) WeatherActivity.this.getSystemService(NOTIFICATION_SERVICE);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(WeatherActivity.this);
                builder.setContentTitle("this is title");
                builder.setContentText("this is content text");
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setWhen(System.currentTimeMillis());
                Intent intent = new Intent(WeatherActivity.this, NotificationActivity.class);
                PendingIntent pi = PendingIntent.getActivity(WeatherActivity.this, 0,intent, 0);
                builder.setContentIntent(pi);
                builder.setAutoCancel(true);
                Notification noti = builder.build();

                manager.notify(1, noti);

                Log.d(MyShowUtil.TAG, "onClick: show noti");

            }
        });

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
