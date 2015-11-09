package com.example.xps.v02;

import android.app.Application;
import android.content.Context;

/**
 * Created by XPS on 2015-11-09.
 */
public class MyApplication extends Application {
    private static Context mContext;

    public void onCreate(){
        super.onCreate();
        mContext=this;
    }
    public static Context getmContext(){
        return mContext;
    }
}
