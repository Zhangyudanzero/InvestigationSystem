package com.investigation.investigationsystem.business.questionnaireinquiry.view;

import android.content.Intent;

import com.investigation.investigationsystem.MyApplication;
import com.investigation.investigationsystem.R;
import com.investigation.investigationsystem.business.questionnaireinquiry.presenter.InquiryPresenter;
import com.investigation.investigationsystem.business.update.presenter.UpdatePresenter;
import com.investigation.investigationsystem.common.base.BaseFragmentActivity;

/**
 * 问卷查询
 *
 * Created by zero on 2016/7/3.
 */
public class InquireActivity extends BaseFragmentActivity {

    @Override
    protected int getContentViewID() {
        return R.layout.activity_inquire;
    }

    @Override
    public int getFragmentViewID() {
        return R.id.ac_login_content;
    }

    @Override
    protected void setRootContent() {
        this.rootContext = MyApplication.getInstance().getApplicationContext();
    }

    @Override
    protected void onCreateByUser() {
        InquiryPresenter.regist(this);
    }

    @Override
    protected void analyzeIntent(Intent intent) {
        initDefaultAddFragment();
    }

    @Override
    protected void initDefaultAddFragment() {
        InquiryPresenter.getInstance().addDefaultFragment();
    }

    @Override
    protected void onDestroy() {
        UpdatePresenter.getInstance().onDes();
        super.onDestroy();
    }


}
