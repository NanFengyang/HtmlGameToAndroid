package com.nanfeng.weixintestapplication.activity;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.nanfeng.weixintestapplication.R;
import com.nanfeng.weixintestapplication.helper.AssetsHelper;

import java.io.File;
import java.util.List;

public class HtmlGameActivity extends AppCompatActivity {
    private WebView mWebView;
    public static final String GAME_PATH_KEY = "GAME_PATH_KEY";
    private String mFilePath = "file:///android_asset/";
    private final String HTML = "index.html";
    private final String HTM = "index.htm";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_html_game);
        initView();
        initData();
    }

    private void initView() {
        mWebView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //扩大比例的缩放
        webSettings.setUseWideViewPort(true);
        //自适应屏幕
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setLoadWithOverviewMode(true);
        mWebView.setWebViewClient(new MyWebViewClient());
    }

    private void initData() {
        String path = this.getIntent().getStringExtra(GAME_PATH_KEY);
        List<String> menulist = AssetsHelper.getListAssets(this, path);
        String gamePath = mFilePath + path + File.separator;
        if (null != menulist && menulist.size() > 0) {
            if (menulist.contains(HTML)) {
                gamePath += HTML;
            } else if (menulist.contains(HTM)) {
                gamePath += HTM;
            }
            Log.e("mFilePath", "mFilePath:" + gamePath);
            mWebView.loadUrl(gamePath);
        } else {
            finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * 页面监听
     */
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
