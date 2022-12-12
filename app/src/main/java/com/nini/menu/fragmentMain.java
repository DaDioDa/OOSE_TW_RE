package com.nini.menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import Core.Composite.Menu;
import Core.Singleton.Controller;

public class fragmentMain extends Fragment implements View.OnClickListener {

    Button BtnArr[] = new Button[15];
    Controller ctrl = Controller.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        for (int i = 0; i < 15; i++) {
            int id = getResources().getIdentifier("butt_"+ i, "id","com.nini.menu");
            BtnArr[i] = rootView.findViewById(id);
            BtnArr[i].setText("This is Button NO." + (i+1));
            BtnArr[i].setOnClickListener(this);
        }
        return rootView;
    }


    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.butt_0:
                ctrl.MainBtnClick(0);
                break;
            case R.id.butt_1:
                ctrl.MainBtnClick(1);
                break;
            case R.id.butt_2:
                ctrl.MainBtnClick(2);
                break;
            case R.id.butt_3:
                ctrl.MainBtnClick(3);
                break;
            case R.id.butt_4:
                ctrl.MainBtnClick(4);
                break;
            case R.id.butt_5:
                ctrl.MainBtnClick(5);
                break;
            case R.id.butt_6:
                ctrl.MainBtnClick(6);
                break;
            case R.id.butt_7:
                ctrl.MainBtnClick(7);
                break;
            case R.id.butt_8:
                ctrl.MainBtnClick(8);
                break;
            case R.id.butt_9:
                ctrl.MainBtnClick(9);
                break;
            case R.id.butt_10:
                ctrl.MainBtnClick(10);
                break;
            case R.id.butt_11:
                ctrl.MainBtnClick(11);
                break;
            case R.id.butt_12:
                ctrl.MainBtnClick(12);
                break;
            case R.id.butt_13:
                ctrl.MainBtnClick(13);
                break;
            case R.id.butt_14:
                ctrl.MainBtnClick(14);
                break;
        }
    }
}
