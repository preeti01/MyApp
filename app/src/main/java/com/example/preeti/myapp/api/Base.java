package com.example.preeti.myapp.api;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;

import com.example.preeti.myapp.Services.ChamberService;
import com.example.preeti.myapp.MainApplication;

import org.json.JSONException;
import org.json.JSONObject;


import com.example.preeti.myapp.Common.ConnectionDetector;
import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * Created by Raman Kumar on 3/19/2016.
 */
public abstract class Base extends BaseServiceable {

    ConnectionDetector connection;

    public final void addCommonHeaders() {
      //  boolean userLogin = false;
        addHeader("X-DEVICE-ID", getAndroidDeviceId(MainApplication.getContext()));
        addHeader("X-APPKEY", "sasefyweadfkdhaecommstreetinfoservicessiowedaflsdfjs");
        addHeader("X-AUTHKEY", ChamberService.getUser().getAuth_key());
        connection = new ConnectionDetector(MainApplication.getContext());
    }
    public static String getAndroidDeviceId(Context context) {
        String android_id = Settings.Secure.getString(context.getContentResolver(),
                Settings.Secure.ANDROID_ID);
        return android_id;
    }

    private JSONObject data;

    public JSONObject getData() {
        return data;
    }

    private String errorMessage;

    @Override
    public void onPostRun(int statusCode, String response) {
        if(TextUtils.isEmpty(response))
            isValidResponse=false;
        else {
            try{
                JSONObject object=new JSONObject(response);
                isValidResponse=object.optBoolean("status");
                data=object.optJSONObject("data");
            }catch (JSONException e){}
        }


         //   Toast.makeText(MainApplication.getContext(), "Error " , Toast.LENGTH_LONG).show();
//        Toast.makeText(MainApplication.getContext(), "SUCCESS " , Toast.LENGTH_LONG).show();
    }

    @Override
    public void runAsync(OnApiFinishListener onApiFinishListener) {
        if (connection.isConnectingToInternet())
            super.runAsync(onApiFinishListener);

    }

    @Override
    public void onError(Call<ResponseBody> requestBodyCall, Throwable t) {
        errorMessage = t.getMessage();
    }

    private String res;
    public String Result() {
        return res;
    }

    private boolean isValidResponse;

    public boolean isValidResponse() {
        return isValidResponse;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
