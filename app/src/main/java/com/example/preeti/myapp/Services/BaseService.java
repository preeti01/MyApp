package com.example.preeti.myapp.Services;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.preeti.myapp.MainApplication;

/**
 * Created by preet on 1/24/2017.
 */

public class BaseService {

        protected static SharedPreferences myPreferences;
        public static final String USER = "HHJVBH";
   // public static final String IS_USER_LOGIN = "false";



    static {
        myPreferences = MainApplication.getContext().getSharedPreferences("pref",Context.MODE_PRIVATE);

    }
        public static void saveString(String key,String value)
        {
            SharedPreferences.Editor editor=myPreferences.edit();
            editor.putString(key, value);
            editor.commit();
        }

        public static void removeData(String key)
        {
            SharedPreferences.Editor editor=myPreferences.edit();
            editor.remove(key);
            editor.commit();
        }
        public static final void saveBoolean(String key,boolean value)
        {
            SharedPreferences.Editor editor=myPreferences.edit();
            editor.putBoolean(key, value);
            editor.commit();
        }



    }


