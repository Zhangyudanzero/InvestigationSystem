package com.investigation.investigationsystem.common.constants;

import com.investigation.investigationsystem.business.emphases.bean.MonitoringPerson;
import com.investigation.investigationsystem.business.login.bean.Juan;
import com.investigation.investigationsystem.business.login.bean.MyUserInfo;
import com.investigation.investigationsystem.business.login.bean.UserData;
import com.investigation.investigationsystem.business.qusetionnaire.bean.qusertionnaireResult;

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
    //问卷调查选择团队
    public static String juanTeam = null;
    //问卷调查选择团队id
    public static String juanTeamId = null;
    //问卷调查选择卷子
    public static String juanJuan = null;
    //问卷调查选择卷子id
    public static String juanJuanId = null;
    //问卷调查选择地域
    public static String juanArea = null;
    //问卷调查选择地域id
    public static String JuanAreaId = null;
    //开始答题的问卷
    public static Juan juan = null;
    //当前被调查人信息 答题完成后保存 或取消答题后清除
    public static qusertionnaireResult researchInfo = null;

}
