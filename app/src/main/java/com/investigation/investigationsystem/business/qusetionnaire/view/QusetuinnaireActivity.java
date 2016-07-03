package com.investigation.investigationsystem.business.qusetionnaire.view;

import android.content.Intent;

import com.investigation.investigationsystem.MyApplication;
import com.investigation.investigationsystem.R;
import com.investigation.investigationsystem.business.qusetionnaire.presenter.QusetuinnairePresenter;
import com.investigation.investigationsystem.common.base.BaseFragmentActivity;

/**
 * Created by zero on 2016/7/3.
 */
public class QusetuinnaireActivity extends BaseFragmentActivity {

    @Override
    protected int getContentViewID() {
        return R.layout.activity_qusetuinnaire;
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
        QusetuinnairePresenter.regist(this);
    }

    @Override
    protected void analyzeIntent(Intent intent) {
        initDefaultAddFragment();
    }

    @Override
    protected void initDefaultAddFragment() {
        QusetuinnairePresenter.getInstance().addDefaultFragment();
    }

    @Override
    protected void onDestroy() {
        QusetuinnairePresenter.getInstance().onDes();
        super.onDestroy();
    }

}
