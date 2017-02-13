package com.example.preeti.myapp;

import android.app.Application;
import android.content.Context;

/**
 * Created by preet on 1/24/2017.
 */

public class MainApplication extends Application{

    private static Context mContext;
    public void onCreate() {
        super.onCreate();
        mContext=this;

    }

    public static Context getContext()
    {

        return mContext;
    }





}
