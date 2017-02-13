package com.example.preeti.myapp.Content;

import org.json.JSONObject;

/**
 * Created by preeti on 2/6/2017.
 */

public class EventAddress {


    private String streetAddress,city,state,zip;

    public EventAddress(JSONObject address)
    {
        if (address == null)
            address = new JSONObject();

        streetAddress = address.optString("street_address");
        city = address.optString("city");
        state = address.optString("state");
        zip = address.optString("zip");
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
