package com.simple.gh.test_master_detail.activity.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.simple.gh.test_master_detail.activity.objs.City;
import com.simple.gh.test_master_detail.activity.objs.Provinces;

import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by gh on 2017-07-27.
 */

public class MyJsonUtil {
    private static final String tag = "MyJsonUtil";

    public static ArrayList<City> parseCityJsonWithGson(String json) throws JSONException {
        Gson gson = new Gson();

        Type type = new TypeToken<ArrayList<City>>() {
        }.getType();
        ArrayList<City> pros = gson.fromJson(json, type);

        return pros;
    }

    public static ArrayList<Provinces> parseProvinceJsonWithGson (String json) throws JSONException {
        Gson gson = new Gson();

        Type type = new TypeToken<ArrayList<Provinces>>() {
        }.getType();
        ArrayList<Provinces> pros = gson.fromJson(json, type);

        return pros;
    }

}
