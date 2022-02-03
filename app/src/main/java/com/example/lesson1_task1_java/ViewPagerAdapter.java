package com.example.lesson1_task1_java;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {

    Context context;
    String[] titles;
    String[] descriptions;

    public ViewPagerAdapter(Context context, String[] titles, String[] descriptions) {
        this.context = context;
        this.titles = titles;
        this.descriptions = descriptions;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.item_layout, container, false);

        TextView textTitle = view.findViewById(R.id.text_title);
        TextView textDes = view.findViewById(R.id.text_description);
        textTitle.setText(titles[position]);
        textDes.setText(descriptions[position]);

        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }
}
