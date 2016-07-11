package com.investigation.investigationsystem.business.emphases.bean;

/**
 * Created by zero on 2016/7/10.
 */
public class MonitoringPerson {

    /**
     * name : 你猜
     * iDNO : 120111199901011234
     * female : 1
     * age : 37
     * nation : 汉
     * address : 天津市南开区
     * address2 : 北京市朝阳区
     * disease : 尘肺
     * tutelageFreq : 每周一次
     * tutelageWay : 住院
     * tutelageContent : 心律
     * doctor : 张生
     * time : 2016/3/2
     */
    private String name;
    private String iDNO;
    private int female;
    private int age;
    private String nation;
    private String address;
    private String address2;
    private String disease;
    private String tutelageFreq;
    private String tutelageWay;
    private String tutelageContent;
    private String doctor;
    private String time;

    @Override
    public String toString() {
        return "MonitoringPerson{" +
                "name='" + name + '\'' +
                ", iDNO='" + iDNO + '\'' +
                ", female=" + female +
                ", age=" + age +
                ", nation='" + nation + '\'' +
                ", address='" + address + '\'' +
                ", address2='" + address2 + '\'' +
                ", disease='" + disease + '\'' +
                ", tutelageFreq='" + tutelageFreq + '\'' +
                ", tutelageWay='" + tutelageWay + '\'' +
                ", tutelageContent='" + tutelageContent + '\'' +
                ", doctor='" + doctor + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIDNO() {
        return iDNO;
    }

    public void setIDNO(String iDNO) {
        this.iDNO = iDNO;
    }

    public int getFemale() {
        return female;
    }

    public void setFemale(int female) {
        this.female = female;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getTutelageFreq() {
        return tutelageFreq;
    }

    public void setTutelageFreq(String tutelageFreq) {
        this.tutelageFreq = tutelageFreq;
    }

    public String getTutelageWay() {
        return tutelageWay;
    }

    public void setTutelageWay(String tutelageWay) {
        this.tutelageWay = tutelageWay;
    }

    public String getTutelageContent() {
        return tutelageContent;
    }

    public void setTutelageContent(String tutelageContent) {
        this.tutelageContent = tutelageContent;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
