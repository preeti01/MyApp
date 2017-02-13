package com.example.preeti.myapp.api;

import android.app.Activity;

import com.example.preeti.myapp.Content.EventDetails;
import com.example.preeti.myapp.Content.User;
import com.example.preeti.myapp.Services.ChamberService;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by preeti on 2/6/2017.
 */

public class EventListApi extends Base{


    public EventListApi(Activity EventsActivity) {
        super();
        setUrl("http://s171227279.onlinehome.us/ecom/nkcc/public/index.php/api/v1/event/getAllEvents");
        setRequestType(BaseServiceable.REQUEST_TYPE.GET);
        addCommonHeaders();
         addParam("userId",ChamberService.getUser().getUser_id() );
        // addParam("User id","678" );
    }


    ArrayList<EventDetails> eventList;

    public void onPostRun(int statusCode, String response) {
        super.onPostRun(statusCode, response);
        if(isValidResponse()) {
            JSONArray jsonArray = getData().optJSONArray("events");
            eventList=new ArrayList<>(jsonArray.length());
            for(int i=0;i<jsonArray.length();i++) {
                eventList.add(new EventDetails(jsonArray.optJSONObject(i)));
            }

        }
    }
    public ArrayList<EventDetails> getEventList()
    {
        return eventList;
    }
}
