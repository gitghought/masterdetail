package com.simple.gh.test_master_detail.activity.frag;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.simple.gh.test_master_detail.R;
import com.simple.gh.test_master_detail.activity.adapter.MasterAdapter;
import com.simple.gh.test_master_detail.activity.objs.Provinces;
import com.simple.gh.test_master_detail.activity.utils.MyHttpUtil;
import com.simple.gh.test_master_detail.activity.utils.MyJsonUtil;
import com.simple.gh.test_master_detail.activity.utils.MyShowUtil;
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

public class MasterFrag extends ListFragment{

    private static ArrayList<Provinces> provs = new ArrayList<>();
    private String murl = "http://guolin.tech/api/china";
    private MasterAdapter adapter;

    public interface CallBacks {
        public void onCrimeSelected(Provinces prov);
    }

    private CallBacks call;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        call = (CallBacks) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        call = null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter =
                new MasterAdapter(this.getActivity(),
                        R.layout.master_fragment_layout,
                        provs);

        this.setListAdapter(adapter);
    }
    private void sendRequest(String murl, Callback call) {
        try {
            MyHttpUtil.sendRequest(murl, call);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Thread mythread = new Thread(new Runnable() {
            @Override
            public void run() {
                sendRequest(MasterFrag.this.murl, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String str = response.body().string();
                        Log.d(MyShowUtil.TAG, "onResponse: str = " + str);
                        try {
                            provs = MyJsonUtil.parseProvinceJsonWithGson(str);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        mythread.start();

        try {
            mythread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        call.onCrimeSelected(provs.get(position));
    }
}
