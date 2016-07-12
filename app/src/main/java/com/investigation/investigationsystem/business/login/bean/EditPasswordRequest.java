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
 * 创建日期 ： on 2016/7/12  13:18
 * <p/>
 * 描    述 ：修改密码的网络操作
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class EditPasswordRequest {

    public String userid;
    public String oldpassword;
    public String newpassword;

    public EditPasswordRequest() {
    }

    public EditPasswordRequest(String userid, String oldpassword, String newpassword) {
        this.userid = userid;
        this.oldpassword = oldpassword;
        this.newpassword = newpassword;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getOldpassword() {
        return oldpassword;
    }

    public void setOldpassword(String oldpassword) {
        this.oldpassword = oldpassword;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    @Override
    public String toString() {
        return "EditPasswordRequest{" +
                "userid='" + userid + '\'' +
                ", oldpassword='" + oldpassword + '\'' +
                ", newpassword='" + newpassword + '\'' +
                '}';
    }
}
