package com.simple.gh.test_master_detail.activity.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.simple.gh.test_master_detail.R;
import com.simple.gh.test_master_detail.activity.objs.Provinces;
import com.simple.gh.test_master_detail.activity.utils.MyShowUtil;

import java.util.ArrayList;

import static android.R.attr.id;

/**
 * Created by gh on 2017-08-04.
 */

public class MasterAdapterWithRecyclerView extends RecyclerView.Adapter<MasterAdapterWithRecyclerView.ViewHolder> {
    private Context context;
    private int resource;
    private ArrayList<Provinces> provs;

    public MasterAdapterWithRecyclerView(Context context, ArrayList<Provinces> provs, int resource) {
        this.context = context;
        this.provs = provs;
        this.resource = resource;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.master_fragment_layout, parent, false);

        ViewHolder vh = new ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Provinces prov = provs.get(position);
        int id = prov.getId();

        Log.d(MyShowUtil.TAG, "onBindViewHolder: size = " + provs.size());
        Log.d(MyShowUtil.TAG, "onBindViewHolder: id = " + id);

        holder.tvID.setText(prov.getName());
    }

    @Override
    public int getItemCount() {
        Log.d(MyShowUtil.TAG, "getItemCount() : size = " + provs.size());
        return provs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvID;

        public ViewHolder(View view) {
            super(view);
            this.tvID = (TextView) view.findViewById(R.id.tv_id);
        }
    }
}
