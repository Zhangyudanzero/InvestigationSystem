package com.investigation.investigationsystem.common.constants;

import com.investigation.investigationsystem.business.emphases.bean.MonitoringPerson;
import com.investigation.investigationsystem.business.login.bean.UserInfo;

import java.util.TreeMap;

/**
 * Created by zero on 2016/7/10.
 */
public class DataConstants {

    //
    public static MonitoringPerson monitoringConstants = null;
    // 本地缓存的用户登录信息
    public static TreeMap<String, UserInfo> userInfos = null;
    // 当前登录的用户信息
    public static UserInfo currentUserInfo = null;

}
