package com.investigation.investigationsystem.business.login.bean;

import java.util.List;

/**
 * Created by zero on 2016/7/7.
 */
public class UserInfo {

    private int result;
    private String updatetime;
    private String name;
    private String password;
    private String userid;
    private List<TeamList> teamlist;

    public UserInfo() {
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "result=" + result +
                ", updatetime='" + updatetime + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", userid='" + userid + '\'' +
                ", teamlist=" + teamlist +
                '}';
    }

    public void setResult(int result) {
        this.result = result;
    }
    public int getResult() {
        return result;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }
    public String getUpdatetime() {
        return updatetime;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getUserid() {
        return userid;
    }

    public void setTeamlist(List<TeamList> teamlist) {
        this.teamlist = teamlist;
    }
    public List<TeamList> getTeamlist() {
        return teamlist;
    }


}
