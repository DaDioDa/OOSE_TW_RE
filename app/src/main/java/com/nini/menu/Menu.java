package com.nini.menu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.Gravity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.fragment.app.DialogFragment;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

import org.w3c.dom.Text;

import java.text.ParseException;

import Core.Singleton.Controller;
import Core.Strategy.Timer;

public class Menu extends AppCompatActivity {
    TabLayout tabs;
    ViewPager pager,alreadyPager,notyetPager;
    ViewPagerAdapter pagerAdapter,pagerAdapter2,pagerAdapter3;
    Controller ctrl;
    CheckBox chk;
    boolean isSet = false;
    Button submit;
    Button checkout;
    String sauce;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.menu);

//==================CtrlStart===================
        ctrl = Controller.getInstance();
        //ctrl.getMenuFromDB();
//==================CtrlEnd=====================
        TextView t = findViewById(R.id.tableNum);
        t.setText(ctrl.getTableName());

        tabs = findViewById(R.id.meal);
        pager = findViewById(R.id.pager);
        chk = findViewById(R.id.checkBox);
        checkout = findViewById(R.id.checkout);
        alreadyPager = findViewById(R.id.alreadyPager);
        notyetPager = findViewById(R.id.NotyetPager);

        pagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        pagerAdapter2 = new ViewPagerAdapter(this.getSupportFragmentManager());
        pagerAdapter3 = new ViewPagerAdapter(this.getSupportFragmentManager());

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
        setupAlreadyPager(alreadyPager);
        setupNotyetPager(notyetPager);
        tabs.setupWithViewPager(pager);

        submit = findViewById(R.id.summit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctrl.PlaceOrder();



                //Toast
                Toast toast = Toast.makeText(Menu.this, "您所選的餐點已出單", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();

                //如果未出單是空的，顯示如下的toast
                /* Toast = Toast.makeText(Menu.this, "請先選擇餐點後再出單", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();*/
            }
        });

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                }).start();

                ctrl.CheckOut();
                switchActivity();
            }
        });

        chk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctrl.isSet = chk.isChecked();

                //refactor
                ctrl.notyet.Clear();
                //refactor
            }
        });


    }



    public void setupViewPager(ViewPager viewPager) {
        pagerAdapter.addFragment(new fragmentMain(), "MAIN");
        pagerAdapter.addFragment(new fragmentSoup(), "Soup");
        pagerAdapter.addFragment(new fragmentDessert(), "Dessert");
        pagerAdapter.addFragment(new fragmentDrinks(), "Drinks");
        viewPager.setAdapter(pagerAdapter);
    }
    public void setupAlreadyPager(ViewPager viewPager){
        pagerAdapter2.addFragment(new fragmentAlready(),"");
        viewPager.setAdapter(pagerAdapter2);
    }
    public void setupNotyetPager(ViewPager viewPager){
        pagerAdapter3.addFragment(new fragmentNotyet(),"");
        viewPager.setAdapter(pagerAdapter3);
    }

    void switchActivity(){
        Intent intent = new Intent(this, checkoutPageActivity.class);
        startActivity(intent);
    }
}


