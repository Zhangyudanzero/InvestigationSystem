package com.investigation.investigationsystem.business.questionnaireinquiry.presenter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.investigation.investigationsystem.business.questionnaireinquiry.adapter.InquireAdapter;
import com.investigation.investigationsystem.business.questionnaireinquiry.bean.Answer;
import com.investigation.investigationsystem.business.questionnaireinquiry.bean.QusertionnaireResult;
import com.investigation.investigationsystem.business.questionnaireinquiry.view.InquireActivity;
import com.investigation.investigationsystem.business.questionnaireinquiry.view.InquireFragment;
import com.investigation.investigationsystem.common.base.BaseFragmentActivity;
import com.investigation.investigationsystem.common.base.BasePresenter;
import com.investigation.investigationsystem.common.constants.StringConstants;
import com.investigation.investigationsystem.common.data.Data;
import com.investigation.investigationsystem.common.utils.DebugLog;

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
        //获取问卷结果 暂时使用假数据
        Gson gson = new Gson();
        Answer answer = gson.fromJson(Data.answer, Answer.class);
        DebugLog.i(TAG , "解析问卷---" + answer);
        List<QusertionnaireResult> qusertionnaireresultlist = answer.getQusertionnaireresultlist();
        rv_show.setAdapter(new InquireAdapter(qusertionnaireresultlist , rootActivity));
    }



    /**
     * 销毁，回收资源
     */
    public void onDes() {
        persenter = null;
    }


}
