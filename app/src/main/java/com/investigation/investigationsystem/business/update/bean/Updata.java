package com.investigation.investigationsystem.business.update.bean;

/**
 * 监测是否有最新数据
 *
 * Created by zero on 2016/7/17.
 */
public class Updata {

    private String userID;
    private String time;
    private String time2;
    private String time3;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public String getTime3() {
        return time3;
    }

    public void setTime3(String time3) {
        this.time3 = time3;
    }

    @Override
    public String toString() {
        return "Updata{" +
                "userID='" + userID + '\'' +
                ", time='" + time + '\'' +
                ", time2='" + time2 + '\'' +
                ", time3='" + time3 + '\'' +
                '}';
    }

    public Updata(String userID, String time, String time2, String time3) {
        this.userID = userID;
        this.time = time;
        this.time2 = time2;
        this.time3 = time3;
    }
}
