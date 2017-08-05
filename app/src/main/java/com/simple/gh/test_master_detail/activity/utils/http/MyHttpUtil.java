package com.simple.gh.test_master_detail.activity.utils.http;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by gh on 2017-07-25.
 */

public class MyHttpUtil {
    private static Thread thread;

    public interface MyCallBack {
        public void onFinished(String val);
        public void onError(Exception e);
    }

    public static Thread getThread() {
       return thread;
    }

    public static void sendRequest(String murl, MyHttpUtil.MyCallBack call) {
        try {
            MyHttpUtil.invoke(murl, call);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void invoke(final String addr, final MyCallBack callBack) throws IOException {
        thread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Log.d("MYJSON", "run: begin");
                    URL url = new URL(addr);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setReadTimeout(8000);
                    conn.setConnectTimeout(8000);
                    InputStream is = conn.getInputStream();

                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String str;
                    StringBuilder sb = new StringBuilder();

                    while ((str = br.readLine()) != null) {
                        sb.append(str);
                    }

                    str = sb.toString();
                    if (callBack != null) {
                        callBack.onFinished(str);
                    }
                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {

                }
            } });
        thread.start();
    }
}
