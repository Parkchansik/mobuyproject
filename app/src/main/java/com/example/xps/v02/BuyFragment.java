package com.example.xps.v02;


import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;


/**
 * A simple {@link Fragment} subclass.
 */
public class BuyFragment extends Fragment {
    TabHost tabHost;
    ViewPager pager;
    TabsAdapter mAdapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v= inflater.inflate(R.layout.fragment_buy, container, false);


        tabHost = (TabHost)v.findViewById(R.id.tabHost);
        tabHost.setup();
        pager = (ViewPager)v.findViewById(R.id.pager);
        mAdapter = new TabsAdapter(getActivity(), getChildFragmentManager(), tabHost, pager);

        mAdapter.addTab(tabHost.newTabSpec("tab1").setIndicator("공구모집중"), OneFragment.class, null);
        mAdapter.addTab(tabHost.newTabSpec("tab2").setIndicator("판매진행중"), TwoFragment.class, null);
        if (savedInstanceState != null) {
            tabHost.setCurrentTab(savedInstanceState.getInt("tabIndex"));
            mAdapter.onRestoreInstanceState(savedInstanceState);
        }

    return  v;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("tabIndex", tabHost.getCurrentTab());
        mAdapter.onSaveInstanceState(outState);
    }
}
