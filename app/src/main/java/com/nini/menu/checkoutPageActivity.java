package com.nini.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
        TextView txt = findViewById(R.id.tableNum);
        txt.setText(c.getTableName());
        COviewPager = findViewById(R.id.CheckoutPager);
        viewPagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        setupCOPager(COviewPager);
        Button checkout = findViewById(R.id.checkoutDone);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.ClearTable();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                }).start();
                Intent intent = new Intent(checkoutPageActivity.this,Table.class);
                startActivity(intent);
            }
        });
    }
    public void setupCOPager(ViewPager viewPager){
        viewPagerAdapter.addFragment(new fragmentAlready(),"");
        viewPager.setAdapter(viewPagerAdapter);
    }



}