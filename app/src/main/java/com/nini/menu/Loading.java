package com.nini.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import Core.Singleton.Controller;

public class Loading extends AppCompatActivity {
    Controller ctrl = Controller.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        new Thread(new Runnable() {
            @Override
            public void run() {
                ctrl.getMenuFromDB();
                while (!ctrl.isGetDataDone()) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                switchActivity();
            }
        }).start();
    }
    void switchActivity(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }).start();
        Intent intent = new Intent(this, Table.class);
        startActivity(intent);
    }
}