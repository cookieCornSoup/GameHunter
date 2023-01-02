package com.example.gamehunter.view;

public class User {
    private String profile;
    private String id;
    private int pw;
    private String UserName;


    public User(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPw() {
        return pw;
    }

    public String getProfile() {return profile;}

    public void setProfile(String profile) {this.profile = profile;}

    public void setPw(int pw) {
        this.pw = pw;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }
}
