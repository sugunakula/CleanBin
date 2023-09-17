package com.codr.cleanbin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class NewsWebViewActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_web_view);

        webView = findViewById(R.id.newsWebView);

        // Enable JavaScript (if needed)
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Load the URL you want to display
        webView.loadUrl("https://timesofindia.indiatimes.com/city/visakhapatnam/bobbili-town-an-inspiring-lesson-in-smart-waste-management/articleshow/53202971.cms");

        // Set a WebViewClient to handle navigation within the WebView
        webView.setWebViewClient(new WebViewClient());

    }
}