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

public class fragmentDrinks extends Fragment implements View.OnClickListener{

    Button BtnArr[] = new Button[11];
    Controller ctrl = Controller.getInstance();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_drinks, container, false);
        for (int i = 0; i < 11; i++) {
            int id = getResources().getIdentifier("drinks_"+ i, "id","com.nini.menu");
            BtnArr[i] = rootView.findViewById(id);
            BtnArr[i].setText("N/A");
            BtnArr[i].setOnClickListener(this);
        }
        ArrayList<Menu> menu = ctrl.getMenu(OrderType.Drink).getChildren();
        for (int i = 0; i < menu.size(); i++) {
            String text = menu.get(i).getName() + "\n" + menu.get(i).getPrice();
            BtnArr[i].setText(text);
        }
        return rootView;
    }


    public void onClick(View v){
        switch (v.getId())
        {
            case R.id.drinks_0:
                ctrl.DrinkBtnClick(0);
                break;
            case R.id.drinks_1:
                ctrl.DrinkBtnClick(1);
                break;
            case R.id.drinks_2:
                ctrl.DrinkBtnClick(2);
                break;
            case R.id.drinks_3:
                ctrl.DrinkBtnClick(3);
                break;
            case R.id.drinks_4:
                ctrl.DrinkBtnClick(4);
                break;
            case R.id.drinks_5:
                ctrl.DrinkBtnClick(5);
                break;
            case R.id.drinks_6:
                ctrl.DrinkBtnClick(6);
                break;
            case R.id.drinks_7:
                ctrl.DrinkBtnClick(7);
                break;
            case R.id.drinks_8:
                ctrl.DrinkBtnClick(8);
                break;
            case R.id.drinks_9:
                ctrl.DrinkBtnClick(9);
                break;
            case R.id.drinks_10:
                ctrl.DrinkBtnClick(10);
                break;
        }
    }
}
