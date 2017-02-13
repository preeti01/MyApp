package com.example.preeti.myapp.api;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.example.preeti.myapp.Content.User;
import com.example.preeti.myapp.MainApplication;
import com.example.preeti.myapp.Services.ChamberService;
import com.example.preeti.myapp.activity.LoginActivity;

/**
 * Created by preeti on 2/1/2017.
 */

public class LoginApi extends Base {

    public LoginApi(Activity context) {
        setUrl("http://s171227279.onlinehome.us/ecom/nkcc/public/index.php/api/v1/user/login");
        setRequestType(REQUEST_TYPE.POST);
        addCommonHeaders();
        addParam("device_type", "A");
    }
    public LoginApi setEmail(String email){
        addParam("email", email);
        return this;
    }

    public LoginApi setGcmId(String gcm){
        addParam("GCM_ID", gcm);
        return this;
    }

    public LoginApi setPassword(String password){
        addParam("password", password);
        return this;
    }

    User user;

    public void onPostRun(int statusCode, String response) {
        super.onPostRun(statusCode, response);
        if(isValidResponse()) {
//            User user1= new GsonBuilder().create().fromJson(getData().optJSONObject("user").toString(),User.class);
//            ChamberService.setLogin(true);
           user= new User(getData().optJSONObject("user"));
            ChamberService.saveUser(user.getJsonObject().toString());

        }
        /* if(response!=null)
         {
             Toast.makeText(MainApplication.getContext(), "SUCCESS " , Toast.LENGTH_LONG).show();
         }*/
    }

    public User getDetail() {
        return user;
    }


}
