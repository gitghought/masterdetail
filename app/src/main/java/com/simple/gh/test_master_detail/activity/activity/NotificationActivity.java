package com.simple.gh.test_master_detail.activity.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.simple.gh.test_master_detail.R;

/**
 * Created by gh on 2017-08-09.
 */
public class NotificationActivity extends AppCompatActivity{
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.master_fragment_layout);
    }
}
