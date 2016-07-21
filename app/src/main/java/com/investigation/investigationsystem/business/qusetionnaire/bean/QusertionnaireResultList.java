package com.investigation.investigationsystem.business.qusetionnaire.bean;

import java.util.List;

/**
 * Created by zero on 2016/7/21.
 */
public class QusertionnaireResultList {

    private qusertionnaireResult qusertionnaireResult;
    private List<questionnaireResultContent> questionnaireResultContent;

    public qusertionnaireResult getQusertionnaireResult() {
        return qusertionnaireResult;
    }

    public void setQusertionnaireResult(qusertionnaireResult qusertionnaireResult) {
        this.qusertionnaireResult = qusertionnaireResult;
    }

    public List<questionnaireResultContent> getQuestionnaireResultContent() {
        return questionnaireResultContent;
    }

    public void setQuestionnaireResultContent(List<questionnaireResultContent> questionnaireResultContent) {
        this.questionnaireResultContent = questionnaireResultContent;
    }

    @Override
    public String toString() {
        return "QusertionnaireResultList{" +
                "qusertionnaireResult=" + qusertionnaireResult +
                ", questionnaireResultContent=" + questionnaireResultContent +
                '}';
    }
}
