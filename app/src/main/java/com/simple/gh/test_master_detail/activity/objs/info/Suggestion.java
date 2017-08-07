package com.simple.gh.test_master_detail.activity.objs.info;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gh on 2017-08-07.
 */

public class Suggestion {
        public class Comfort {
                public String info;
        }

        public class Carwash {
                public String info;
        }

        public class Sport {
                public String info;
        }

        @SerializedName("comf")
        public Comfort comf;

        @SerializedName("cw")
        public Carwash carw;

        @SerializedName("sport")
        public Sport   sport;
}
