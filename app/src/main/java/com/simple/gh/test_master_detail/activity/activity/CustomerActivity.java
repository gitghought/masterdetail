package com.simple.gh.test_master_detail.activity.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.simple.gh.test_master_detail.R;
import com.simple.gh.test_master_detail.activity.frag.CustomerFrag;
import com.simple.gh.test_master_detail.activity.frag.MasterFrag;

public class CustomerActivity extends AppCompatActivity {
    public Fragment createFragment() {
        return new CustomerFrag();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction bt = fm.beginTransaction();

        CustomerFrag frag = (CustomerFrag) fm.findFragmentById(R.id.master_fragment_container);
        if (frag == null) {
            frag = (CustomerFrag) createFragment();
            bt.add(R.id.master_fragment_container, frag);
            bt.commit();
        }
    }
}
