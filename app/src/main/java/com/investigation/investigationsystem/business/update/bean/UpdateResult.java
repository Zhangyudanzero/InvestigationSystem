package com.investigation.investigationsystem.business.update.bean;

/**
 * 监测更新返回的结果
 *
 * Created by zero on 2016/7/18.
 */
public class UpdateResult {

    private int result;
    private int questionnaireUpdate;
    private int monitorUpdate;
    private int userInfoUpdate;

    @Override
    public String toString() {
        return "UpdateResult{" +
                "result=" + result +
                ", questionnaireUpdate=" + questionnaireUpdate +
                ", monitorUpdate=" + monitorUpdate +
                ", userInfoUpdate=" + userInfoUpdate +
                '}';
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getUserInfoUpdate() {
        return userInfoUpdate;
    }

    public void setUserInfoUpdate(int userInfoUpdate) {
        this.userInfoUpdate = userInfoUpdate;
    }

    public int getMonitorUpdate() {
        return monitorUpdate;
    }

    public void setMonitorUpdate(int monitorUpdate) {
        this.monitorUpdate = monitorUpdate;
    }

    public int getQuestionnaireUpdate() {
        return questionnaireUpdate;
    }

    public void setQuestionnaireUpdate(int questionnaireUpdate) {
        this.questionnaireUpdate = questionnaireUpdate;
    }
}
