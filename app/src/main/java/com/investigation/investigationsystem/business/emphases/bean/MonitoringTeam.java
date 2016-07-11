package com.investigation.investigationsystem.business.emphases.bean;

import java.util.List;

/**
 * Created by zero on 2016/7/10.
 * 这是团队数据模型
 */
public class MonitoringTeam {

    private String teamname;
    private String teamID;
    private List<MonitoringArea> MonitoringArea;

    @Override
    public String toString() {
        return "MonitoringTeam{" +
                "teamname='" + teamname + '\'' +
                ", teamID='" + teamID + '\'' +
                ", MonitoringArea=" + MonitoringArea +
                '}';
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getTeamID() {
        return teamID;
    }

    public void setTeamID(String teamID) {
        this.teamID = teamID;
    }

    public List<MonitoringArea> getMonitoringArea() {
        return MonitoringArea;
    }

    public void setMonitoringArea(List<MonitoringArea> monitoringArea) {
        this.MonitoringArea = monitoringArea;
    }


}
