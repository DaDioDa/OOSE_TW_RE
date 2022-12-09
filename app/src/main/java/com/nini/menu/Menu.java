package com.nini.menu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

public class Menu extends AppCompatActivity {
    TabLayout tabs;
    ViewPager pager;
    ViewPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.menu);

        final DBM con = new DBM();

        new Thread(new Runnable(){
            String sql;
            String data;
            public void run(){
                con.run();
                sql ="SELECT * FROM dessert where lunch = 1";
                data = con.getData(sql);
                Log.v("=======午餐=======",data);

                sql ="SELECT * FROM dessert where dinner = 1";
                data = con.getData(sql);
                Log.v("=======晚餐=======",data);
            }
        }).start();



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


