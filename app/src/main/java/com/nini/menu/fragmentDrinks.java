package com.nini.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class fragmentDrinks extends Fragment {

    Button BtnArr[] = new Button[11];
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_drinks, container, false);

        for (int i = 0; i < 11; i++) {
            int id = getResources().getIdentifier("drinks_"+ i, "id","com.nini.menu");
            BtnArr[i] = rootView.findViewById(id);
            BtnArr[i].setText("This is drinks_Button NO." + (i+1));
        }

        return rootView;
    }
}
