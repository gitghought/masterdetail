package com.simple.gh.test_master_detail.activity.activity;

import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.simple.gh.test_master_detail.R;
import com.simple.gh.test_master_detail.activity.adapter.MasterAdapterWithRecyclerView;
import com.simple.gh.test_master_detail.activity.frag.MasterFragWithRecyclerView;
import com.simple.gh.test_master_detail.activity.objs.Provinces;
import com.simple.gh.test_master_detail.activity.utils.MyJsonUtil;
import com.simple.gh.test_master_detail.activity.utils.MyShowUtil;
import com.simple.gh.test_master_detail.activity.utils.http.MyHttpUtil;

import org.json.JSONException;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity /*implements MasterFragWithRecyclerView.CallBacks*/{

    private String murl = "http://guolin.tech/api/china";

    private ArrayList<Provinces> provs = new ArrayList<Provinces>();
    private MasterAdapterWithRecyclerView adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.master_fragment_with_recyclerview);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_master);
        LinearLayoutManager mana = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mana);

        adapter = new MasterAdapterWithRecyclerView(
                this,
                provs,
                R.layout.master_fragment_layout
        );

        recyclerView.setAdapter(adapter);

        MyHttpUtil.sendRequest(RecyclerActivity.this.murl, new MyHttpUtil.MyCallBack() {
            @Override
            public void onFinished(String val) {
                try {
                    Log.d(MyShowUtil.TAG, "onFinished: val = " + val);
                    provs = MyJsonUtil.parseProvinceJsonWithGson(val);
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Exception e) {

            }
        });
        try {
            MyHttpUtil.getThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
