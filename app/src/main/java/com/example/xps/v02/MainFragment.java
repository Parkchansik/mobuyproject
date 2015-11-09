package com.example.xps.v02;


import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.FragmentTransaction;
import android.widget.TabHost;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
BuyFragment buyf;
     public MainFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_main, container, false);
        FragmentTransaction ft=getChildFragmentManager().beginTransaction();
        buyf=new BuyFragment();
        ft.replace(R.id.maincontainer, buyf);
        ft.commit();




    return v;
    }



}
