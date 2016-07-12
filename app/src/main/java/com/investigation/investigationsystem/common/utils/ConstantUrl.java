package com.investigation.investigationsystem.common.utils;

/**
 * 所有的接口数据
 *
 * Created by zero on 2016/7/9.
 */
public class ConstantUrl {


    //测试接口
//    public final static String url = "http://192.168.1.101:8080/wenjuan";
//    public final static String url = "http://192.168.56.1:8080/wenjuan";
    public final static String url = "http://192.168.137.1:8080/wenjuan";

    //登录接口
    public final static String Login = "/APP/url_login";
    //修改密码
    public final static String changePassword = "/APP/ChangePassword";
    //提交问卷
    public final static String saveQuestionnaire = "/APP/SaveQuestionnaireResult";
    //提交客服反馈
    public final static String saveFeedBack = "/APP/SaveFeedback";
    //检查数据更新接口
    public final static String checkUpdate = "/APP/CheckUpdate";
    //获取团队问卷
    public final static String getTeamQuestionnaire = "/APP/GETQuestionnaire";
    //获取重点疾病监测对象
    public final static String getFocusMonitoring = "/APP/GETFocusMonitoring";
    //获取用户信息以及相关团队
    public final static String getUserInfo = "/APP/GetUserInfo";

}
