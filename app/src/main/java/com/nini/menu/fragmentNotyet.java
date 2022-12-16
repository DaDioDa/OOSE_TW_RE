package com.nini.menu;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import Core.Decorator.OrderType;
import Core.Singleton.Controller;

public class fragmentNotyet extends Fragment {

    LinearLayout linearLayout;
    LinearLayout.LayoutParams params;
    Controller ctrl = Controller.getInstance();
    TextView txtTag;
    Button btnTag;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_notyet, container, false);

        Controller.getInstance().notyet = this;

        linearLayout = rootView.findViewById(R.id.LinerLayout);
        params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);


        return rootView;
    }

    @SuppressLint("ResourceType")
    public void AddNotyetBtn(){
        btnTag = new Button(this.getActivity());
        btnTag.setLayoutParams(params);
        btnTag.setText("刪除");
        btnTag.setId(2);
        btnTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctrl.ResetIndex();
                linearLayout.removeView(btnTag);
                linearLayout.removeView(txtTag);
                btnTag = null;
                txtTag = null;
            }
        });

        txtTag = new TextView(this.getActivity());
        txtTag.setLayoutParams(params);
        txtTag.setText("xxx\nxxx\nxxx\nxxx");
        txtTag.setTextSize(20);
        txtTag.setId(3);

        linearLayout.addView(txtTag);
        linearLayout.addView(btnTag);
    }

    public void SetName()
    {
        if(txtTag == null)
        {
            AddNotyetBtn();
        }
        int [] tmp =  ctrl.getSetIndex();
        String name = "";
        if(tmp[0] != 999)
        {
            name += ctrl.getMenu(OrderType.MainDish).getChildren().get(tmp[0]).getName() + "\n";
        }
        if (tmp[1] != 999)
        {
            name += ctrl.getMenu(OrderType.Soup).getChildren().get(tmp[1]).getName() + "\n";
        }
        if (tmp[2] != 999)
        {
            name += ctrl.getMenu(OrderType.Drink).getChildren().get(tmp[2]).getName() + "\n";
        }
        if (tmp[3] != 999)
        {
            name += ctrl.getMenu(OrderType.Dessert).getChildren().get(tmp[3]).getName() + "\n";
        }
        txtTag.setText(name);
    }

    public void SingleName(){
        if(txtTag == null)
        {
            AddNotyetBtn();
        }
        int tmp =  ctrl.getIndex();
        OrderType type = ctrl.getOrderType();
        String name = "";
        switch (type)
        {
            case MainDish:
                name = ctrl.getMenu(OrderType.MainDish).getChildren().get(tmp).getName() + "\n";
                break;
            case Soup:
                name = ctrl.getMenu(OrderType.Soup).getChildren().get(tmp).getName() + "\n";
                break;
            case Dessert:
                name = ctrl.getMenu(OrderType.Dessert).getChildren().get(tmp).getName() + "\n";
                break;
            case Drink:
                name = ctrl.getMenu(OrderType.Drink).getChildren().get(tmp).getName() + "\n";
                break;
        }
        txtTag.setText(name);
    }

    public void Clear(){
        if(btnTag != null)
        {
            linearLayout.removeView(btnTag);
            linearLayout.removeView(txtTag);
            btnTag = null;
            txtTag = null;
        }
    }

}