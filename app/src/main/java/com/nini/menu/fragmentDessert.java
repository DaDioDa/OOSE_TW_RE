package com.nini.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import Core.Composite.Menu;
import Core.Decorator.OrderType;
import Core.Singleton.Controller;


public class fragmentDessert extends Fragment implements View.OnClickListener{

    Button BtnArr[] = new Button[12];
    Controller ctrl = Controller.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dessert, container, false);

        for (int i = 0; i < 12; i++) {
            int id = getResources().getIdentifier("dess_"+ i, "id","com.nini.menu");
            BtnArr[i] = rootView.findViewById(id);
            BtnArr[i].setText("N/A");
            BtnArr[i].setOnClickListener(this);
        }
        ArrayList<Menu> menu = ctrl.getMenu(OrderType.Dessert).getChildren();
        for (int i = 0; i < menu.size(); i++) {
            String text = menu.get(i).getName() + "\n" + menu.get(i).getPrice();
            BtnArr[i].setText(text);
        }
        return rootView;
    }



    public void onClick(View v){
        switch (v.getId())
        {
            case R.id.dess_0:
                ctrl.DessertBtnClick(0);
                break;
            case R.id.dess_1:
                ctrl.DessertBtnClick(1);
                break;
            case R.id.dess_2:
                ctrl.DessertBtnClick(2);
                break;
            case R.id.dess_3:
                ctrl.DessertBtnClick(3);
                break;
            case R.id.dess_4:
                ctrl.DessertBtnClick(4);
                break;
            case R.id.dess_5:
                ctrl.DessertBtnClick(5);
                break;
            case R.id.dess_6:
                ctrl.DessertBtnClick(6);
                break;
            case R.id.dess_7:
                ctrl.DessertBtnClick(7);
                break;
            case R.id.dess_8:
                ctrl.DessertBtnClick(8);
                break;
            case R.id.dess_9:
                ctrl.DessertBtnClick(9);
                break;
            case R.id.dess_10:
                ctrl.DessertBtnClick(10);
                break;
            case R.id.dess_11:
                ctrl.DessertBtnClick(11);
                break;
        }
    }

}
