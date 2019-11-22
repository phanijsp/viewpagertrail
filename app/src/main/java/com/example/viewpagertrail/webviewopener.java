package com.example.viewpagertrail;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.airbnb.lottie.LottieAnimationView;

public class webviewopener extends AppCompatActivity {

    private WebView webview;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webviewopener);
        //make translucent statusBar on kitkat devices
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        //make fully Android Transparent Status bar
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        webview = (WebView) findViewById(R.id.webView);
        lottieAnimationView = (LottieAnimationView) findViewById(R.id.loading_animation);
        lottieAnimationView.setVisibility(View.VISIBLE);
        webview.setVisibility(View.INVISIBLE);
        webview.getSettings().setJavaScriptEnabled(true);
        String newUA= "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:40.0) Gecko/20100101 Firefox/40.1";
        webview.getSettings().setUserAgentString(newUA);
        webview.zoomOut();
        webview.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                view.loadUrl("javascript:(function() { " +
                        "var head = document.getElementsByClassName('ui fluid container menu-container ')[0].style.display='none'; " +
                        "var head = document.getElementsByClassName('navigation')[0].style.display='none'; " +
                        "var head = document.getElementsByClassName('button-text')[0].style.display='none'; " +
                        "var head = document.getElementsByClassName('button-block')[0].style.display='none'; " +


                        "var head = document.getElementsByClassName('ui top aligned stackable grid')[0].style.display='none';" +
                        "var head = document.getElementById('details').style.display='none'; " +
                        "var head = document.getElementById('tvshow-mobile-ad').style.display='none';" +
                        "var head = document.getElementById('sticker').style.display='none';" +
                        "var head = document.getElementById('message').style.display='none';" +
                        "var head = document.querySelector('footer').style = 'display: none';" +
                        "})()");
                lottieAnimationView.setVisibility(View.INVISIBLE);
                webview.setVisibility(View.VISIBLE);

            }
        });
        webview.loadUrl(urlhelper.urladdress);


    }

    public static void setWindowFlag(Activity activity, final int bits, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }


}
