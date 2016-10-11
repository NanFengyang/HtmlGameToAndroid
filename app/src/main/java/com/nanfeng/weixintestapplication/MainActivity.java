package com.nanfeng.weixintestapplication;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    private WebView mWebView;
    private String filepaht = Environment.getExternalStorageDirectory().getAbsolutePath();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        Log.e("IOException", "filepaht:" + filepaht);
//            copyBigDataToSD(filepaht);
//        mWebView.loadUrl("file://" + filepaht + "/bdsjm/index.html");//SD卡文件
        mWebView.loadUrl("file:///android_asset/bdsjm/index.html");//Asset文件夹文件
    }


}
