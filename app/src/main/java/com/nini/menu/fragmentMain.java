package com.nini.menu;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import Core.Composite.Menu;
import Core.Decorator.OrderType;
import Core.Singleton.Controller;

public class fragmentMain extends Fragment implements View.OnClickListener {

    Button BtnArr[] = new Button[15];
    Button cancel,send;
    Controller ctrl = Controller.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        for (int i = 0; i < 15; i++) {
            int id = getResources().getIdentifier("butt_"+ i, "id","com.nini.menu");
            BtnArr[i] = rootView.findViewById(id);
            BtnArr[i].setText("N/A");
            BtnArr[i].setOnClickListener(this);
        }

        ArrayList<Menu> menu = ctrl.getMenu(OrderType.MainDish).getChildren();
        for (int i = 0; i < menu.size(); i++) {
            String text = menu.get(i).getName() + "\n" + menu.get(i).getPrice();
            BtnArr[i].setText(text);
        }
        return rootView;
    }


    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.butt_0:
                sauseView();
                break;
            case R.id.butt_1:
                ctrl.MenuBtnClick(this,1);
                break;
            case R.id.butt_2:
                ctrl.MenuBtnClick(this,2);
                break;
            case R.id.butt_3:
                ctrl.MenuBtnClick(this,3);
                break;
            case R.id.butt_4:
                ctrl.MenuBtnClick(this,4);
                break;
            case R.id.butt_5:
                ctrl.MenuBtnClick(this,5);
                break;
            case R.id.butt_6:
                ctrl.MenuBtnClick(this,6);
                break;
            case R.id.butt_7:
                ctrl.MenuBtnClick(this,7);
                break;
            case R.id.butt_8:
                ctrl.MenuBtnClick(this,8);
                break;
            case R.id.butt_9:
                ctrl.MenuBtnClick(this,9);
                break;
            case R.id.butt_10:
                ctrl.MenuBtnClick(this,10);
                break;
            case R.id.butt_11:
                ctrl.MenuBtnClick(this,11);
                break;
            case R.id.butt_12:
                ctrl.MenuBtnClick(this,12);
                break;
            case R.id.butt_13:
                ctrl.MenuBtnClick(this,13);
                break;
            case R.id.butt_14:
                ctrl.MenuBtnClick(this,14);
                break;
        }
    }
    public void sauseView(){
        AlertDialog ad = new AlertDialog.Builder(getActivity()).create();
        ad.setCancelable(false);
        ad.setTitle("請選取一款醬料");
        View view=getLayoutInflater().inflate(R.layout.sauce,null);
        ad.setView(view);
        cancel=(Button) view.findViewById(R.id.sauce_cancel);
        send=(Button) view.findViewById(R.id.sauce_ok);



        /*ad.setMessage("文字在此");
        ad.setPositiveButton("確定",null);
        ad.setNegativeButton("取消",null);
        ad.setCancelable(false);*/
        ad.show();
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                //對話框消失
                ad.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //對話框消失
                ad.dismiss();
            }
        });
    }

}
