package com.investigation.investigationsystem.business.emphases.bean;

import java.util.List;

/**
 * Created by zero on 2016/7/10.
 * 这是地区数据模型
 */
public class MonitoringArea {

    private String areaname;
    private String areaID;
    private List<MonitoringPerson> monitoringPerson;

    @Override
    public String toString() {
        return "MonitoringArea{" +
                "areaname='" + areaname + '\'' +
                ", areaID='" + areaID + '\'' +
                ", monitoringPerson=" + monitoringPerson +
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
        return monitoringPerson;
    }

    public void setMonitoringPerson(List<MonitoringPerson> monitoringPerson) {
        this.monitoringPerson = monitoringPerson;
    }

}
