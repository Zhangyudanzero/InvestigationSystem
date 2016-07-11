package com.investigation.investigationsystem.common.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.view.WindowManager;

import com.investigation.investigationsystem.MyApplication;
import com.investigation.investigationsystem.common.SystemBarTintManager;
import com.investigation.investigationsystem.common.constants.DataConstants;
import com.investigation.investigationsystem.common.constants.StringConstants;

import org.json.JSONObject;

/**
 * ==========================================
 * <p/>
 * 版    权 ： 北京爱接力科技有限公司
 * <p/>
 * 作    者 ： iwen
 * <p/>
 * 版    本 ： 1.0
 * <p/>
 * 创建日期 ： on 2016/6/28  15:02
 * <p/>
 * 描    述 ：
 * 这是整个 app 的基础工具类
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class BaseUtils {

    private static final String TAG = StringConstants.TAG + BaseUtils.class.getName();

    /**
     * 修改状态颜色的方法,这里只修改4.4版本的状态栏颜色l
     *
     * @param color
     * @param Activity
     */
    public static void setStateBarColor(int color, Activity Activity) {

        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            Activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            SystemBarTintManager tintManager = new SystemBarTintManager(Activity);
            tintManager.setStatusBarTintResource(color);
            tintManager.setStatusBarTintEnabled(true);
        }
    }

    /**
     * 获取当前网络状态
     *
     * @return
     */
    public static boolean isNetworkAvailable() {
        // 获取系统的连接服务
        ConnectivityManager connectivityManager = (ConnectivityManager) MyApplication.getInstance()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetInfo != null && activeNetInfo.isConnected();
    }

    /**
     * 获取当前的版本号
     *
     * @return
     */
    public static String getMyVersionCode() {
        try {
            PackageManager pm = MyApplication.getInstance().getApplicationContext().getPackageManager();
            PackageInfo packageInfo = pm.getPackageInfo(MyApplication.getInstance().getApplicationContext().getPackageName(), 0);
            return packageInfo.versionName;
        } catch (Exception e) {
            DebugLog.e(TAG, "getMyVersionCode()", e);
        }
        return "";
    }

    /**
     * 解析初始数据
     */
    public static void anacyleInitData() {
        String userInfos = PrefersUtils.getString(PrefersUtils.TAG_USERINFO);
        // 这里差一个gson解析
        DataConstants.userInfos = null;
        userInfos = null;
    }


}
