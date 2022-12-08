package com.nini.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;

import Core.Singleton.Controller;

public class fragmentSoup extends Fragment implements View.OnClickListener {

    Button BtnArr[] = new Button[4];
    Controller ctrl = Controller.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_soup, container, false);

        for (int i = 0; i < 4; i++) {
            int id = getResources().getIdentifier("soup_"+ i, "id","com.nini.menu");
            BtnArr[i] = rootView.findViewById(id);
            BtnArr[i].setText("This is soup_Button NO." + (i+1));
            BtnArr[i].setOnClickListener(this);
        }

        return rootView;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.soup_0:
                ctrl.SoupBtnClick(0);
                break;
            case R.id.soup_1:
                ctrl.SoupBtnClick(1);
                break;
            case R.id.soup_2:
                ctrl.SoupBtnClick(2);
                break;
            case R.id.soup_3:
                ctrl.SoupBtnClick(3);
                break;
        }
    }
}
