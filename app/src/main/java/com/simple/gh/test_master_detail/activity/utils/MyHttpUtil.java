package com.simple.gh.test_master_detail.activity.utils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by gh on 2017-07-27.
 */

public class MyHttpUtil{
    public static void sendRequest(String url ,Callback callback) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request.Builder builder = new Request.Builder();
        builder.url(url);
        Request req = builder.build();

        Call call = client.newCall(req);
        call.enqueue(callback);

    }
}
