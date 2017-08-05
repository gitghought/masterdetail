package com.simple.gh.test_master_detail.activity.frag;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.simple.gh.test_master_detail.R;
import com.simple.gh.test_master_detail.activity.adapter.MasterAdapter;
import com.simple.gh.test_master_detail.activity.objs.Provinces;
import com.simple.gh.test_master_detail.activity.utils.ProvObjs;

/**
 * Created by gh on 2017-08-02.
 */

public class MasterFrag extends ListFragment{

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

        ArrayAdapter<Provinces> adapter =
                new MasterAdapter(this.getActivity(),
                        R.layout.master_fragment_layout,
                        ProvObjs.getProvObjs().getProvs());

        this.setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        FragmentManager fm = this.getActivity().getSupportFragmentManager();
        FragmentTransaction bt = fm.beginTransaction();

        if (fm.findFragmentById(R.id.detail_fragment_container) != null) {
            bt.remove(fm.findFragmentById(R.id.detail_fragment_container));
        }

        bt.add(R.id.detail_fragment_container, new DetailFrag());
        bt.commit();
//        call.onCrimeSelected(ProvObjs.getProvObjs().getProvs().get(position));
    }
}
