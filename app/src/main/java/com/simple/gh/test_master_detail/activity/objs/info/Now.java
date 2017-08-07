package com.simple.gh.test_master_detail.activity.objs.info;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gh on 2017-08-07.
 */

public class Now {
    @SerializedName("tmp")
    public String tempreture;

    @SerializedName("cond")
    public MoreInfo more;

    public class MoreInfo {
        @SerializedName("txt")
        public String information;
    }
}
