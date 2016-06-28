package com.investigation.investigationsystem.common.base;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/**
 * ==========================================
 * <p/>
 * 版    权 ： 北京爱接力科技有限公司
 * <p/>
 * 作    者 ： iwen
 * <p/>
 * 版    本 ： 1.0
 * <p/>
 * 创建日期 ： on 2016/6/28  22:59
 * <p/>
 * 描    述 ：
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class BasePresenter {

    /**
     * 替换fragment
     *
     * @param activity
     * @param fragment
     * @param contentID
     */
    protected void replaceFragment(AppCompatActivity activity, Fragment fragment, int contentID) {
        activity.getSupportFragmentManager().beginTransaction()
                .replace(contentID, fragment)
                .commit();
    }


}
