package com.investigation.investigationsystem;

import android.app.Application;

import com.investigation.investigationsystem.common.data.Data;
import com.investigation.investigationsystem.common.utils.DebugLog;
import com.orhanobut.logger.Logger;

/**
 * ==========================================
 * <p/>
 * 版    权 ： 北京爱接力科技有限公司
 * <p/>
 * 作    者 ： iwen
 * <p/>
 * 版    本 ： 1.0
 * <p/>
 * 创建日期 ： on 2016/6/28  15:47
 * <p/>
 * 描    述 ：
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class MyApplication extends Application {

    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
//        DebugLog.d("aaa", "假数据：" + Data.getQuestion);
        Logger.d("假数据：" + Data.getQuestion, "hahaha");
    }

    public static MyApplication getInstance() {
        return instance;
    }
}
