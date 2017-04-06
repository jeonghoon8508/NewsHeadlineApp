package com.example.forget.newsheadlineapp;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

class AppUtil {
    boolean verifyNetwork(Activity activity) {
        ConnectivityManager connectivityManager = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        return activeNetworkInfo != null && activeNetworkInfo.isConnected() && (activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI || activeNetworkInfo.getType() == ConnectivityManager.TYPE_MOBILE);
    }

    JSONObject GetJSONObject(String urlString) {
        try {
            URL url = new URL(urlString);
            InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream(), "UTF-8");
            try {
                return (JSONObject) JSONValue.parseWithException(inputStreamReader);
            } catch (ParseException parseException) {
                return null;
            }
        }catch (IOException exception){
            return null;
        }
    }
}
