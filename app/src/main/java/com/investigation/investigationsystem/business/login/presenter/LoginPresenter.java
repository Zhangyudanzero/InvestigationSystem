package com.investigation.investigationsystem.business.login.presenter;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.investigation.investigationsystem.business.login.bean.EditPasswordRequest;
import com.investigation.investigationsystem.business.login.bean.LoginRequest;
import com.investigation.investigationsystem.business.login.bean.MyUserInfo;
import com.investigation.investigationsystem.business.login.bean.UserData;
import com.investigation.investigationsystem.business.login.modle.LoginHelper;
import com.investigation.investigationsystem.business.login.view.EditPasswordFragment;
import com.investigation.investigationsystem.business.login.view.LoginFragment;
import com.investigation.investigationsystem.business.main.presenter.MainPresenter;
import com.investigation.investigationsystem.common.base.BaseFragmentActivity;
import com.investigation.investigationsystem.common.base.BasePresenter;
import com.investigation.investigationsystem.common.constants.DataConstants;
import com.investigation.investigationsystem.common.constants.StringConstants;
import com.investigation.investigationsystem.common.utils.BaseUtils;
import com.investigation.investigationsystem.common.utils.DebugLog;
import com.investigation.investigationsystem.common.utils.MD5Util;
import com.investigation.investigationsystem.common.utils.PrefersUtils;
import com.investigation.investigationsystem.common.utils.ToastUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import cn.pedant.SweetAlert.SweetAlertDialog;

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
    public void buttonLoginClick(String username, String password, final SweetAlertDialog dialog) {

        // 校验输入
        if (TextUtils.isEmpty(username)) {
            ToastUtils.showMessage("请填写账户");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            ToastUtils.showMessage("请填写密码");
            return;
        }

        // 密码要经过MD5加密再对比
        password = MD5Util.encryptByMD5(password);
        // 校验网络状态
        boolean networkAvailable = BaseUtils.isNetworkAvailable();
        DebugLog.d(TAG, "当前网络状态：" + networkAvailable);
        if (networkAvailable) {
            // 网络请求加载数据
            if (dialog != null) {
                dialog.show();
            }
            LoginHelper.login(new Gson().toJson(new LoginRequest(username, password)), new LoginHelper.LoginCallBack() {
                @Override
                public void error() {
                    dialog.dismiss();
                    loginError();
                }

                @Override
                public void success(MyUserInfo myUserInfo) {
                    dialog.dismiss();
                    loginSuccess(myUserInfo);
                    toggleToMainActivity();
                }
            });
        } else {
            DebugLog.d(TAG, "本地输入的usderid：" + username);
            // 加载本地缓存数据，判断是否可以登陆
            if (DataConstants.userInfos != null && DataConstants.userInfos.getData() != null) {
                // 发现本地没有用户登陆的信息，或是没有这个用户的登录信息数据，那么提示用户联网登陆
                MyUserInfo myUserInfo = DataConstants.userInfos.getData().get(username);
                if (myUserInfo == null) {
                    ToastUtils.showMessage(StringConstants.MESSAGE_CONECTIONNET_NOUSERINFO);
                    myUserInfo = null;
                    return;
                }
                // 校验用户账号，密码
                if (passwordIsOK(myUserInfo, password)) {
                    // 密码正确
                    loginSuccess(myUserInfo);
                    myUserInfo = null;
                    toggleToMainActivity();
                    return;
                } else {
                    // 密码错误
                    loginError();
                    myUserInfo = null;
                    return;
                }
            } else {
                ToastUtils.showMessage(StringConstants.MESSAGE_CONECTIONNET_NOUSERINFO);
                return;
            }
        }
    }

    /**
     * 校验密码
     *
     * @param myUserInfo
     * @return
     */
    private boolean passwordIsOK(MyUserInfo myUserInfo, String password) {
        if (password.equals(myUserInfo.getPassword())) {
            // 密码正确
            return true;
        }
        // 密码错误
        return false;
    }

    /**
     * 登录成功
     */
    private void loginSuccess(MyUserInfo myUserInfo) {
        // 同步数据
        // 设置当前登录用户数据
        ToastUtils.showMessage(StringConstants.MESSAGE_PASSWOROK);
        DataConstants.currentMyUserInfo = myUserInfo;
        // 判断该用户数据是否添加入用户登录缓存信息列表，若没有添加进入，若有，更新改用户下数据
        if (DataConstants.userInfos == null) {
            DataConstants.userInfos = new UserData();
        }
        if (DataConstants.userInfos.getData() == null) {
            DataConstants.userInfos.setData(new HashMap<String, MyUserInfo>());
        }
        DataConstants.userInfos.getData().remove(myUserInfo.getAccount());
        DataConstants.userInfos.getData().put(myUserInfo.getAccount(), myUserInfo);
        PrefersUtils.putString(PrefersUtils.TAG_USERINFO, new Gson().toJson(DataConstants.userInfos));
    }

    /**
     * 登录失败
     */
    private void loginError() {
        // 重置数据
        ToastUtils.showMessage(StringConstants.MESSAGE_PASSWORDERROR);
        DataConstants.currentMyUserInfo = null;
    }

    /**
     * 切换到主界面
     */
    private void toggleToMainActivity() {
        // 切换到主界面
        MainPresenter.startUp(rootActivity);
        rootActivity.finish();
    }

    /**
     * 修改密码页面修改密码
     *
     * @param viewHold
     */
    public void editPassword(final EditPasswordFragment.ViewHold viewHold) {
        if (viewHold == null) {
            return;
        }
        // 校验二次密码输入始发正确
        String name = viewHold.edit_name.getText().toString().trim();
        String older = viewHold.edit_frist.getText().toString().trim();
        String newer = viewHold.edit_second.getText().toString().trim();

        if (TextUtils.isEmpty(name)) {
            ToastUtils.showMessage("请填写账号");
            return;
        }
        if (TextUtils.isEmpty(older)) {
            ToastUtils.showMessage("请填写您现在的密码");
            return;
        }
        if (TextUtils.isEmpty(newer)) {
            ToastUtils.showMessage("请填写输入您的新密码");
            return;
        }
        // 验证网络情况
        if (!BaseUtils.isNetworkAvailable()) {
            ToastUtils.showMessage(StringConstants.NONETCONNETION);
            return;
        }
        viewHold.dialog_loading.show();
        older = MD5Util.encryptByMD5(older);
        newer = MD5Util.encryptByMD5(newer);
        LoginHelper.editPassword(new Gson().toJson(new EditPasswordRequest(name, older, newer)), new LoginHelper.editPasswordCallback() {
            @Override
            public void error() {
                viewHold.dialog_loading.dismiss();
                ToastUtils.showMessage(StringConstants.MESSAGE_PASSWORDERROR);
            }

            @Override
            public void success(MyUserInfo myUserInfo) {
                viewHold.dialog_loading.dismiss();
                loginSuccess(myUserInfo);
                toggleToMainActivity();
            }
        });
        name = null;
        older = null;
        newer = null;
    }

    /**
     * 销毁，回收资源
     */
    public void onDes() {
        persenter = null;
    }

}
