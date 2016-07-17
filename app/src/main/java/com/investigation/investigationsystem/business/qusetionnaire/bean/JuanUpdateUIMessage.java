package com.investigation.investigationsystem.business.qusetionnaire.bean;

/**
 * ==========================================
 * <p/>
 * 版    权 ： 北京爱接力科技有限公司
 * <p/>
 * 作    者 ： iwen
 * <p/>
 * 版    本 ： 1.0
 * <p/>
 * 创建日期 ： on 2016/7/18  2:01
 * <p/>
 * 描    述 ：
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class JuanUpdateUIMessage {

    public int functionl;
    public String titlename;

    public JuanUpdateUIMessage() {
    }

    public JuanUpdateUIMessage(int functionl, String titlename) {
        this.functionl = functionl;
        this.titlename = titlename;
    }

    public int getFunctionl() {
        return functionl;
    }

    public void setFunctionl(int functionl) {
        this.functionl = functionl;
    }

    public String getTitlename() {
        return titlename;
    }

    public void setTitlename(String titlename) {
        this.titlename = titlename;
    }

    @Override
    public String toString() {
        return "JuanUpdateUIMessage{" +
                "functionl=" + functionl +
                ", titlename='" + titlename + '\'' +
                '}';
    }
}
