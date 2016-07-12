package com.investigation.investigationsystem.business.emphases.bean;

import java.util.List;

/**
 * Created by zero on 2016/7/10.
 * 这是地区数据模型
 */
public class MonitoringArea {

    private String areaname;
    private String areaID;
    private List<MonitoringPerson> monitoringlist;

    @Override
    public String toString() {
        return "MonitoringArea{" +
                "areaname='" + areaname + '\'' +
                ", areaID='" + areaID + '\'' +
                ", monitoringlist=" + monitoringlist +
                '}';
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public String getAreaID() {
        return areaID;
    }

    public void setAreaID(String areaID) {
        this.areaID = areaID;
    }

    public List<MonitoringPerson> getMonitoringPerson() {
        return monitoringlist;
    }

    public void setMonitoringPerson(List<MonitoringPerson> monitoringPerson) {
        this.monitoringlist = monitoringPerson;
    }

}
