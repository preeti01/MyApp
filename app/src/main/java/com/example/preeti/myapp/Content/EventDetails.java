package com.example.preeti.myapp.Content;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by preeti on 2/6/2017.
 */

public class EventDetails {

    private Integer eventId,eventImageHeight,eventImageWidth,userTotalTicketCount,userTotalMemberTicketCount,userTotalNonMemberTicketCount,
            eventTotalTicket;
    private String eventTitle, eventShortDescription,eventDescription, shareUrl,eventImage,eventStartDate,eventEndDate,eventNote,eventWebsite,
            eventMemberPrice, eventNonMemberPrice,email,phone;

    private boolean isInCalendar,eventIsPaid;


    private List<Object> paymentTransaction = null;

    private EventAddress address;
    private JSONObject object;

    // Constructor to convert JSON object into a Java class instance

    public EventDetails(JSONObject jsonObject)
    {
        if(jsonObject==null)
            jsonObject=new JSONObject();

        this.object=jsonObject;
        eventId=jsonObject.optInt("event_id");
        eventTitle=jsonObject.optString("event_title");
        eventShortDescription=jsonObject.optString("event_short_description");
        eventDescription=jsonObject.optString("event_description");
        shareUrl=jsonObject.optString("share_url");
        eventImage=jsonObject.optString("event_image");
        eventImageHeight=jsonObject.optInt("event_image_height");
        eventImageWidth=jsonObject.optInt("event_image_width");
        eventStartDate=jsonObject.optString("event_start_date");
        eventEndDate=jsonObject.optString("event_end_date");
        eventNote=jsonObject.optString("event_note");
        eventWebsite=jsonObject.optString("event_website");
        isInCalendar=jsonObject.optBoolean("is_in_calendar");
        userTotalTicketCount=jsonObject.optInt("user_total_ticket_count");
        userTotalMemberTicketCount=jsonObject.optInt("user_total_member_ticket_count");
        userTotalNonMemberTicketCount=jsonObject.optInt("user_total_non_member_ticket_count");
        eventIsPaid=jsonObject.optBoolean("event_is_paid");
        eventTotalTicket=jsonObject.optInt("event_total_ticket");
        eventMemberPrice=jsonObject.optString("event_member_price");
        eventNonMemberPrice=jsonObject.optString("event_non_member_price");
        email=jsonObject.optString("email");
        phone=jsonObject.optString("phone");
        address=new EventAddress(jsonObject.optJSONObject("address"));

    }


    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventShortDescription() {
        return eventShortDescription;
    }

    public void setEventShortDescription(String eventShortDescription) {
        this.eventShortDescription = eventShortDescription;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public String getEventImage() {
        return eventImage;
    }

    public void setEventImage(String eventImage) {
        this.eventImage = eventImage;
    }

    public Integer getEventImageHeight() {
        return eventImageHeight;
    }

    public void setEventImageHeight(Integer eventImageHeight) {
        this.eventImageHeight = eventImageHeight;
    }

    public Integer getEventImageWidth() {
        return eventImageWidth;
    }

    public void setEventImageWidth(Integer eventImageWidth) {
        this.eventImageWidth = eventImageWidth;
    }

    public String getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(String eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public String getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(String eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    public String getEventNote() {
        return eventNote;
    }

    public void setEventNote(String eventNote) {
        this.eventNote = eventNote;
    }

    public String getEventWebsite() {
        return eventWebsite;
    }

    public void setEventWebsite(String eventWebsite) {
        this.eventWebsite = eventWebsite;
    }

    public boolean getIsInCalendar() {
        return isInCalendar;
    }

    public void setIsInCalendar(boolean isInCalendar) {
        this.isInCalendar = isInCalendar;
    }

    public Integer getUserTotalTicketCount() {
        return userTotalTicketCount;
    }

    public void setUserTotalTicketCount(Integer userTotalTicketCount) {
        this.userTotalTicketCount = userTotalTicketCount;
    }

    public Integer getUserTotalMemberTicketCount() {
        return userTotalMemberTicketCount;
    }

    public void setUserTotalMemberTicketCount(Integer userTotalMemberTicketCount) {
        this.userTotalMemberTicketCount = userTotalMemberTicketCount;
    }

    public Integer getUserTotalNonMemberTicketCount() {
        return userTotalNonMemberTicketCount;
    }

    public void setUserTotalNonMemberTicketCount(Integer userTotalNonMemberTicketCount) {
        this.userTotalNonMemberTicketCount = userTotalNonMemberTicketCount;
    }

    public List<Object> getPaymentTransaction() {
        return paymentTransaction;
    }

    public void setPaymentTransaction(List<Object> paymentTransaction) {
        this.paymentTransaction = paymentTransaction;
    }

    public boolean getEventIsPaid() {
        return eventIsPaid;
    }

    public void setEventIsPaid(boolean eventIsPaid) {
        this.eventIsPaid = eventIsPaid;
    }

    public Integer getEventTotalTicket() {
        return eventTotalTicket;
    }

    public void setEventTotalTicket(Integer eventTotalTicket) {
        this.eventTotalTicket = eventTotalTicket;
    }

    public String getEventMemberPrice() {
        return eventMemberPrice;
    }

    public void setEventMemberPrice(String eventMemberPrice) {
        this.eventMemberPrice = eventMemberPrice;
    }

    public String getEventNonMemberPrice() {
        return eventNonMemberPrice;
    }

    public void setEventNonMemberPrice(String eventNonMemberPrice) {
        this.eventNonMemberPrice = eventNonMemberPrice;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public EventAddress getAddress() {
        return address;
    }

    public void setAddress(EventAddress address) {
        this.address = address;
    }

    public JSONObject getObject() {
        return object;
    }
// Method to convert an array of JSON objects into a list of objects

   /* public static ArrayList<EventDetails> fromJson(JSONArray jsonObjects) {
        ArrayList<EventDetails> eventDetailsArrayList = new ArrayList<EventDetails>();
        for (int i = 0; i < jsonObjects.length(); i++) {
            try {
                eventDetailsArrayList.add(new EventDetails(jsonObjects.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return eventDetailsArrayList;
    }*/


}
