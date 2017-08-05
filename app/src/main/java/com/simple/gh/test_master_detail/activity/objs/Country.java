package com.simple.gh.test_master_detail.activity.objs;


/**
 * Created by gh on 2017-07-27.
 */

public class Country {
    private int id;
    private String name;
    private int weatherID;
    private int cityID;

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeatherID(int weatherID) {
        this.weatherID = weatherID;
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

    public int getWeatherID() {
        return weatherID;
    }
}
