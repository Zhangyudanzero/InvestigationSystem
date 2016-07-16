package com.investigation.investigationsystem.business.qusetionnaire.view;

import android.content.Intent;

import com.investigation.investigationsystem.MyApplication;
import com.investigation.investigationsystem.R;
import com.investigation.investigationsystem.business.qusetionnaire.presenter.QusetuinnairePresenter;
import com.investigation.investigationsystem.common.base.BaseActivity;
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
 * 创建日期 ： on 2016/7/15  9:37
 * <p/>
 * 描    述 ：
 * 答卷的 activity 容器
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class JuanActivity extends BaseFragmentActivity {

    @Override
    protected int getContentViewID() {
        return R.layout.activity_juan;
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
