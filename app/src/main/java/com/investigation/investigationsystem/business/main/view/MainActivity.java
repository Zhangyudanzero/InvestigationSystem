package com.investigation.investigationsystem.business.main.view;

import android.content.Intent;

import com.investigation.investigationsystem.MyApplication;
import com.investigation.investigationsystem.R;
import com.investigation.investigationsystem.business.main.presenter.MainPresenter;
import com.investigation.investigationsystem.common.base.BaseFragmentActivity;

public class MainActivity extends BaseFragmentActivity {

    @Override
    protected int getContentViewID() {
        return R.layout.activity_main;
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
        MainPresenter.regist(this);
    }

    @Override
    protected void analyzeIntent(Intent intent) {
        initDefaultAddFragment();
    }

    @Override
    protected void initDefaultAddFragment() {
        MainPresenter.getInstance().addDefaultFragment();
    }



}
