package com.investigation.investigationsystem.business.questionnaireinquiry.bean;

import java.util.List;

/**
 * Created by zero on 2016/7/12.
 */
public class QuestionnaireResultContent {

    private String questionid;
    private List<String> resultcontent;

    @Override
    public String toString() {
        return "QuestionnaireResultContent{" +
                "questionid='" + questionid + '\'' +
                ", resultcontent=" + resultcontent +
                '}';
    }

    public void setQuestionid(String questionid) {
        this.questionid = questionid;
    }
    public String getQuestionid() {
        return questionid;
    }

    public void setResultcontent(List<String> resultcontent) {
        this.resultcontent = resultcontent;
    }
    public List<String> getResultcontent() {
        return resultcontent;
    }


}
