package com.investigation.investigationsystem.business.login.presenter;

import com.google.gson.JsonObject;
import com.investigation.investigationsystem.business.login.view.EditPasswordFragment;
import com.investigation.investigationsystem.business.login.view.LoginFragment;
import com.investigation.investigationsystem.business.main.presenter.MainPresenter;
import com.investigation.investigationsystem.common.base.BaseFragmentActivity;
import com.investigation.investigationsystem.common.base.BasePresenter;
import com.investigation.investigationsystem.common.constants.StringConstants;
import com.investigation.investigationsystem.common.utils.ConstantUrl;
import com.investigation.investigationsystem.common.utils.OkhttpUtils;

import java.io.IOException;

/**
 * ==========================================
 * <p/>
 * 版    权 ： 北京爱接力科技有限公司
 * <p/>
 * 作    者 ： iwen
 * <p/>
 * 版    本 ： 1.0
 * <p/>
 * 创建日期 ： on 2016/6/28  20:04
 * <p/>
 * 描    述 ：
 * 登陆页面的控制器
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class LoginPresenter extends BasePresenter {

    private static final String TAG = StringConstants.TAG + LoginPresenter.class.getName();
    private static LoginPresenter persenter;

    private LoginPresenter(BaseFragmentActivity rootActivity) {
        this.rootActivity = rootActivity;
    }

    public static void regist(BaseFragmentActivity rootActivity) {
        persenter = new LoginPresenter(rootActivity);
    }

    public static LoginPresenter getInstance() {
        return persenter;
    }

    /**
     * 加载默认的 fragment 页面
     */
    public void addDefaultFragment() {
        replaceFragment(LoginFragment.newInstance(), rootActivity.getFragmentViewID());
    }

    /**
     * 修改密码的点击事件,是登陆页面的
     */
    public void buttonEditPasswordClickByLogin() {
        replaceFragmentAddBackStack(EditPasswordFragment.newInstance(), rootActivity.getFragmentViewID());

    }



    /**
     * 登陆的点击事件,是登陆页面的
     */
    public void buttonLoginClick(String username , String password) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("username" , username);
        jsonObject.addProperty("password" , password);
        String url = ConstantUrl.url + ConstantUrl.Login;
        OkhttpUtils.getInstance().AsynPostJson(url, jsonObject.toString(), new OkhttpUtils.RequestCallback() {
            @Override
            public void onTimeOut() {

            }

            @Override
            public void onError() {

            }

            @Override
            public void onSuccess(String result) throws IOException {

            }
        });

        MainPresenter.startUp(rootActivity);
        rootActivity.finish();

    }


    /**
     * 销毁，回收资源
     */
    public void onDes() {
        persenter = null;
    }

}
