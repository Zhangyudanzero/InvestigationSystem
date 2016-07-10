package com.investigation.investigationsystem.business.emphases.bean;

import java.util.List;

/**
 * Created by zero on 2016/7/10.
 */
public class arealist {

    private String areaname;
    private String areaID;
    private List<Monitoringlist> monitoringlist;

    @Override
    public String toString() {
        return "arealist{" +
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

    public List<Monitoringlist> getMonitoringlist() {
        return monitoringlist;
    }

    public void setMonitoringlist(List<Monitoringlist> monitoringlist) {
        this.monitoringlist = monitoringlist;
    }

}
