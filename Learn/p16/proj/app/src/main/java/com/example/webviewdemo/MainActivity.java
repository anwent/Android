package com.example.webviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView mWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebview = (WebView) findViewById(R.id.webview_1);

//        loadLocalHTML();

        loadHTML();
    }


    private void loadLocalHTML() {
        mWebview.loadUrl("file:///android_asset/test.html");
    }

    private void loadHTML() {
        // 默认false js不可用
        mWebview.getSettings().setJavaScriptEnabled(true);
        mWebview.loadUrl("https://www.baidu.com");
    }

    private class SSLTolerent extends WebViewClient {
        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            super.onReceivedSslError(view, handler, error);
            handler.proceed();
        }
    }
}
