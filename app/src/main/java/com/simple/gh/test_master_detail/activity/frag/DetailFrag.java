package com.simple.gh.test_master_detail.activity.frag;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;

import com.simple.gh.test_master_detail.R;
import com.simple.gh.test_master_detail.activity.adapter.DetailAdapter;
import com.simple.gh.test_master_detail.activity.adapter.MasterAdapter;
import com.simple.gh.test_master_detail.activity.objs.City;
import com.simple.gh.test_master_detail.activity.objs.Provinces;
import com.simple.gh.test_master_detail.activity.utils.MyJsonUtil;
import com.simple.gh.test_master_detail.activity.utils.MyShowUtil;
import com.simple.gh.test_master_detail.activity.utils.ProvObjs;
import com.simple.gh.test_master_detail.activity.utils.http.MyHttpUtil;

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
    private DetailAdapter adapter;

//    private static void sendRequest(String murl, Callback call) {
//        try {
//            MyHttpUtil.sendRequest(murl, call);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(MyShowUtil.TAG, "onAttach: " + "detail Fragment");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(MyShowUtil.TAG, "onDetach: " + "detail Fragment");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(MyShowUtil.TAG, "onActivityCreated: detail fragment");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(MyShowUtil.TAG, "onDestroyView: detail fragment");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(MyShowUtil.TAG, "onStart: detail fragment");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(MyShowUtil.TAG, "onStop: detail fragment");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(MyShowUtil.TAG, "onPause: detail fragment");
        this.adapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(MyShowUtil.TAG, "onResume: detail fragment");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(MyShowUtil.TAG, "onDestroy: detail fragment");
    }
    public void onUiUpdate(){
        DetailAdapter adapter = (DetailAdapter) this.getListAdapter();
        adapter.notifyDataSetChanged();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.d(MyShowUtil.TAG, "onCreateView: detail fragment");

        ((ArrayAdapter)this.getListAdapter()).notifyDataSetChanged();

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public static DetailFrag newInstance(int provID) {
        Log.d(MyShowUtil.TAG, "newInstance: detail fragment");
        MyHttpUtil.sendRequest(murl + "/" + provID, new MyHttpUtil.MyCallBack() {
            @Override
            public void onFinished(String val) {
                try {
                    cities = MyJsonUtil.parseCityJsonWithGson(val);
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
//        sendRequest(murl + "/" + provID, new Callback() {
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
////                    ((DetailAdapter)DetailFrag.getListAdapter()).notifyDataSetChanged();
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        });

        Bundle args = new Bundle();

        DetailFrag fragment = new DetailFrag();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(MyShowUtil.TAG, "onCreate: " + "begin");

        adapter = new DetailAdapter(this.getActivity(),
                R.layout.master_fragment_layout,
                cities);

        this.setListAdapter(adapter);
    }

}
