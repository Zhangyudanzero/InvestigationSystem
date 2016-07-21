package com.investigation.investigationsystem.business.qusetionnaire.bean;

import java.util.List;

/**
 * 问卷调查 答案 包含单选多选和填空
 *
 * Created by zero on 2016/7/10.
 */
public class questionnaireResultContent {

    private String questionid ;
    private List<String> resultcontent;

    public void setQuestionid (String questionid ) {
        this.questionid  = questionid ;
    }
    public String getQuestionid () {
        return questionid ;
    }

    public void setResultcontent(List<String> resultcontent) {
        this.resultcontent = resultcontent;
    }
    public List<String> getResultcontent() {
        return resultcontent;
    }

    @Override
    public String toString() {
        return "questionnaireResultContent{" +
                "questionid='" + questionid + '\'' +
                ", resultcontent=" + resultcontent +
                '}';
    }
}
