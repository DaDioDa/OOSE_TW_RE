package com.nini.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class fragmentDessert extends Fragment {

    Button BtnArr[] = new Button[12];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dessert, container, false);

        for (int i = 0; i < 12; i++) {
            int id = getResources().getIdentifier("dess_"+ i, "id","com.nini.menu");
            BtnArr[i] = rootView.findViewById(id);
            BtnArr[i].setText("This is dessert_Button NO." + (i+1));
        }

        /*
        Button buttonSayHi = (Button) rootView.findViewById(R.id.aaa);
        buttonSayHi.setText("132\n16456");
         */
        return rootView;


    }

}
