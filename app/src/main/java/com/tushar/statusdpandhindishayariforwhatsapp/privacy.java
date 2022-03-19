package com.tushar.statusdpandhindishayariforwhatsapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class privacy extends AppCompatActivity {

    WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Ruko zara Sabar kro...xD");
        webView = findViewById(R.id.privacy);
        webView.setVerticalScrollBarEnabled(true);
        webView.requestFocus();
        webView.getSettings().setDefaultTextEncodingName("utf-8");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.zoomOut();
        webView.loadUrl("https://theandroguy9463.blogspot.com/p/privacy-policy.html");
        webView.setWebViewClient(new WebViewClient() {

                                     @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                                     @Override
                                     public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                                         view.loadUrl(String.valueOf(request.getUrl()));
                                         return true;
                                     }
                                 }
        );
        webView.setWebChromeClient(new WebChromeClient() {
                                       @Override
                                       public void onProgressChanged(WebView view, int newProgress) {
                                           // super.onProgressChanged(view, newProgress);
                                           if (newProgress < 100) {
                                               pd.show();
                                           } else {
                                               pd.dismiss();
                                           }

                                       }
                                   }
        );
    }

    @Override
    public void onBackPressed() {
        if (webView != null && webView.canGoBack()) {
            webView.goBack();
        } else
            super.onBackPressed();
    }
}
