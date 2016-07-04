package com.investigation.investigationsystem.business.questionnaireinquiry.presenter;

import android.app.Activity;
import android.content.Intent;

import com.investigation.investigationsystem.business.questionnaireinquiry.view.InquireActivity;
import com.investigation.investigationsystem.business.questionnaireinquiry.view.InquireFragment;
import com.investigation.investigationsystem.common.base.BaseFragmentActivity;
import com.investigation.investigationsystem.common.base.BasePresenter;
import com.investigation.investigationsystem.common.constants.StringConstants;

/**
 * 问卷查询
 *
 * Created by zero on 2016/7/3.
 */
public class InquiryPresenter extends BasePresenter {

    private static final String TAG = StringConstants.TAG + InquiryPresenter.class.getName();
    private static InquiryPresenter persenter;

    private InquiryPresenter(BaseFragmentActivity rootActivity) {
        this.rootActivity = rootActivity;
    }

    public static void regist(BaseFragmentActivity rootActivity) {
        persenter = new InquiryPresenter(rootActivity);
    }

    public static InquiryPresenter getInstance() {
        return persenter;
    }

    public static void startUp(Activity activity) {
        Intent intent = new Intent(activity, InquireActivity.class);
        activity.startActivity(intent);
        intent = null;
    }

    /**
     * 加载默认的 fragment 页面
     */
    public void addDefaultFragment() {
        replaceFragment(InquireFragment.newInstance() , rootActivity.getFragmentViewID() );
    }



    /**
     * 销毁，回收资源
     */
    public void onDes() {
        persenter = null;
    }


}
