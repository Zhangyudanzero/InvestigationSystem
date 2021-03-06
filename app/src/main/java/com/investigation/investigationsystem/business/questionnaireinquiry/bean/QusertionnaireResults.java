package com.investigation.investigationsystem.business.questionnaireinquiry.bean;

/**
 * Created by zero on 2016/7/12.
 */
public class QusertionnaireResults {

    private String teamid;
    private String areaid;
    private String userid;
    private String questionnaireid;

    public String getQuestionnairename() {
        return questionnairename;
    }

    public void setQuestionnairename(String questionnairename) {
        this.questionnairename = questionnairename;
    }

    public String getiDNO() {
        return iDNO;
    }

    public void setiDNO(String iDNO) {
        this.iDNO = iDNO;
    }

    private String questionnairename;
    private String time;
    private String name;
    private String iDNO;
    private int female;
    private int age;
    private String nation;
    private String tel;
    private String address;
    private String address2;
    private String contact;
    private String contacttel;
    private String relation;

    @Override
    public String toString() {
        return "QusertionnaireResults{" +
                "teamid='" + teamid + '\'' +
                ", areaid='" + areaid + '\'' +
                ", account='" + userid + '\'' +
                ", questionnaireid='" + questionnaireid + '\'' +
                ", questionnairename='" + questionnairename + '\'' +
                ", time='" + time + '\'' +
                ", name='" + name + '\'' +
                ", iDNO='" + iDNO + '\'' +
                ", female=" + female +
                ", age=" + age +
                ", nation='" + nation + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", address2='" + address2 + '\'' +
                ", contact='" + contact + '\'' +
                ", contacttel='" + contacttel + '\'' +
                ", relation='" + relation + '\'' +
                '}';
    }

    public void setTeamid(String teamid) {
        this.teamid = teamid;
    }
    public String getTeamid() {
        return teamid;
    }

    public void setAreaid(String areaid) {
        this.areaid = areaid;
    }
    public String getAreaid() {
        return areaid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getUserid() {
        return userid;
    }

    public void setQuestionnaireid(String questionnaireid) {
        this.questionnaireid = questionnaireid;
    }
    public String getQuestionnaireid() {
        return questionnaireid;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public String getTime() {
        return time;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setIdno(String idno) {
        this.iDNO = idno;
    }
    public String getIdno() {
        return iDNO;
    }

    public void setFemale(int female) {
        this.female = female;
    }
    public int getFemale() {
        return female;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }
    public String getNation() {
        return nation;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getTel() {
        return tel;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }
    public String getAddress2() {
        return address2;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getContact() {
        return contact;
    }

    public void setContacttel(String contacttel) {
        this.contacttel = contacttel;
    }
    public String getContacttel() {
        return contacttel;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
    public String getRelation() {
        return relation;
    }


}
