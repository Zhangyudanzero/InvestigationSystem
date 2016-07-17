package com.investigation.investigationsystem.common.constants;

/**
 * ==========================================
 * <p/>
 * 版    权 ： 北京爱接力科技有限公司
 * <p/>
 * 作    者 ： iwen
 * <p/>
 * 版    本 ： 1.0
 * <p/>
 * 创建日期 ： on 2016/6/28  15:24
 * <p/>
 * 描    述 ：
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class StringConstants {

    public static final String TAG = "iwen";
    public static final String FORMAT = "-------->>  ";
    public static final String NET_TIMEOUT = "连接超时";
    public static final String NET_DATAERROR = "操作失败";
    public static final String NET_REQUESTDATA = FORMAT + "网络请求参数：";
    public static final String NET_GETDATA = FORMAT + "获取网络数据:";
    public static final String TITLE_LOGIN = "北京中医健康乡村基线普查电子系统";
    public static final String TITLE_EDITPASSWORD = "修改密码";
    public static final String TITLE_MAIN = "调查系统主页";
    public static final String TITLE_UPDATE = "数据更新";
    public static final String TITLE_SUGGEST = "意见建议";
    public static final String TITLE_QUSETUINNAIR = "调查问卷";
    public static final String TITLE_EMPHASES = "重点检测";
    public static final String TITLE_INQUIRE = "问卷查询";
    public static final String MESSAGE_CONECTIONNET_NOUSERINFO = "本机无该用户登陆数据，请尝试使用网络环境登录";
    public static final String MESSAGE_PASSWORDERROR = "密码错误,请重新输入";
    public static final String MESSAGE_PASSWOROK = "欢迎登录系统";
    public static final String MESSAGE_LOGINING = "登录中，请稍等...";
    public static final String NONETCONNETION = "没有网络，请连接网络再次尝试";
    public static final int DURATION = 300;
    public static final long SPLASH_TIME = 1500;

    //存放数据时公共的key命名
    public static final String Suggest = "Suggest";
    public static final String Emphases = "Emphases";
    //暂时不使用currentUser因为是null
    public static String emphasesPrefrenceKey = StringConstants.Emphases;
    public static final String Questianner = "Questianner";
    //暂时不使用currentUser因为是null
    public static String questiannerPrefrenceKey = StringConstants.Questianner;//问卷答案


}
