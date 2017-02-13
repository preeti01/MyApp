package com.example.preeti.myapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.preeti.myapp.Content.EventDetails;
import com.example.preeti.myapp.R;
import com.example.preeti.myapp.activity.BaseActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.example.preeti.myapp.MainApplication.getContext;

/**
 * Created by preeti on 2/6/2017.
 */

public class EventListAdapter extends BaseAdapter {


    ArrayList<EventDetails> eventList;

    public EventListAdapter(BaseActivity activity, ArrayList<EventDetails> eventsList)
    {
        this.eventList=eventsList;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        EventDetails event = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_events, parent, false);
        }
        // Lookup view for data population
        TextView txtName = (TextView) convertView.findViewById(R.id.txtName);
        ImageView imgIcon=(ImageView) convertView.findViewById(R.id.imgIcon);
        TextView txtDesc=(TextView) convertView.findViewById(R.id.txtShortDesc);
        TextView txtTime=(TextView) convertView.findViewById(R.id.txttime);

        txtName.setText(eventList.get(position).getEventTitle());
        txtDesc.setText(eventList.get(position).getEventShortDescription());
        txtTime.setText(eventList.get(position).getEventStartDate());
        Picasso.with(getContext())
                .load(eventList.get(position).getEventImage()).into(imgIcon);


        // Return the completed view to render on screen
        return convertView;

    }
    @Override
    public EventDetails getItem(int position) {
        return eventList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public int getCount() {
        return eventList.size();
    }




}
