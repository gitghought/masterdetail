package com.simple.gh.test_master_detail.activity.objs;

import com.google.gson.annotations.SerializedName;
import com.simple.gh.test_master_detail.activity.objs.info.AQI;
import com.simple.gh.test_master_detail.activity.objs.info.Basic;
import com.simple.gh.test_master_detail.activity.objs.info.Forecast;
import com.simple.gh.test_master_detail.activity.objs.info.Now;
import com.simple.gh.test_master_detail.activity.objs.info.Suggestion;

/**
 * Created by gh on 2017-08-07.
 */

public class Weather {
    @SerializedName("status")
    public String status;
    @SerializedName("basic")
    public Basic basic;
    @SerializedName("aqi")
    public AQI aqi;
    @SerializedName("now")
    public Now now;
    @SerializedName("suggestion")
    public Suggestion sug;
    @SerializedName("daily_forecast")
    public Forecast fore;
}
