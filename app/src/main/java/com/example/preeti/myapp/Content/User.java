package com.example.preeti.myapp.Content;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

/**
 * Created by preeti on 2/3/2017.
 */

public class User {


    private String user_id, auth_key, firstname, lastname, email, phone, member_id;
    private boolean is_member;
    private JSONObject jsonObject;
    public User(JSONObject jsonObject)
    {
        if (jsonObject == null)
            jsonObject = new JSONObject();
        this.jsonObject=jsonObject;
        user_id = jsonObject.optString("user_id");
        auth_key = jsonObject.optString("auth_key");
        firstname = jsonObject.optString("firstname");

        lastname = jsonObject.optString("lastname");

        email = jsonObject.optString("email");
        phone = jsonObject.optString("phone");
        member_id = jsonObject.optString("member_id");

        is_member = jsonObject.optString("is_member").contains("1");
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public boolean is_member() {
        return is_member;
    }

    public void setIs_member(boolean is_member) {
        this.is_member = is_member;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastname() {
        return lastname;

    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAuth_key() {
        return auth_key;

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setAuth_key(String auth_key) {
        this.auth_key = auth_key;

    }
/*@SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("lastname")
    @Expose
    private String lastname;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("auth_key")
    @Expose
    private String authKey;
    @SerializedName("is_member")
    @Expose
    private Integer isMember;
    @SerializedName("member_id")
    @Expose
    private Integer memberId;
    @SerializedName("user_id")
    @Expose
    private Integer userId;*/



}