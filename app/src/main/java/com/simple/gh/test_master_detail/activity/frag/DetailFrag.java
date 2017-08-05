package com.simple.gh.test_master_detail.activity.frag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.simple.gh.test_master_detail.R;
import com.simple.gh.test_master_detail.activity.adapter.DetailAdapter;
import com.simple.gh.test_master_detail.activity.adapter.MasterAdapter;
import com.simple.gh.test_master_detail.activity.objs.Provinces;
import com.simple.gh.test_master_detail.activity.utils.ProvObjs;

/**
 * Created by gh on 2017-08-02.
 */

public class DetailFrag extends ListFragment{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("good", "onCreate: " + "begin");

        ArrayAdapter<Provinces> adapter =
                new DetailAdapter(this.getActivity(),
                        R.layout.master_fragment_layout,
                        ProvObjs.getProvObjs().getProvs());

        this.setListAdapter(adapter);
    }

}
