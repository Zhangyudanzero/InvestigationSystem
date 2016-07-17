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
public class MyUserInfo {

    public int result;
    public String updateTime;
    public String name;
    public String password;
    public String userID;
    public String account; // 账号
    public List<Team> teamList;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
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
        return "MyUserInfo{" +
                "result=" + result +
                ", updateTime='" + updateTime + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", userID='" + userID + '\'' +
                ", account='" + account + '\'' +
                ", teamList=" + teamList +
                '}';
    }
}
