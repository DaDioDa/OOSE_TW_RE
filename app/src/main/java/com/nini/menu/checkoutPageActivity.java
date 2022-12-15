package com.nini.menu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;

public class checkoutPageActivity extends AppCompatActivity {
ViewPager COviewPager;
ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkoutpage);
        COviewPager = findViewById(R.id.CheckoutPager);
        viewPagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        setupCOPager(COviewPager);
    }
    public void setupCOPager(ViewPager viewPager){
        viewPagerAdapter.addFragment(new fragmentAlready(),"");
        viewPager.setAdapter(viewPagerAdapter);
    }
}