package com.shahnwaz.jitcollege;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ImageSliderAdapter extends PagerAdapter {

     Context context;
     ArrayList<Integer> arrayList;
     LayoutInflater layoutInflater;

    public ImageSliderAdapter(Context context, ArrayList<Integer> arrayList){
        this.context = context;
        this.arrayList = arrayList;
        layoutInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    public Object instantiateItem(ViewGroup container, int position){
        View view = layoutInflater.inflate(R.layout.img_slider_item,container,false);
        ImageView imageView = view.findViewById(R.id.img1);
        imageView.setImageResource(arrayList.get(position));
        container.addView(view);
        return view;

    }

    public void destroyItem(ViewGroup container, int position, Object object){
        container.removeView((View) object);
    }

}
