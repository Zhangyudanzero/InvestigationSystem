package com.investigation.investigationsystem.business.update.view;

import android.content.Intent;

import com.investigation.investigationsystem.MyApplication;
import com.investigation.investigationsystem.R;
import com.investigation.investigationsystem.business.update.presenter.UpdatePresenter;
import com.investigation.investigationsystem.common.base.BaseFragmentActivity;

/**
 * ==========================================
 * <p/>
 * 版    权 ： 北京爱接力科技有限公司
 * <p/>
 * 作    者 ： iwen
 * <p/>
 * 版    本 ： 1.0
 * <p/>
 * 创建日期 ： on 2016/7/3  13:43
 * <p/>
 * 描    述 ：
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class UpdateActivity extends BaseFragmentActivity {

    @Override
    protected int getContentViewID() {
        return R.layout.activity_update;
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
        UpdatePresenter.regist(this);
    }

    @Override
    protected void analyzeIntent(Intent intent) {
        initDefaultAddFragment();
    }

    @Override
    protected void initDefaultAddFragment() {
        UpdatePresenter.getInstance().addDefaultFragment();
    }

    @Override
    protected void onDestroy() {
        UpdatePresenter.getInstance().onDes();
        super.onDestroy();
    }
}
