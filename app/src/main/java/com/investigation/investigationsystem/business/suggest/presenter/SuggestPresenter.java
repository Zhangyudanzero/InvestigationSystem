package com.investigation.investigationsystem.business.suggest.presenter;

import android.app.Activity;
import android.content.Intent;

import com.investigation.investigationsystem.business.suggest.view.SuggestActivity;
import com.investigation.investigationsystem.business.suggest.view.SuggestFragment;
import com.investigation.investigationsystem.common.base.BaseFragmentActivity;
import com.investigation.investigationsystem.common.base.BasePresenter;
import com.investigation.investigationsystem.common.constants.StringConstants;

/**
 * Created by zero on 2016/7/3.
 */
public class SuggestPresenter extends BasePresenter {

    private static final String TAG = StringConstants.TAG + SuggestPresenter.class.getName();
    private static SuggestPresenter persenter;

    private SuggestPresenter(BaseFragmentActivity rootActivity) {
        this.rootActivity = rootActivity;
    }

    public static void regist(BaseFragmentActivity rootActivity) {
        persenter = new SuggestPresenter(rootActivity);
    }

    public static SuggestPresenter getInstance() {
        return persenter;
    }

    public static void startUp(Activity activity) {
        Intent intent = new Intent(activity, SuggestActivity.class);
        activity.startActivity(intent);
        intent = null;
    }

    /**
     * 加载默认的 fragment 页面
     */
    public void addDefaultFragment() {
        replaceFragment(SuggestFragment.newInstance(), rootActivity.getFragmentViewID());
    }

    /**
     * 提交意见建议
     */
    public void commitFeedBack() {

    }


    /**
     * 销毁，回收资源
     */
    public void onDes() {
        persenter = null;
    }


}
