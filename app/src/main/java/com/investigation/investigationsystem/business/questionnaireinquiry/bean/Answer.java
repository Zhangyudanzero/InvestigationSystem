package com.investigation.investigationsystem.business.questionnaireinquiry.bean;

import java.util.List;

/**
 * 问卷查询答案
 *
 * Created by zero on 2016/7/12.
 */
public class Answer {

    private int size;
    private List<QusertionnaireResult> qusertionnaireResultList;

    @Override
    public String toString() {
        return "Answer{" +
                "size=" + size +
                ", qusertionnaireResultList=" + qusertionnaireResultList +
                '}';
    }

    public void setSize(int size) {
        this.size = size;
    }
    public int getSize() {
        return size;
    }

    public void setQusertionnaireresultlist(List<QusertionnaireResult> qusertionnaireresultlist) {
        this.qusertionnaireResultList = qusertionnaireresultlist;
    }
    public List<QusertionnaireResult> getQusertionnaireresultlist() {
        return qusertionnaireResultList;
    }

}


