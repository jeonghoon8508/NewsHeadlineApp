package com.example.forget.newsheadlineapp;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class StoryActivity extends BaseActivity {
    private WebView webView = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        createActivity();
    }

    protected void initActivity(){
        super.initActivity();
        webView = (WebView) findViewById(R.id.web_View);
        webView.setWebViewClient(new WebViewClient());
    }

    protected void loadData(){
        super.loadData();
        ProcessIntent();
    }

    private void ProcessIntent(){
        Intent intent = getIntent();
        if(intent != null){
            if(webView != null) {
                webView.loadUrl(intent.getDataString());
            }
        }
    }
}
