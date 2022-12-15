package com.nini.menu;

import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import Core.Singleton.Controller;

public class Table extends AppCompatActivity implements View.OnClickListener {
    Button BtnArr[] = new Button[9];
    Controller ctrl = Controller.getInstance();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table);
        for (int i = 0; i < 9; i++) {
            int id = getResources().getIdentifier("table_"+ i, "id","com.nini.menu");
            BtnArr[i] = this.findViewById(id);
            BtnArr[i].setOnClickListener(this);
        }
    }
    public void onClick(View v){
        switch (v.getId())
        {
            case R.id.table_0:
                ctrl.GetTable(0);
                switchActivity();
                break;
            case R.id.table_1:
                ctrl.GetTable(1);
                switchActivity();
                break;
            case R.id.table_2:
                ctrl.GetTable(2);
                switchActivity();
                break;
            case R.id.table_3:
                ctrl.GetTable(3);
                switchActivity();
                break;
            case R.id.table_4:
                ctrl.GetTable(4);
                switchActivity();
                break;
            case R.id.table_5:
                ctrl.GetTable(5);
                switchActivity();
                break;
            case R.id.table_6:
                ctrl.GetTable(6);
                switchActivity();
                break;
            case R.id.table_7:
                ctrl.GetTable(7);
                switchActivity();
                break;
            case R.id.table_8:
                ctrl.GetTable(8);
                switchActivity();
                break;
        }

    }
    void switchActivity(){
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }
}