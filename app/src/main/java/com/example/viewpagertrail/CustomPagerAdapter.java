package com.example.viewpagertrail;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

/**
 * Created by anupamchugh on 26/12/15.
 */
public class CustomPagerAdapter extends PagerAdapter {

    private Context mContext;
    private ArrayList<backgrounds> backgroundsArrayList;
    public CustomPagerAdapter(Context context,ArrayList<backgrounds> backgroundsArrayList) {
        mContext = context;
        this.backgroundsArrayList = backgroundsArrayList;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, final int position) {
//        ModelObject modelObject = ModelObject.values()[position];
        LayoutInflater inflater = LayoutInflater.from(mContext);

        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.view_blue, collection, false);
        ImageView imageView = (ImageView) layout.findViewById(R.id.imageView);
        ImageView imageView2 = (ImageView) layout.findViewById(R.id.imageView2);
        TextView textView = (TextView) layout.findViewById(R.id.textView);
        textView.setText(backgroundsArrayList.get(position).getTitle());

        imageView.setImageResource(backgroundsArrayList.get(position).getResid());
                collection.addView(layout);
                imageView2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        urlhelper.urladdress = backgroundsArrayList.get(position).getUrladdress();
//                        Toast.makeText(mContext,"Clicked"+backgroundsArrayList.get(position).getUrladdress(),Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(mContext,webviewopener.class);
                        mContext.startActivity(i);
                    }
                });
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return backgroundsArrayList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }



}
