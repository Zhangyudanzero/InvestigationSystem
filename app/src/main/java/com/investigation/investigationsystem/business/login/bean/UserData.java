package com.investigation.investigationsystem.business.login.bean;

import java.util.HashMap;

/**
 * ==========================================
 * <p/>
 * 版    权 ： 北京爱接力科技有限公司
 * <p/>
 * 作    者 ： iwen
 * <p/>
 * 版    本 ： 1.0
 * <p/>
 * 创建日期 ： on 2016/7/17  14:04
 * <p/>
 * 描    述 ：
 * 这是存储用户信息的数据模型
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class UserData {

    public HashMap<String, MyUserInfo> data;

    public UserData() {
    }

    public UserData(HashMap<String, MyUserInfo> data) {
        this.data = data;
    }

    public HashMap<String, MyUserInfo> getData() {
        return data;
    }

    public void setData(HashMap<String, MyUserInfo> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "data=" + data +
                '}';
    }
}
