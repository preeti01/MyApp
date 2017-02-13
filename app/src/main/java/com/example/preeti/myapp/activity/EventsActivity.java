package com.example.preeti.myapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.preeti.myapp.Content.EventDetails;
import com.example.preeti.myapp.R;
import com.example.preeti.myapp.adapter.EventListAdapter;
import com.example.preeti.myapp.api.BaseServiceable;
import com.example.preeti.myapp.api.EventListApi;

import java.util.ArrayList;

public class EventsActivity extends BaseActivity {

    ListView lstEvents;
    TextView txtCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        lstEvents = (ListView) findViewById(R.id.lstView1);
      //  txtCheck=(TextView) findViewById(R.id.txtcheck);
        EventListApi eventListApi = new EventListApi(getActivity());
        eventListApi.runAsync(eventsapi);
        setTitle("Events");




    }

    ArrayList<EventDetails> events;
    EventListAdapter adapter;

    private BaseServiceable.OnApiFinishListener<EventListApi> eventsapi = new BaseServiceable.OnApiFinishListener<EventListApi>() {

        @Override
        public void onComplete(EventListApi eventsListApi) {
            if (eventsListApi.isValidResponse()) {
                events = eventsListApi.getEventList();
                adapter = new EventListAdapter(getActivity(), events);
                lstEvents.setAdapter(adapter);
            }
            /*else
                txtCheck.setText("error");*/



        }

    };

}



