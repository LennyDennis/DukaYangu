package com.lennydennis.dukayangu.model;

public class User {
    private String userName;
    private String userEmail;
    private String phoneNumber;

    public User() {
    }

    public User(String userName, String userEmail, String phoneNumber) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
