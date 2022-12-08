package com.nini.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;

public class fragmentSoup extends Fragment {

    Button BtnArr[] = new Button[4];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_soup, container, false);

        for (int i = 0; i < 4; i++) {
            int id = getResources().getIdentifier("soup_"+ i, "id","com.nini.menu");
            BtnArr[i] = rootView.findViewById(id);
            BtnArr[i].setText("This is soup_Button NO." + (i+1));
        }

        return rootView;
    }
}
