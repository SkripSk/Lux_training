package com.luxoft.sqa.model;

public class NewAddressData {

    public NewAddressData(String firstName, String middleNameOrInital, String lastName, String nickname, String telephoneMobile) {
        this.firstName = firstName;
        this.middleNameOrInital = middleNameOrInital;
        this.lastName = lastName;
        this.nickname = nickname;
        this.telephoneMobile = telephoneMobile;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleNameOrInital() {
        return middleNameOrInital;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTelephoneMobile() {
        return telephoneMobile;
    }

    String firstName;
    String middleNameOrInital;
    String lastName;
    String nickname;
    String telephoneMobile;
}
