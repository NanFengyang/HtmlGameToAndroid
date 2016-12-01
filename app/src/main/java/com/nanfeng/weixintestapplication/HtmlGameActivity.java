package com.nanfeng.weixintestapplication;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class HtmlGameActivity extends AppCompatActivity {
    private WebView mWebView;
    public static final String GAME_PATH_KEY = "GAME_PATH_KEY";
    private String mFilePath = "file:///android_asset/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_html_game);
        mWebView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new MyWebViewClient());
        String path = this.getIntent().getStringExtra(GAME_PATH_KEY);
        if (null != path && path.length() > 0) {
            Log.e("mFilePath", "mFilePath:" + mFilePath + path);
            mWebView.loadUrl(mFilePath + path + "/index.html");
        } else {
            finish();
        }
    }

    // 监听
    private class MyWebViewClient extends WebViewClient {


        @Override
        public void onPageFinished(WebView view, String url) {
            view.getSettings().setJavaScriptEnabled(true);
            super.onPageFinished(view, url);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            view.getSettings().setJavaScriptEnabled(true);

            super.onPageStarted(view, url, favicon);
        }


    }
}
