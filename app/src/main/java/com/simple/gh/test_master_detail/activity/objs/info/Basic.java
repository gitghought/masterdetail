package com.simple.gh.test_master_detail.activity.objs.info;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gh on 2017-08-07.
 */

public class Basic {
    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public int weatherID;

    public Update update;

    public class Update {
        @SerializedName("loc")
           public String updateTime;
    }
}
