package com.investigation.investigationsystem.business.update.bean;

/**
 * Created by zero on 2016/7/18.
 */
public class UserId {

    private String userID;

    public UserId(String userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "UserId{" +
                "userID='" + userID + '\'' +
                '}';
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
