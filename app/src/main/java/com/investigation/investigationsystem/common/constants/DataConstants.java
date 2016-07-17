package com.investigation.investigationsystem.common.constants;

import com.investigation.investigationsystem.business.emphases.bean.MonitoringPerson;
import com.investigation.investigationsystem.business.login.bean.MyUserInfo;
import com.investigation.investigationsystem.business.login.bean.UserData;

/**
 * Created by zero on 2016/7/10.
 */
public class DataConstants {

    //
    public static MonitoringPerson monitoringConstants = null;
    // 本地缓存的用户登录信息
    public static UserData userInfos = null;
    // 当前登录的用户信息
    public static MyUserInfo currentMyUserInfo = null;
    //重点监测 选择的团队
    public static String emphasesTeam = null;
    //重点监测 选择的地区
    public static String emphasesArea = null;

}
