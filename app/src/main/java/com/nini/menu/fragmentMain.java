package com.nini.menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class fragmentMain extends Fragment implements View.OnClickListener {

    Button BtnArr[] = new Button[15];

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

                break;
            case R.id.butt_1:

                break;
            case R.id.butt_2:

                break;
            case R.id.butt_3:

                break;
            case R.id.butt_4:

                break;
            case R.id.butt_5:

                break;
            case R.id.butt_6:

                break;
            case R.id.butt_7:

                break;
            case R.id.butt_8:

                break;
            case R.id.butt_9:

                break;
            case R.id.butt_10:

                break;
            case R.id.butt_11:

                break;
            case R.id.butt_12:

                break;
            case R.id.butt_13:

                break;
            case R.id.butt_14:

                break;
        }
    }
}
