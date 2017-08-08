package com.simple.gh.test_master_detail.activity.activity;

import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.simple.gh.test_master_detail.R;
import com.simple.gh.test_master_detail.activity.frag.MasterFrag;
import com.simple.gh.test_master_detail.activity.sql.MyDatabaseHelper;

import static com.simple.gh.test_master_detail.R.id.master_fragment_container;

public class SingleActivity extends AppCompatActivity {
    public MyDatabaseHelper helper;
    public SQLiteDatabase db;

    public SQLiteDatabase getDb() {
        return db;
    }

    public Fragment createFragment() {
        return null;
    }

    //R.id.*
    public int getFragmentContainer () {
        return R.id.master_fragment_container;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);

//        helper = new MyDatabaseHelper(this, "coolweather.db", null, 2);
//        db = helper.getWritableDatabase();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction bt = fm.beginTransaction();

        MasterFrag frag = (MasterFrag) fm.findFragmentById(getFragmentContainer());
        if (frag == null) {
            frag = (MasterFrag) createFragment();
            bt.add(getFragmentContainer(), frag);
            bt.commit();
        }
    }
}
