package com.simple.gh.test_master_detail.activity.utils;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.simple.gh.test_master_detail.activity.objs.City;
import com.simple.gh.test_master_detail.activity.objs.Country;
import com.simple.gh.test_master_detail.activity.objs.Provinces;
import com.simple.gh.test_master_detail.activity.objs.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by gh on 2017-07-27.
 */

public class MyJsonUtil {
    private static final String tag = "MyJsonUtil";

    public static ArrayList<Country> parseCountryJsonWithGson(String json) throws JSONException {
        Log.d(MyShowUtil.TAG, "parseCountryJsonWithGson: json = " + json);
        Gson gson = new Gson();

        Type type = new TypeToken<ArrayList<Country>>() {
        }.getType();
        ArrayList<Country> pros = gson.fromJson(json, type);

        return pros;
    }
    public static ArrayList<City> parseCityJsonWithGson(String json) throws JSONException {
        Gson gson = new Gson();

        Log.d(MyShowUtil.TAG, "parseCityJsonWithGson: str = " + json);

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

    public static Weather parseWeatherWithGson (String json) throws JSONException {
        JSONObject jsonObj = new JSONObject(json);
        JSONArray jsonArray = jsonObj.getJSONArray("HeWeather");
        String weather = jsonArray.getJSONObject(0).toString();

        Gson gson = new Gson();

//        Type type = new TypeToken<ArrayList<Provinces>>() {
//        }.getType();
        Weather wea= gson.fromJson(weather, Weather.class);

        return wea;
    }

}
