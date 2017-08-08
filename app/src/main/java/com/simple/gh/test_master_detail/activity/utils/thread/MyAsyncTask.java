package com.simple.gh.test_master_detail.activity.utils.thread;

import android.os.AsyncTask;
import android.util.Log;

import com.simple.gh.test_master_detail.activity.utils.MyShowUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by gh on 2017-08-08.
 */

public class MyAsyncTask extends AsyncTask<String, Void, Void> {
    public interface AsyncCallback {
        public void onFinished(String json);
    }

    private AsyncCallback call;
    public MyAsyncTask(AsyncCallback call) {
        this.call = call;
    }

    @Override
    protected Void doInBackground(String... params) {
//        for (int i = 0; i < params.length; i++) {
//            Log.d(MyShowUtil.TAG, "doInBackground: params = " + params[i]);
//        }
        try {
            Log.d("MYJSON", "run: begin");
            URL url = new URL(params[0]);
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
            if (call != null) {
                call.onFinished(str);
            }
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

        return null;
    }

}
