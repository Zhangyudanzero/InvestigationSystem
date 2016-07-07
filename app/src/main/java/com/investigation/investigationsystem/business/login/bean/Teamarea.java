package com.investigation.investigationsystem.business.login.bean;

/**
 * Created by zero on 2016/7/7.
 */
public class Teamarea {

    private String areaname;
    private String areaid;

    public Teamarea() {
    }

    @Override
    public String toString() {
        return "Teamarea{" +
                "areaname='" + areaname + '\'' +
                ", areaid='" + areaid + '\'' +
                '}';
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }
    public String getAreaname() {
        return areaname;
    }

    public void setAreaid(String areaid) {
        this.areaid = areaid;
    }
    public String getAreaid() {
        return areaid;
    }


}
