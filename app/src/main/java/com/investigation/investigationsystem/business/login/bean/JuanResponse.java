package com.investigation.investigationsystem.business.login.bean;

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
 * 创建日期 ： on 2016/7/17  22:31
 * <p/>
 * 描    述 ：
 * 一张问卷
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class JuanResponse {

    private String result;
    private String updateTime;
    private int size;
    private List<Juan> questionnaire_YES;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Juan> getQuestionnaire_YES() {
        return questionnaire_YES;
    }

    public void setQuestionnaire_YES(List<Juan> questionnaire_YES) {
        this.questionnaire_YES = questionnaire_YES;
    }


}
