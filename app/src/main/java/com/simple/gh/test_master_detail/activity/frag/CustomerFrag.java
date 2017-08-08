package com.simple.gh.test_master_detail.activity.frag;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.simple.gh.test_master_detail.R;
import com.simple.gh.test_master_detail.activity.adapter.CustomerAdapter;
import com.simple.gh.test_master_detail.activity.objs.Customer;
import com.simple.gh.test_master_detail.activity.objs.Provinces;
import com.simple.gh.test_master_detail.activity.utils.MyShowUtil;

import java.util.ArrayList;

import static android.provider.ContactsContract.*;

/**
 * Created by gh on 2017-08-02.
 */

public class CustomerFrag extends ListFragment{

    public interface CallBacks {
        public void onCrimeSelected(Customer customer);
    }

    private CallBacks call;



    public ArrayList<Customer> cuses = new ArrayList<Customer>();

    private void getCustomers () {
        ContentResolver resolver = this.getActivity().getContentResolver();
        Cursor cusor =
                resolver.query(
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        null, null, null, null
                );

        Log.d(MyShowUtil.TAG, "getCustomers" + " before if");
        try {
            if (cusor != null) {
                Log.d(MyShowUtil.TAG, "getCustomers" + " before while");
                while (cusor.moveToNext()) {
                    Log.d(MyShowUtil.TAG, "getCustomers" + " before name");
                    String name = cusor.getString(cusor.getColumnIndex(CommonDataKinds.Phone.DISPLAY_NAME));
                    Log.d(MyShowUtil.TAG, "getCustomers: name = " + name);

                    Customer cus = new Customer();
                    cus.setName(name);
                    cuses.add(cus);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cusor.close();
}
}

@Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getCustomers();
        Log.d(MyShowUtil.TAG, "onCreate: size = " + cuses.size());

        CustomerAdapter adapter = new CustomerAdapter(
                this.getActivity(),
                R.layout.customer_fragment_layout,
                cuses);

        this.setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
//        FragmentManager fm = this.getActivity().getSupportFragmentManager();
//        FragmentTransaction bt = fm.beginTransaction();
//
//        if (fm.findFragmentById(R.id.detail_fragment_container) != null) {
//            bt.remove(fm.findFragmentById(R.id.detail_fragment_container));
//        }
//
//        bt.add(R.id.detail_fragment_container, new DetailFrag());
//        bt.commit();
//        call.onCrimeSelected(ProvObjs.getProvObjs().getProvs().get(position));
        call.onCrimeSelected(cuses.get(position));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.cuses.clear();
    }
}
