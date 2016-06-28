package com.investigation.investigationsystem.business.login.view;

import android.os.Bundle;

import com.investigation.investigationsystem.R;
import com.investigation.investigationsystem.common.base.BaseTitleFragemnt;
import com.investigation.investigationsystem.common.constants.StringConstants;

import java.nio.channels.UnsupportedAddressTypeException;

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
 * 登陆页面
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class LoginFragment extends BaseTitleFragemnt {

    /**
     * 提供给外部使用的创建对象的接口
     *
     * @return
     */
    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    protected void initHeadView() {
        setTitleStyle(false, false, StringConstants.TITLE_LOGIN);
    }

    @Override
    protected void InitHeadClick() {
        return;
    }

    @Override
    protected int getContentViewID() {
        return R.layout.fragment_login;
    }

    @Override
    protected void analyzeBundle(Bundle bundle) {
        return;
    }

    @Override
    protected void onCreateByUser() {

    }

    @Override
    protected void initView() {
        
    }

    @Override
    protected void initClick() {

    }
}
