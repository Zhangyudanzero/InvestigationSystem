package com.investigation.investigationsystem.business.qusetionnaire.bean;

import java.util.List;

/**
 * Created by zero on 2016/7/21.
 */
public class JuanResult {

    private int size;
    private List<QusertionnaireResultList> qusertionnaireResultList;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<QusertionnaireResultList> getQusertionnaireResultList() {
        return qusertionnaireResultList;
    }

    public void setQusertionnaireResultList(List<QusertionnaireResultList> qusertionnaireResultList) {
        this.qusertionnaireResultList = qusertionnaireResultList;
    }

    @Override
    public String toString() {
        return "JuanResult{" +
                "size=" + size +
                ", qusertionnaireResultList=" + qusertionnaireResultList +
                '}';
    }

}
