package com.investigation.investigationsystem.business.login.bean;

import java.util.List;

/**
 * ==========================================
 * <p/>
 * 版    权 ： 北京爱接力科技有限公司
 * <p/>
 * 作    者 ： iwen
 * <p/>
 * 版    本 ： 1.0
 * <p/>
 * 创建日期 ： on 2016/7/10  22:38
 * <p/>
 * 描    述 ：
 * 这是用户登陆获取到的信息模型
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class UserInfo {

    public String result;
    public String updateTime;
    public String name;
    public String password;
    public String userID;
    public List<Team> teamList;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "result='" + result + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", userID='" + userID + '\'' +
                ", teamList=" + teamList +
                '}';
    }
}
