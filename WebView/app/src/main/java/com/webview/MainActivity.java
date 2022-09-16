package com.webview;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.net.Uri;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends AppCompatActivity {
    private WebView lihatweb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lihatweb=findViewById(R.id.webview1);
        lihatweb.setWebViewClient(new myWebclint());
        lihatweb.loadUrl("https://melodious-gecko-26ad0c.netlify.app");
        lihatweb.getSettings().setJavaScriptEnabled(true);
        lihatweb.getSettings().setDomStorageEnabled(true);
    }
    private class myWebclint extends WebViewClient {
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);

        }
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView lihatweb, String url) {
            if(url.startsWith("tel:") || url.startsWith("whatsapp:")) {
                Intent intent= new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
                lihatweb.goBack();
                return true;
            }
            return false;
        }

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode==KeyEvent.KEYCODE_BACK) && lihatweb.canGoBack()){
            lihatweb.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}