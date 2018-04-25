package com.example.aldiros.myassistant;

/**
 * Created by aldiros on 25/04/2018.
 */

public class UserInformation {
    public String name;
    public String address;
    public String phone;
    public String pekerjaan;

    public UserInformation(){

    }

    public UserInformation(String name, String address, String phone, String pekerjaan) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.pekerjaan = pekerjaan;
    }
}
