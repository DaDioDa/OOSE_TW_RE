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

import Core.Singleton.Controller;

public class fragmentAlready extends Fragment {

    TextView txt;
    Controller ctrl = Controller.getInstance();

    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_already, container, false);
        txt = rootView.findViewById(R.id.textView);
        ctrl.already = this;
        ctrl.setAlreadyText();

        return rootView;
    }

    public void setText(String str){
        txt.setText(str);
    }
}