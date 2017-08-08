package com.simple.gh.test_master_detail.activity.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.simple.gh.test_master_detail.R;
import com.simple.gh.test_master_detail.activity.frag.DetailFrag;
import com.simple.gh.test_master_detail.activity.frag.MasterFrag;
import com.simple.gh.test_master_detail.activity.frag.SubDetailFrag;
import com.simple.gh.test_master_detail.activity.objs.City;
import com.simple.gh.test_master_detail.activity.objs.Provinces;
import com.simple.gh.test_master_detail.activity.utils.MyHttpUtil;
import com.simple.gh.test_master_detail.activity.utils.MyJsonUtil;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MasterActivity extends SingleActivity implements MasterFrag.CallBacks, DetailFrag.CallBacks{
//    private String murl = "http://guolin.tech/api/china";
    private static ArrayList<City> cities = new ArrayList<City>();

    @Override
    public Fragment createFragment() {
        return new MasterFrag();
    }

    @Override
    public void onCrimeSelected(Provinces prov) {

        FragmentManager fm = this.getSupportFragmentManager();
        FragmentTransaction bt = fm.beginTransaction();

        if (fm.findFragmentById(R.id.detail_fragment_container) != null) {
            bt.remove(fm.findFragmentById(R.id.detail_fragment_container));
        }

        bt.add(R.id.detail_fragment_container, DetailFrag.newInstance(prov.getId()));
        bt.commit();
        this.db.insert("Province", null, null);
    }

    @Override
    public void onCrimeSelected(City city) {
        FragmentManager fm = this.getSupportFragmentManager();
        FragmentTransaction bt = fm.beginTransaction();

        if (fm.findFragmentById(R.id.subdetail_fragment_container) != null) {
            bt.remove(fm.findFragmentById(R.id.subdetail_fragment_container));
        }

        Bundle args;

        DetailFrag detailFrag = (DetailFrag) fm.findFragmentById(R.id.detail_fragment_container);
        if (detailFrag != null) {
            args = detailFrag.getArguments();
            String provID = args.getString(DetailFrag.EXTRA_PROV_ID);
            String cityID = String.valueOf(city.getId());

            bt.add(R.id.subdetail_fragment_container, SubDetailFrag.newInstance(provID + "/"+ cityID));
            bt.commit();
        }
    }
}
