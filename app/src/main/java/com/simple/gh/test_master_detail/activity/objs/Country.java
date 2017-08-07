package com.simple.gh.test_master_detail.activity.objs;


import com.google.gson.annotations.SerializedName;

/**
 * Created by gh on 2017-07-27.
 */

public class Country {
    public int id;
    public String name;

    public void setWeatherID(String weatherID) {
        this.weatherID = weatherID;
    }

    @SerializedName("weather_id")
    public String weatherID;
    public int cityID;

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCityID() {
        return cityID;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWeatherID() {
        return weatherID;
    }
}
