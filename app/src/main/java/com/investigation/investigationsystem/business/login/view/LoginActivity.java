package com.investigation.investigationsystem.business.login.view;

import android.content.Intent;

import com.investigation.investigationsystem.MyApplication;
import com.investigation.investigationsystem.R;
import com.investigation.investigationsystem.business.login.presenter.LoginPresenter;
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
 * 创建日期 ： on 2016/6/28  19:49
 * <p/>
 * 描    述 ：
 * 登陆界面容器
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class LoginActivity extends BaseFragmentActivity {

    @Override
    protected int getContentViewID() {
        return R.layout.activity_login;
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
        LoginPresenter.regist(this);
    }

    @Override
    protected void analyzeIntent(Intent intent) {
        // 不需要解析数据,执行默认操作
        initDefaultAddFragment();
    }

    /**
     * 没有初始参数的默认操作
     */
    @Override
    protected void initDefaultAddFragment() {
        LoginPresenter.getInstance().addDefaultFragment();
    }


}
