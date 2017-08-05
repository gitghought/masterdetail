package com.simple.gh.test_master_detail.activity.utils;

import android.util.Log;

import com.simple.gh.test_master_detail.activity.objs.City;
import com.simple.gh.test_master_detail.activity.objs.Provinces;

import java.util.ArrayList;

/**
 * Created by gh on 2017-07-28.
 */

public class MyShowUtil {
    public static final String TAG = "MyShowUtil";
    public static void showList (ArrayList<Provinces> list)  {
        for (int i = 0; i < list.size(); i++) {
            Log.d(TAG, "showList: id = " + list.get(i).getId() );
            Log.d(TAG, "showList: name = " + list.get(i).getName());
        }
    }

    public static void showCountryList (ArrayList<City> list)  {
        for (int i = 0; i < list.size(); i++) {
            Log.d(TAG, "showList: id = " + list.get(i).getId() );
            Log.d(TAG, "showList: name = " + list.get(i).getName());
        }
    }
}
