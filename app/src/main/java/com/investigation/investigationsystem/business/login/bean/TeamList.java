package com.investigation.investigationsystem.business.login.bean;

import java.util.List;

/**
 * Created by zero on 2016/7/7.
 */
public class TeamList {

    private String teamname;
    private String teamid;
    private String profession;
    private List<Teamquestionnaire> teamquestionnaire;
    private List<Teamarea> teamarea;

    public TeamList() {
    }

    @Override
    public String toString() {
        return "TeamList{" +
                "teamname='" + teamname + '\'' +
                ", teamid='" + teamid + '\'' +
                ", profession='" + profession + '\'' +
                ", teamquestionnaire=" + teamquestionnaire +
                ", teamarea=" + teamarea +
                '}';
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }
    public String getTeamname() {
        return teamname;
    }

    public void setTeamid(String teamid) {
        this.teamid = teamid;
    }
    public String getTeamid() {
        return teamid;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
    public String getProfession() {
        return profession;
    }

    public void setTeamquestionnaire(List<Teamquestionnaire> teamquestionnaire) {
        this.teamquestionnaire = teamquestionnaire;
    }
    public List<Teamquestionnaire> getTeamquestionnaire() {
        return teamquestionnaire;
    }

    public void setTeamarea(List<Teamarea> teamarea) {
        this.teamarea = teamarea;
    }
    public List<Teamarea> getTeamarea() {
        return teamarea;
    }


}
