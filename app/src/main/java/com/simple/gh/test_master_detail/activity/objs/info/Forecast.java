package com.simple.gh.test_master_detail.activity.objs.info;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by gh on 2017-08-07.
 */

public class Forecast {
    @SerializedName("date")
    public Date date;

    @SerializedName("cond")
    public MoreInfo more;

    @SerializedName("tmp")
    public Tempreture temp;

    public class Tempreture {
        public String max;
        public String min;
    }

    public class MoreInfo {
        @SerializedName("txt_d")
        public String info;
    }
}
