package com.example.viewpagertrail;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.xgc1986.parallaxPagerTransformer.ParallaxPagerTransformer;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    ArrayList<backgrounds> backgroundsArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        viewPager.setPageTransformer(false,new ParallaxPagerTransformer(R.id.imageView));

        backgroundsArrayList = new ArrayList<>();
        backgroundsArrayList.add(new backgrounds(R.drawable.zyx,"Lost In Space","https://www.episodate.com/tv-show/lost-in-space-netflix"));
        backgroundsArrayList.add(new backgrounds(R.drawable.hdm,"His Dark Materials","https://www.episodate.com/tv-show/his-dark-materials"));
        backgroundsArrayList.add(new backgrounds(R.drawable.sv,"Silicon Valley","https://www.episodate.com/tv-show/silicon-valley"));
        backgroundsArrayList.add(new backgrounds(R.drawable.lucy,"Lucifer","https://www.episodate.com/tv-show/lucifer"));
        backgroundsArrayList.add(new backgrounds(R.drawable.mr,"MR. ROBOT","https://www.episodate.com/tv-show/mr-robot"));
        backgroundsArrayList.add(new backgrounds(R.drawable.peaky,"Peaky Blinders","https://www.episodate.com/tv-show/peaky-blinders"));



        viewPager.setAdapter(new CustomPagerAdapter(this,backgroundsArrayList));

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
