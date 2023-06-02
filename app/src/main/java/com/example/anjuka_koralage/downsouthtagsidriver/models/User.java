package com.example.anjuka_koralage.downsouthtagsidriver.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("first_name")
    @Expose
    private String first_name;

    @SerializedName("last_name")
    @Expose
    private String last_name;

    @SerializedName("user_name")
    @Expose
    private String user_name;

    @SerializedName("user_bod")
    @Expose
    private String user_dob;

    @SerializedName("nic")
    @Expose
    private String nic;

    @SerializedName("gender")
    @Expose
    private String gender;

    @SerializedName("mob_number")
    @Expose
    private String mob_number;

    @SerializedName("address")
    @Expose
    private String address;

    @SerializedName("home_town")
    @Expose
    private String home_town;

    @SerializedName("password")
    @Expose
    private String password;

    public User(String first_name, String last_name, String user_name, String user_dob, String nic, String gender, String mob_number, String address, String home_town, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.user_name = user_name;
        this.user_dob = user_dob;
        this.nic = nic;
        this.gender = gender;
        this.mob_number = mob_number;
        this.address = address;
        this.home_town = home_town;
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_dob() {
        return user_dob;
    }

    public void setUser_dob(String user_dob) {
        this.user_dob = user_dob;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMob_number() {
        return mob_number;
    }

    public void setMob_number(String mob_number) {
        this.mob_number = mob_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHome_town() {
        return home_town;
    }

    public void setHome_town(String home_town) {
        this.home_town = home_town;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
