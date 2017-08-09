package com.simple.gh.test_master_detail.activity.activity;

import android.icu.text.LocaleDisplayNames;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.simple.gh.test_master_detail.R;
import com.simple.gh.test_master_detail.activity.frag.DetailFrag;
import com.simple.gh.test_master_detail.activity.frag.MasterFrag;
import com.simple.gh.test_master_detail.activity.frag.MasterFragWithRecyclerView;
import com.simple.gh.test_master_detail.activity.frag.SubDetailFrag;
import com.simple.gh.test_master_detail.activity.objs.City;
import com.simple.gh.test_master_detail.activity.objs.Provinces;
import com.simple.gh.test_master_detail.activity.utils.MyShowUtil;

import java.util.ArrayList;

public class RecyclerMasterActivity extends AppCompatActivity /*SingleActivity implements MasterFrag.CallBacks, DetailFrag.CallBacks*/{
//    private String murl = "http://guolin.tech/api/china";
    private static ArrayList<City> cities = new ArrayList<City>();

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.master_fragment_with_recyclerview);
        Log.d(MyShowUtil.TAG, "onCreate: recycler view");
    }

    //    @Override
//    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState, persistentState);
//        setContentView(R.layout.activity_master);
//
//        Log.d(MyShowUtil.TAG, "onCreate: recycler view");
//
////        FragmentManager fm = getSupportFragmentManager();
////        FragmentTransaction bt = fm.beginTransaction();
////
////        MasterFragWithRecyclerView frag = (MasterFragWithRecyclerView) fm.findFragmentById(R.id.master_fragment_container);
////        if (frag == null) {
////            frag = (MasterFragWithRecyclerView) createFragment();
////            bt.add(R.id.master_fragment_container, frag);
////            bt.commit();
////        }
//    }

    public Fragment createFragment() {
        return new MasterFragWithRecyclerView();
    }

//    public void onCrimeSelected(Provinces prov) {
//
//        FragmentManager fm = this.getSupportFragmentManager();
//        FragmentTransaction bt = fm.beginTransaction();
//
//        if (fm.findFragmentById(R.id.detail_fragment_container) != null) {
//            bt.remove(fm.findFragmentById(R.id.detail_fragment_container));
//        }
//
//        bt.add(R.id.detail_fragment_container, DetailFrag.newInstance(prov.getId()));
//        bt.commit();
//        this.db.insert("Province", null, null);
//    }

//    @Override
//    public void onCrimeSelected(City city) {
//        FragmentManager fm = this.getSupportFragmentManager();
//        FragmentTransaction bt = fm.beginTransaction();
//
//        if (fm.findFragmentById(R.id.subdetail_fragment_container) != null) {
//            bt.remove(fm.findFragmentById(R.id.subdetail_fragment_container));
//        }
//
//        Bundle args;
//
//        DetailFrag detailFrag = (DetailFrag) fm.findFragmentById(R.id.detail_fragment_container);
//        if (detailFrag != null) {
//            args = detailFrag.getArguments();
//            String provID = args.getString(DetailFrag.EXTRA_PROV_ID);
//            String cityID = String.valueOf(city.getId());
//
//            bt.add(R.id.subdetail_fragment_container, SubDetailFrag.newInstance(provID + "/"+ cityID));
//            bt.commit();
//        }
//    }
}
