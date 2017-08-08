package com.simple.gh.test_master_detail.activity.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.simple.gh.test_master_detail.R;
import com.simple.gh.test_master_detail.activity.objs.Customer;
import com.simple.gh.test_master_detail.activity.objs.Provinces;

import java.util.ArrayList;

/**
 * Created by gh on 2017-08-04.
 */

public class CustomerAdapter extends ArrayAdapter{
    private Context context;
    private int resource;
    private ArrayList<Customer> provs;

    public CustomerAdapter(Context context, int resource, ArrayList<Customer> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.provs = objects;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View view = inflater.inflate(this.resource, parent, false);

        TextView tvID = (TextView) view.findViewById(R.id.tv_id);
        tvID.setText(provs.get(position).getName());

        return view;
    }
}
