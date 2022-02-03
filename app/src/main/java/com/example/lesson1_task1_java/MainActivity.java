package com.example.lesson1_task1_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPagerAdapter viewPagerAdapter;
    ViewPager viewPager;
    LottieAnimationView lottieAnimation;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] titles = new String[]{
                "Say Hello to\nGlobal Top-Up",
                "Say Hi to\nGlobal Top-Up",
                "Say Hello to\nGlobal Top-Up"
        };

        String[] des = new String[]{
                "Say Hello to\nGlobal Top-Up, Global Top-Up",
                "Say Hi to\nGlobal Top-Up, Global Top-Up",
                "Say Hello to\nGlobal Top-Up, Global Top-Up"
        };

        viewPager = findViewById(R.id.view_pager_main);
        lottieAnimation = findViewById(R.id.lottie_anim);
        DotsIndicator dots = findViewById(R.id.dots);
        button = findViewById(R.id.get_btn);
        viewPagerAdapter = new ViewPagerAdapter(this, titles, des);
        viewPager.setAdapter(viewPagerAdapter);
        dots.setViewPager(viewPager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                switch (position) {
                    case 0: {
                        lottieAnimation.setAnimation(R.raw.anim_1);
                        button.setVisibility(View.GONE);
                    }
                    case 1: {
                        lottieAnimation.setAnimation(R.raw.anim_2);
                        button.setVisibility(View.GONE);
                    }
                    case 2: {
                        lottieAnimation.setAnimation(R.raw.anim_1);
                        button.setVisibility(View.VISIBLE);
                    }
                }
                lottieAnimation.playAnimation();
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
}