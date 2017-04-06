package com.example.forget.newsheadlineapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

public class NetworkStateReceiver extends BroadcastReceiver {
    private AppUtil appUtil = new AppUtil();
    private BaseActivity Activity = null;

    NetworkStateReceiver(BaseActivity _Activity){
        Activity = _Activity;
    }
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)){
            if(appUtil.verifyNetwork(Activity)) {
                Activity.loadData();
            }
        }
    }
}
