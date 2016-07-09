package com.investigation.investigationsystem.business.login.bean;

/**
 * Created by zero on 2016/7/7.
 */
public class Teamquestionnaire {

    private String questionnaireid;
    private String questionnairetitle;

    public Teamquestionnaire() {
    }

    @Override
    public String toString() {
        return "Teamquestionnaire{" +
                "questionnaireid='" + questionnaireid + '\'' +
                ", questionnairetitle='" + questionnairetitle + '\'' +
                '}';
    }

    public void setQuestionnaireid(String questionnaireid) {
        this.questionnaireid = questionnaireid;
    }
    public String getQuestionnaireid() {
        return questionnaireid;
    }

    public void setQuestionnairetitle(String questionnairetitle) {
        this.questionnairetitle = questionnairetitle;
    }
    public String getQuestionnairetitle() {
        return questionnairetitle;
    }

}
