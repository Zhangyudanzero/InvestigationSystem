package com.investigation.investigationsystem.common.base;

import android.app.Application;

/**
 * ==========================================
 * <p/>
 * 版    权 ： 北京爱接力科技有限公司
 * <p/>
 * 作    者 ： iwen
 * <p/>
 * 版    本 ： 1.0
 * <p/>
 * 创建日期 ： on 2016/6/28  15:34
 * <p/>
 * 描    述 ：
 * 这是 application 的基类
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class BaseApplication extends Application {

    private static Application instance;

    public static Application getInstance() {

        if (null == instance) {
            synchronized (BaseApplication.class) {
                instance = new BaseApplication();
            }
        }
        return instance;
    }

}
