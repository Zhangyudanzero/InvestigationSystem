package com.investigation.investigationsystem.business.main.presenter;

import android.app.Activity;
import android.content.Intent;

import com.investigation.investigationsystem.business.main.view.MainActivity;
import com.investigation.investigationsystem.business.main.view.MainFragment;
import com.investigation.investigationsystem.business.update.presenter.UpdatePresenter;
import com.investigation.investigationsystem.common.base.BaseFragmentActivity;
import com.investigation.investigationsystem.common.base.BasePresenter;
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
 * 创建日期 ： on 2016/7/3  11:09
 * <p/>
 * 描    述 ：
 * 主界面的控制器
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class MainPresenter extends BasePresenter {

    private static final String TAG = StringConstants.TAG + MainPresenter.class.getName();
    private static MainPresenter persenter;

    private MainPresenter(BaseFragmentActivity rootActivity) {
        this.rootActivity = rootActivity;
    }

    public static void regist(BaseFragmentActivity rootActivity) {
        persenter = new MainPresenter(rootActivity);
    }

    public static MainPresenter getInstance() {
        return persenter;
    }

    public static void startUp(Activity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
        intent = null;
    }

    /**
     * 加载默认的 fragment 页面
     */
    public void addDefaultFragment() {
        replaceFragment(MainFragment.newInstance(), rootActivity.getFragmentViewID());
    }

    /**
     * 重点检测点击事件
     */
    public void keyMonitoringClick() {

    }

    /**
     * 查询问卷
     */
    public void btnQuereClick() {

    }

    /**
     * 开始问卷
     */
    public void btnStartClick() {

    }

    /**
     * 意见建议
     */
    public void btnSuggestClick() {

    }

    /**
     * 数据更新
     */
    public void btnUpdateClick() {
        UpdatePresenter.startUp(rootActivity);
    }

    /**
     * 退出系统
     */
    public void btnExitClick() {

    }

    /**
     * 销毁，回收资源
     */
    public void onDes() {
        persenter = null;
    }

}
