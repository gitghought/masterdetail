package com.simple.gh.test_master_detail.activity.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.simple.gh.test_master_detail.R;
import com.simple.gh.test_master_detail.activity.frag.MasterFrag;

import static com.simple.gh.test_master_detail.R.id.master_fragment_container;

public class SingleActivity extends AppCompatActivity {
    public Fragment createFragment() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction bt = fm.beginTransaction();

        MasterFrag frag = (MasterFrag) fm.findFragmentById(R.id.master_fragment_container);
        if (frag == null) {
            frag = (MasterFrag) createFragment();
            bt.add(R.id.master_fragment_container, frag);
            bt.commit();
        }
    }
}
