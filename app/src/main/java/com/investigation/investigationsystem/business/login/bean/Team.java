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
 * 创建日期 ： on 2016/7/10  23:25
 * <p/>
 * 描    述 ：
 * 登陆返回团队数据类型
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class Team {

    public String teamName;
    public String teamID;
    public String profession;
    public List<Question> teamQuestionnaire;
    public List<Area> teamArea;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamID() {
        return teamID;
    }

    public void setTeamID(String teamID) {
        this.teamID = teamID;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public List<Question> getTeamQuestionnaire() {
        return teamQuestionnaire;
    }

    public void setTeamQuestionnaire(List<Question> teamQuestionnaire) {
        this.teamQuestionnaire = teamQuestionnaire;
    }

    public List<Area> getTeamArea() {
        return teamArea;
    }

    public void setTeamArea(List<Area> teamArea) {
        this.teamArea = teamArea;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", teamID='" + teamID + '\'' +
                ", profession='" + profession + '\'' +
                ", teamQuestionnaire=" + teamQuestionnaire +
                ", teamArea=" + teamArea +
                '}';
    }
}
