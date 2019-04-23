package com.lcz.geek.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.lcz.geek.R;

public class WebActivity extends AppCompatActivity {

    private WebView mWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        initView();
    }

    private void initView() {
        mWebview = (WebView) findViewById(R.id.webview);
        Intent intent = getIntent();

        String url = intent.getStringExtra("url");
        if (url != null) {
            mWebview.loadUrl(url);

        }
        int id = intent.getIntExtra("id", 0);
        if (id != 0) {
            mWebview.loadUrl("http://news-at.zhihu.com/api/4/news/" + id);
        }
        mWebview.setWebViewClient(new WebViewClient());

    }
}
