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
        for (int i = menu.size();i < BtnArr.length;i++)
        {
            BtnArr[i].setVisibility(View.GONE);
        }
        return rootView;
    }


    public void onClick(View v){
        switch (v.getId())
        {
            case R.id.drinks_0:
                ctrl.MenuBtnClick(this,0);
                break;
            case R.id.drinks_1:
                ctrl.MenuBtnClick(this,1);
                break;
            case R.id.drinks_2:
                ctrl.MenuBtnClick(this,2);
                break;
            case R.id.drinks_3:
                ctrl.MenuBtnClick(this,3);
                break;
            case R.id.drinks_4:
                ctrl.MenuBtnClick(this,4);
                break;
            case R.id.drinks_5:
                ctrl.MenuBtnClick(this,5);
                break;
            case R.id.drinks_6:
                ctrl.MenuBtnClick(this,6);
                break;
            case R.id.drinks_7:
                ctrl.MenuBtnClick(this,7);
                break;
            case R.id.drinks_8:
                ctrl.MenuBtnClick(this,8);
                break;
            case R.id.drinks_9:
                ctrl.MenuBtnClick(this,9);
                break;
            case R.id.drinks_10:
                ctrl.MenuBtnClick(this,10);
                break;
        }
    }
}
