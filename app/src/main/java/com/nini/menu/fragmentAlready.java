package com.nini.menu;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class fragmentAlready extends Fragment {

    View rootView;

    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_already, container, false);

        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.LinerLayout);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        Button btnTag = new Button(this.getActivity());
        btnTag.setLayoutParams(params);
        btnTag.setText("紅醬義大利麵\t炙燒雞腿\t杏鮑菇南瓜濃湯\t草莓奶酪\t玫瑰蜜香茶那堤\n385.0$");
        btnTag.setId(11111111);
        btnTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(btnTag.getText() + "好吃");
            }
        });

        TextView txtTag = new TextView(this.getActivity());
        txtTag.setLayoutParams(params);
        txtTag.setText("34124124124124");
        txtTag.setId(222123444);
        linearLayout.addView(txtTag);
        linearLayout.addView(btnTag);

        Button btnTag2 = new Button(this.getActivity());
        btnTag2.setLayoutParams(params);
        btnTag2.setText("草莓奶酪\t玫瑰蜜香茶那堤\n385.0$");
        btnTag2.setId(2222222);
        btnTag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(btnTag2.getText() + "好吃");
            }
        });

        linearLayout.addView(btnTag2);

        Button btnTag3 = new Button(this.getActivity());
        btnTag3.setLayoutParams(params);
        btnTag3.setText("紅醬義大利麵\n385.0$");
        btnTag3.setId(4444444);
        btnTag3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(btnTag3.getText() + "好吃");
            }
        });

        linearLayout.addView(btnTag3);

        Button btnTag4 = new Button(this.getActivity());
        btnTag4.setLayoutParams(params);
        btnTag4.setText("紅醬義大利麵\n紅醬義大利麵\n紅醬義大利麵\n紅醬義大利麵\n385.0$");
        btnTag4.setId(44444444);
        btnTag4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(btnTag4.getText() + "好吃");
            }
        });

        linearLayout.addView(btnTag4);




        return rootView;
    }
}