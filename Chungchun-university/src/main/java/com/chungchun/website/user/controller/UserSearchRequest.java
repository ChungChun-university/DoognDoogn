package com.chungchun.website.user.controller;

public class UserSearchRequest {
    private String userName;
    private String userPhone;

    // 기본 생성자
    public UserSearchRequest() {}

    // Getter와 Setter
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
