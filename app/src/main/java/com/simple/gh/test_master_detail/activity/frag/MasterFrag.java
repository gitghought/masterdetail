package com.simple.gh.test_master_detail.activity.frag;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.sqlite.SQLiteDatabase;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
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
import com.simple.gh.test_master_detail.activity.activity.MasterActivity;
import com.simple.gh.test_master_detail.activity.adapter.MasterAdapter;
import com.simple.gh.test_master_detail.activity.objs.Provinces;
import com.simple.gh.test_master_detail.activity.service.MyService;
import com.simple.gh.test_master_detail.activity.sql.MyDatabaseHelper;
import com.simple.gh.test_master_detail.activity.utils.MyJsonUtil;
import com.simple.gh.test_master_detail.activity.utils.MyShowUtil;
import com.simple.gh.test_master_detail.activity.utils.ProvObjs;
import com.simple.gh.test_master_detail.activity.utils.http.MyHttpUtil;
import com.simple.gh.test_master_detail.activity.utils.thread.MyAsyncTask;

import org.json.JSONException;
import org.litepal.LitePal;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by gh on 2017-08-02.
 */

public class MasterFrag extends ListFragment implements MyAsyncTask.AsyncCallback{

    private static ArrayList<Provinces> provs = new ArrayList<>();
    private String murl = "http://guolin.tech/api/china";
    private MasterAdapter adapter;
    private SQLiteDatabase db;

    @Override
    public void onFinished(String json) {
        Log.d(MyShowUtil.TAG, "onFinished: return json from async = " + json);
    }
//    private MyDatabaseHelper helper;
//    private SQLiteDatabase db;

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

    public ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            ((MyService.MyBinder)service).onFinished();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new MyAsyncTask(this).execute(MasterFrag.this.murl);

        this.getActivity().bindService(
                new Intent(this.getActivity(), MyService.class),
                conn,
                Context.BIND_AUTO_CREATE
        );

        db = LitePal.getDatabase();

        adapter =
                new MasterAdapter(this.getActivity(),
                        R.layout.master_fragment_layout,
                        provs);

        this.setListAdapter(adapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

                MyHttpUtil.sendRequest(MasterFrag.this.murl, new MyHttpUtil.MyCallBack() {
                    @Override
                    public void onFinished(String val) {
                        try {
                            provs = MyJsonUtil.parseProvinceJsonWithGson(val);
////                            SQLiteDatabase db = ((MasterActivity) MasterFrag.this.getActivity()).getDb();
                            for (int i = 0; i < provs.size(); i++) {
                                Provinces prov = provs.get(i);

                                ContentValues cv = new ContentValues();
                                cv.put("id", prov.getId());
                                cv.put("name", prov.getName());

                                db.insert("provinces", null, cv);
                                Log.d(MyShowUtil.TAG, "onFinished " + "insert");
                                cv.clear();
                            }
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

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        call.onCrimeSelected(provs.get(position));
    }
}
