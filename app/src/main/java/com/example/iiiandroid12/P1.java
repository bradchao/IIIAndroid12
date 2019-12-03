package com.example.iiiandroid12;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;


/**
 * A simple {@link Fragment} subclass.
 */
public class P1 extends Fragment {
    private View mainView;
    private ViewFlipper viewFlipper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mainView == null) {
            mainView = inflater.inflate(R.layout.fragment_p1, container, false);
            viewFlipper = mainView.findViewById(R.id.viewFlipper);
            View f0 = viewFlipper.getChildAt(0);
            View f1 = viewFlipper.getChildAt(1);
            View f2 = viewFlipper.getChildAt(2);
            View f3 = viewFlipper.getChildAt(3);
            MyClickListener listener = new MyClickListener();
            f0.setOnClickListener(listener);
            f1.setOnClickListener(listener);
            f2.setOnClickListener(listener);
            f3.setOnClickListener(listener);
        }

        return mainView;
    }

    private class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            viewFlipper.showNext();
        }
    }

}
