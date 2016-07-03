package com.investigation.investigationsystem.business.qusetionnaire.presenter;

import android.app.Activity;
import android.content.Intent;

import com.investigation.investigationsystem.business.qusetionnaire.view.QusetuinnairFragment;
import com.investigation.investigationsystem.business.qusetionnaire.view.QusetuinnaireActivity;
import com.investigation.investigationsystem.common.base.BaseFragmentActivity;
import com.investigation.investigationsystem.common.base.BasePresenter;
import com.investigation.investigationsystem.common.constants.StringConstants;

/**
 * 进入调查问卷之前的身份证扫描页面
 *
 * Created by zero on 2016/7/3.
 */
public class QusetuinnairePresenter extends BasePresenter{

    private static final String TAG = StringConstants.TAG + QusetuinnairePresenter.class.getName();
    private static QusetuinnairePresenter persenter;

    private QusetuinnairePresenter(BaseFragmentActivity rootActivity) {
        this.rootActivity = rootActivity;
    }

    public static void regist(BaseFragmentActivity rootActivity) {
        persenter = new QusetuinnairePresenter(rootActivity);
    }

    public static QusetuinnairePresenter getInstance() {
        return persenter;
    }

    public static void startUp(Activity activity) {
        Intent intent = new Intent(activity, QusetuinnaireActivity.class);
        activity.startActivity(intent);
        intent = null;
    }

    /**
     * 加载默认的 fragment 页面
     */
    public void addDefaultFragment() {
        replaceFragment(QusetuinnairFragment.newInstance(), rootActivity.getFragmentViewID());
    }


    /**
     * 选择团队
     */
    public void chooseTeam(){

    }

    /**
     * 选择调查地域
     */
    public void chooseEare(){

    }

    /**
     * 选择问卷
     */
    public void chooseQuestion(){

    }

    /**
     * 获取所有被调查人相关数据
     * 注意处理null数据
     */
    public void getInvestigatedInfo(){

    }

    /**
     * 开始问卷调查
     */
    public void beginQusetion(){

    }

    /**
     * 开始身份证扫描
     */
    public void scanId(){

    }



    /**
     * 销毁，回收资源
     */
    public void onDes() {
        persenter = null;
    }



}
