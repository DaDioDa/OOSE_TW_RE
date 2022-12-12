package com.nini.menu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

import java.text.ParseException;

import Core.Singleton.Controller;
import Core.Strategy.Timer;

public class Menu extends AppCompatActivity {
    TabLayout tabs;
    ViewPager pager;
    ViewPagerAdapter pagerAdapter;
    Controller ctrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.menu);
//==================CtrlStart===================
        ctrl = Controller.getInstance();
        ctrl.getMenuFromDB();
//==================CtrlEnd=====================

        tabs = findViewById(R.id.meal);
        pager = findViewById(R.id.pager);

        pagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        setupViewPager(pager);
        tabs.setupWithViewPager(pager);
    }

    public void setupViewPager(ViewPager viewPager) {
        pagerAdapter.addFragment(new fragmentMain(), "MAIN");
        pagerAdapter.addFragment(new fragmentSoup(), "Soup");
        pagerAdapter.addFragment(new fragmentDessert(), "Dessert");
        pagerAdapter.addFragment(new fragmentDrinks(), "Drinks");
        viewPager.setAdapter(pagerAdapter);
    }
}


