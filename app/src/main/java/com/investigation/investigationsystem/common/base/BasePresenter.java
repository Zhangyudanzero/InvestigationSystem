package com.investigation.investigationsystem.common.base;

import android.support.v4.app.Fragment;

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

    protected BaseFragmentActivity rootActivity;

    /**
     * 替换fragment
     *
     * @param fragment
     * @param contentID
     */
    protected void replaceFragment(Fragment fragment, int contentID) {
        rootActivity.getSupportFragmentManager().beginTransaction()
                .replace(contentID, fragment)
                .commit();
    }

    /**
     * 替换fragment,并加入返回栈
     *
     * @param fragment
     * @param contentID
     */
    protected void replaceFragmentAddBackStack(Fragment fragment, int contentID) {
        rootActivity.getSupportFragmentManager().beginTransaction()
                .replace(contentID, fragment)
                .addToBackStack(fragment.getClass().getName())
                .commit();
    }

    /**
     * 添加fragment,不加入返回栈
     *
     * @param fragment
     * @param contentID
     */
    protected void addFragmentNoBackStack(Fragment fragment, int contentID) {
        rootActivity.getSupportFragmentManager().beginTransaction()
                .add(contentID, fragment, fragment.getClass().getName())
                .commit();
    }

    /**
     * 添加fragment,不加入返回栈
     *
     * @param current
     * @param tager
     * @param contentID
     */
    protected void addFragmentAddBackStack(Fragment current, Fragment tager, int contentID) {
        rootActivity.getSupportFragmentManager().beginTransaction()
                .hide(current)
                .add(contentID, tager, tager.getClass().getName())
                .addToBackStack(tager.getClass().getName())
                .commit();
    }

    /**
     * 返回操作
     */
    public void goBack() {
        if (rootActivity.getSupportFragmentManager().getBackStackEntryCount() > 0) {
            rootActivity.getSupportFragmentManager().popBackStack();
        } else {
            rootActivity.finish();
        }
    }


}
