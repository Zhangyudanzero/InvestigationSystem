package com.investigation.investigationsystem.business.suggest.view;

import android.content.Intent;

import com.investigation.investigationsystem.MyApplication;
import com.investigation.investigationsystem.R;
import com.investigation.investigationsystem.business.suggest.presenter.SuggestPresenter;
import com.investigation.investigationsystem.common.base.BaseFragmentActivity;

/**
 * Created by zero on 2016/7/3.
 */
public class SuggestActivity extends BaseFragmentActivity {

    @Override
    protected int getContentViewID() {
        return R.layout.activity_suggest;
    }

    @Override
    public int getFragmentViewID() {
        return R.id.ac_suggest_content;
    }

    @Override
    protected void setRootContent() {
        this.rootContext = MyApplication.getInstance().getApplicationContext();
    }

    @Override
    protected void onCreateByUser() {
        SuggestPresenter.regist(this);
    }

    @Override
    protected void analyzeIntent(Intent intent) {
        initDefaultAddFragment();
    }

    @Override
    protected void initDefaultAddFragment() {
        SuggestPresenter.getInstance().addDefaultFragment();
    }

    @Override
    protected void onDestroy() {
        SuggestPresenter.getInstance().onDes();
        super.onDestroy();
    }



}
