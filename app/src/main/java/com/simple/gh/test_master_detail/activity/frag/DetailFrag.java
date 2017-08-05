package com.simple.gh.test_master_detail.activity.frag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.simple.gh.test_master_detail.R;
import com.simple.gh.test_master_detail.activity.adapter.DetailAdapter;
import com.simple.gh.test_master_detail.activity.adapter.MasterAdapter;
import com.simple.gh.test_master_detail.activity.objs.City;
import com.simple.gh.test_master_detail.activity.objs.Provinces;
import com.simple.gh.test_master_detail.activity.utils.MyHttpUtil;
import com.simple.gh.test_master_detail.activity.utils.MyJsonUtil;
import com.simple.gh.test_master_detail.activity.utils.ProvObjs;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by gh on 2017-08-02.
 */

public class DetailFrag extends ListFragment{
    private static String murl = "http://guolin.tech/api/china";
    private static ArrayList<City> cities = new ArrayList<City>();

    private static void sendRequest(String murl, Callback call) {
        try {
            MyHttpUtil.sendRequest(murl, call);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static DetailFrag newInstance(int provID) {
        sendRequest(murl + "/" + provID, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                try {
                    cities = MyJsonUtil.parseCityJsonWithGson(str);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        Bundle args = new Bundle();

        DetailFrag fragment = new DetailFrag();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("good", "onCreate: " + "begin");

        ArrayAdapter<Provinces> adapter =
                new DetailAdapter(this.getActivity(),
                        R.layout.master_fragment_layout,
                        cities);

        this.setListAdapter(adapter);
    }

}
