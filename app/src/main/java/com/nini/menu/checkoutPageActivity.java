package com.nini.menu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import androidx.viewpager.widget.ViewPager;

import Core.Singleton.Controller;

public class checkoutPageActivity extends AppCompatActivity {
ViewPager COviewPager;
ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkoutpage);
        Controller c = Controller.getInstance();
        int id = getResources().getIdentifier("checkoutDone", "id","com.nini.menu");
        Button button = this.findViewById(id);
        button.setText("$ " + c.getTablePrice());
        COviewPager = findViewById(R.id.CheckoutPager);
        viewPagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        setupCOPager(COviewPager);
    }
    public void setupCOPager(ViewPager viewPager){
        viewPagerAdapter.addFragment(new fragmentAlready(),"");
        viewPager.setAdapter(viewPagerAdapter);
    }



}