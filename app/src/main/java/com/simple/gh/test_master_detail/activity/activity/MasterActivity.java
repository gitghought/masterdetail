package com.simple.gh.test_master_detail.activity.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.simple.gh.test_master_detail.R;
import com.simple.gh.test_master_detail.activity.frag.DetailFrag;
import com.simple.gh.test_master_detail.activity.frag.MasterFrag;
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

public class MasterActivity extends SingleActivity implements MasterFrag.CallBacks{
    private String murl = "http://guolin.tech/api/china";
    private static ArrayList<City> cities = new ArrayList<City>();

    @Override
    public Fragment createFragment() {
        return new MasterFrag();
    }
    private void sendRequest(String murl, Callback call) {
        try {
            MyHttpUtil.sendRequest(murl, call);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onCrimeSelected(Provinces prov) {

//        this.sendRequest(this.murl, new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                String str = response.body().string();
//                try {
//                    cities = MyJsonUtil.parseCityJsonWithGson(str);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        });

        FragmentManager fm = this.getSupportFragmentManager();
        FragmentTransaction bt = fm.beginTransaction();

        if (fm.findFragmentById(R.id.detail_fragment_container) != null) {
            bt.remove(fm.findFragmentById(R.id.detail_fragment_container));
        }

        bt.add(R.id.detail_fragment_container, DetailFrag.newInstance(prov.getId()));
        bt.commit();
    }
}
