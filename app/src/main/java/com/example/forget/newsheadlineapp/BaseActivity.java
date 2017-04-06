package com.example.forget.newsheadlineapp;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {
    private NetworkStateReceiver networkStateReceiver = null;
    protected AppUtil appUtil = new AppUtil();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        networkStateReceiver = new NetworkStateReceiver(this);
    }

    protected void createActivity(){
        initActivity();

        if(appUtil.verifyNetwork(this)) {
            loadData();
        }else{
            Toast toast = Toast.makeText(this, "인터넷이 연결되어 있지 않습니다", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    protected void loadData(){

    }

    protected void initActivity(){

    }

    protected void onResume() {
        super.onResume();
        if(networkStateReceiver != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(android.net.ConnectivityManager.CONNECTIVITY_ACTION);
            registerReceiver(networkStateReceiver, intentFilter);
        }
    }

    protected void onPause() {
        super.onPause();

        if(networkStateReceiver != null) {
            unregisterReceiver(networkStateReceiver);
        }
    }
}
