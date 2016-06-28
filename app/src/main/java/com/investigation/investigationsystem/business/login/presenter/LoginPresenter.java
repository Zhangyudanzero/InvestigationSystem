package com.investigation.investigationsystem.business.login.presenter;

import android.app.Activity;
import android.provider.SyncStateContract;

import com.investigation.investigationsystem.common.constants.StringConstants;

/**
 * ==========================================
 * <p/>
 * 版    权 ： 北京爱接力科技有限公司
 * <p/>
 * 作    者 ： iwen
 * <p/>
 * 版    本 ： 1.0
 * <p/>
 * 创建日期 ： on 2016/6/28  20:04
 * <p/>
 * 描    述 ：
 * 登陆页面的控制器
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class LoginPresenter {

    private static final String TAG = StringConstants.TAG + LoginPresenter.class.getName();
    private Activity rootActivity;
    private static LoginPresenter persenter;

    private LoginPresenter(Activity rootActivity) {
        this.rootActivity = rootActivity;
    }

    public static void regist(Activity rootActivity) {
        persenter = new LoginPresenter(rootActivity);
    }

    public static LoginPresenter getInstance() {
        return persenter;
    }

    /**
     * 加载默认的 fragment 页面
     */
    public void addDefaultFragment() {


    }

}