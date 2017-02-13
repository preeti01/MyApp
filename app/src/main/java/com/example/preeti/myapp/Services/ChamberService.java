package com.example.preeti.myapp.Services;

//import com.example.preeti.myapp.User;

import android.text.TextUtils;

import com.example.preeti.myapp.Content.User;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by preeti on 1/24/2017.
 */

public class ChamberService extends BaseService {

    public static void saveUser(String name) {
        saveString(USER, String.valueOf(name));
        user=null;
    }

    private static User user;

    public static User getUser() {
        if (user != null)
            return user;
        try {//{}
            return user = new User(new JSONObject(myPreferences.getString(USER, "{}")));
        } catch (JSONException E) {
        }
        return null;
    }

    public static boolean isUserLogin() {
        User user = getUser();
        boolean isUserLogin = !TextUtils.isEmpty(user.getAuth_key());
        return isUserLogin;
    }
//logout;
    public static void logoutUser(){
        saveString(USER,"{}");
        user=null;
    }
   /* public static boolean isUserLogin() {
        return myPreferences.getBoolean(IS_USER_LOGIN, false);
    }*/

  /*  public static void setLogin(boolean isLogin) {
        saveBoolean(IS_USER_LOGIN, isLogin);
    }*/

}
