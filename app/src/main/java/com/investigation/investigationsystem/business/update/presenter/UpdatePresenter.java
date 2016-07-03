package com.investigation.investigationsystem.business.update.presenter;

import android.app.Activity;
import android.content.Intent;

import com.investigation.investigationsystem.business.update.view.UpdateActivity;
import com.investigation.investigationsystem.business.update.view.UpdateFragment;
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
 * 创建日期 ： on 2016/7/3  13:47
 * <p/>
 * 描    述 ：
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class UpdatePresenter extends BasePresenter {

    private static final String TAG = StringConstants.TAG + UpdatePresenter.class.getName();
    private static UpdatePresenter persenter;

    private UpdatePresenter(BaseFragmentActivity rootActivity) {
        this.rootActivity = rootActivity;
    }

    public static void regist(BaseFragmentActivity rootActivity) {
        persenter = new UpdatePresenter(rootActivity);
    }

    public static UpdatePresenter getInstance() {
        return persenter;
    }

    public static void startUp(Activity activity) {
        Intent intent = new Intent(activity, UpdateActivity.class);
        activity.startActivity(intent);
        intent = null;
    }

    /**
     * 加载默认的 fragment 页面
     */
    public void addDefaultFragment() {
        replaceFragment(UpdateFragment.newInstance(), rootActivity.getFragmentViewID());
    }

    /**
     * 问卷上传点击
     */
    public void uploadQuestionClick() {


    }

    /**
     * 反馈信息上传点击
     */
    public void uploadFeedbackClick() {


    }

    /**
     * 全部上传点击点击
     */
    public void uploadAllClick() {


    }

    /**
     * 更新问卷点击
     */
    public void updateQuestionClick() {


    }

    /**
     * 更新重点监控点击
     */
    public void updateEmphasesClick() {


    }

    /**
     * 更新个人数据点击
     */
    public void updateMyClick() {


    }

    /**
     * 销毁，回收资源
     */
    public void onDes() {
        persenter = null;
    }


}
