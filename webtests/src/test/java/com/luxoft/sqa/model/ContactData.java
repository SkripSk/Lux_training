package com.luxoft.sqa.model;

public class ContactData {

    String firstName;
    String middleNameOrInital;
    String lastName;
    String nickname;
    String telephoneMobile;
    int id;

    public ContactData(String firstName, String middleNameOrInital, String lastName, String nickname, String telephoneMobile) {
        this.firstName = firstName;
        this.middleNameOrInital = middleNameOrInital;
        this.lastName = lastName;
        this.nickname = nickname;
        this.telephoneMobile = telephoneMobile;
    }

    public ContactData(int id, String firstName, String middleNameOrInital, String lastName, String nickname, String telephoneMobile) {
        this.firstName = firstName;
        this.middleNameOrInital = middleNameOrInital;
        this.lastName = lastName;
        this.nickname = nickname;
        this.telephoneMobile = telephoneMobile;
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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


}
