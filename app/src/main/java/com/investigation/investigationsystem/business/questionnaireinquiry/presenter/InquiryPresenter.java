package com.investigation.investigationsystem.business.questionnaireinquiry.presenter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.investigation.investigationsystem.business.questionnaireinquiry.adapter.InquireAdapter;
import com.investigation.investigationsystem.business.questionnaireinquiry.view.InquireActivity;
import com.investigation.investigationsystem.business.questionnaireinquiry.view.InquireFragment;
import com.investigation.investigationsystem.business.qusetionnaire.bean.JuanResult;
import com.investigation.investigationsystem.business.qusetionnaire.bean.QusertionnaireResultList;
import com.investigation.investigationsystem.common.base.BaseFragmentActivity;
import com.investigation.investigationsystem.common.base.BasePresenter;
import com.investigation.investigationsystem.common.constants.StringConstants;
import com.investigation.investigationsystem.common.utils.DebugLog;
import com.investigation.investigationsystem.common.utils.PrefersUtils;
import com.investigation.investigationsystem.common.utils.ToastUtils;

import java.util.List;

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
     * 获取问卷查询列表
     */
    public void getQuestionnaire(RecyclerView rv_show){
        //获取问卷结果 暂时使用假数据 实际从sps中获取


        if (!PrefersUtils.getString(StringConstants.answerPrefrenceKey).isEmpty()) {

        }else{
            ToastUtils.showMessage("没有可以查询的问卷");
        }

        Gson gson = new Gson();
        JuanResult juanResult = gson.fromJson(PrefersUtils.getString(StringConstants.answerPrefrenceKey) , JuanResult.class);
        DebugLog.i(TAG , "解析问卷---" + juanResult);
        List<QusertionnaireResultList> qusertionnaireResultList = juanResult.getQusertionnaireResultList();
        rv_show.setAdapter(new InquireAdapter(qusertionnaireResultList , rootActivity));
    }



    /**
     * 销毁，回收资源
     */
    public void onDes() {
        persenter = null;
    }


}
