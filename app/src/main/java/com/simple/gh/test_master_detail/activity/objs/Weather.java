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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @SerializedName("basic")
    public Basic basic;
//    @SerializedName("aqi")
//    public AQI aqi;
//    @SerializedName("now")
//    public Now now;
//    @SerializedName("suggestion")
//    public Suggestion sug;
//    @SerializedName("daily_forecast")
//    public Forecast fore;
//
//    public AQI getAqi() {
//        return aqi;
//    }
//
//    public void setAqi(AQI aqi) {
//        this.aqi = aqi;
//    }
//
//    public Basic getBasic() {
//        return basic;
//    }
//
//    public void setBasic(Basic basic) {
//        this.basic = basic;
//    }
//
//    public Forecast getFore() {
//        return fore;
//    }
//
//    public void setFore(Forecast fore) {
//        this.fore = fore;
//    }
//
//    public Now getNow() {
//        return now;
//    }
//
//    public void setNow(Now now) {
//        this.now = now;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public Suggestion getSug() {
//        return sug;
//    }
//
//    public void setSug(Suggestion sug) {
//        this.sug = sug;
//    }
}
