package com.simple.gh.test_master_detail.activity.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.simple.gh.test_master_detail.R;
import com.simple.gh.test_master_detail.activity.frag.CustomerFrag;
import com.simple.gh.test_master_detail.activity.frag.DetailFrag;
import com.simple.gh.test_master_detail.activity.frag.MasterFrag;
import com.simple.gh.test_master_detail.activity.objs.Provinces;

public class MasterActivity extends SingleActivity implements MasterFrag.CallBacks{

    @Override
    public Fragment createFragment() {
        return new MasterFrag();
//        return new CustomerFrag();
    }

    @Override
    public void onCrimeSelected(Provinces prov) {
        FragmentManager fm = this.getSupportFragmentManager();
        FragmentTransaction bt = fm.beginTransaction();

        if (fm.findFragmentById(R.id.detail_fragment_container) != null) {
            bt.remove(fm.findFragmentById(R.id.detail_fragment_container));
        }

        bt.add(R.id.detail_fragment_container, new DetailFrag());
        bt.commit();
    }
}
