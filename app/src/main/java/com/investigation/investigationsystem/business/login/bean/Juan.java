package com.investigation.investigationsystem.business.login.bean;

import java.io.Serializable;
import java.util.List;

/**
 * ==========================================
 * <p/>
 * 版    权 ： 北京爱接力科技有限公司
 * <p/>
 * 作    者 ： iwen
 * <p/>
 * 版    本 ： 1.0
 * <p/>
 * 创建日期 ： on 2016/7/17  17:34
 * <p/>
 * 描    述 ：
 * 这是每张卷子
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */

public class Juan implements Serializable {
    private String questionnaireID;
    private String subject;
    private String title;
    private List<Ti> questionList;

    public String getQuestionnaireID() {
        return questionnaireID;
    }

    public void setQuestionnaireID(String questionnaireID) {
        this.questionnaireID = questionnaireID;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Ti> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Ti> questionList) {
        this.questionList = questionList;
    }

}