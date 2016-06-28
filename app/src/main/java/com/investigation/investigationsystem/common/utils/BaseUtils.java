package com.investigation.investigationsystem.common.utils;

import android.app.Activity;
import android.os.Build;
import android.view.WindowManager;

import com.investigation.investigationsystem.common.SystemBarTintManager;

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


}
