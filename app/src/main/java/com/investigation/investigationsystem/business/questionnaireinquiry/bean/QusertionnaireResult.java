package com.investigation.investigationsystem.business.questionnaireinquiry.bean;

import java.util.List;

/**
 * Created by zero on 2016/7/12.
 */
public class QusertionnaireResult {

    private QusertionnaireResults qusertionnaireResult;
    private List<QuestionnaireResultContent> questionnaireResultContent;

    @Override
    public String toString() {
        return "QusertionnaireResult{" +
                "qusertionnaireresult=" + qusertionnaireResult +
                ", questionnaireresultcontent=" + questionnaireResultContent +
                '}';
    }

    public void setQusertionnaireresult(QusertionnaireResults qusertionnaireresult) {
        this.qusertionnaireResult = qusertionnaireresult;
    }
    public QusertionnaireResults getQusertionnaireresult() {
        return qusertionnaireResult;
    }

    public void setQuestionnaireresultcontent(List<QuestionnaireResultContent> questionnaireresultcontent) {
        this.questionnaireResultContent = questionnaireresultcontent;
    }
    public List<QuestionnaireResultContent> getQuestionnaireresultcontent() {
        return questionnaireResultContent;
    }


}
