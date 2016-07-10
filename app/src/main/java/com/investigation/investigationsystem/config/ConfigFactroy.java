package com.investigation.investigationsystem.config;

/**
 * ==========================================
 * <p/>
 * 版    权 ： 北京爱接力科技有限公司
 * <p/>
 * 作    者 ： iwen
 * <p/>
 * 版    本 ： 1.0
 * <p/>
 * 创建日期 ： on 2016/7/9  23:52
 * <p/>
 * 描    述 ：
 * <p/>
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class ConfigFactroy {

    public static final String TAG = "debug";
    //登录接口
    public final static String Login = "/APP/Login";
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

    public static IConfig getConfig() {
        switch (TAG) {
            case "debug":
                return new DebugConfig();
            default:
                return new DebugConfig();
        }
    }

}
