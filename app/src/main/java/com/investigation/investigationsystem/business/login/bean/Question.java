package com.investigation.investigationsystem.business.login.bean;

/**
 * ==========================================
 * <p/>
 * 版    权 ： 北京爱接力科技有限公司
 * <p/>
 * 作    者 ： iwen
 * <p/>
 * 版    本 ： 1.0
 * <p/>
 * 创建日期 ： on 2016/7/10  23:28
 * <p/>
 * 描    述 ：
 * 题目数据模型
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class Question {
    public String questionnaireID;
    public String questionnaireTitle;

    public String getQuestionnaireID() {
        return questionnaireID;
    }

    public void setQuestionnaireID(String questionnaireID) {
        this.questionnaireID = questionnaireID;
    }

    public String getQuestionnaireTitle() {
        return questionnaireTitle;
    }

    public void setQuestionnaireTitle(String questionnaireTitle) {
        this.questionnaireTitle = questionnaireTitle;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionnaireID='" + questionnaireID + '\'' +
                ", questionnaireTitle='" + questionnaireTitle + '\'' +
                '}';
    }
}
