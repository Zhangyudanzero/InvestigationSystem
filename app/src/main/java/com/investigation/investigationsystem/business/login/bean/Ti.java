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
 * 这是每道题
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class Ti  implements Serializable {

    public String questionID;
    public String questionTitle;
    public String questionNO;
    public String questionType;
    public List<TiOption> questionOption_list;

    public String getQuestionID() {
        return questionID;
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionNO() {
        return questionNO;
    }

    public void setQuestionNO(String questionNO) {
        this.questionNO = questionNO;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public List<TiOption> getQuestionOption_list() {
        return questionOption_list;
    }

    public void setQuestionOption_list(List<TiOption> questionOption_list) {
        this.questionOption_list = questionOption_list;
    }

    @Override
    public String toString() {
        return "Ti{" +
                "questionID='" + questionID + '\'' +
                ", questionTitle='" + questionTitle + '\'' +
                ", questionNO='" + questionNO + '\'' +
                ", questionType='" + questionType + '\'' +
                ", questionOption_list=" + questionOption_list +
                '}';
    }
}
