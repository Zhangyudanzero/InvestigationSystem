package com.investigation.investigationsystem.business.login.modle;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.investigation.investigationsystem.business.login.bean.MyUserInfo;
import com.investigation.investigationsystem.common.constants.StringConstants;
import com.investigation.investigationsystem.common.utils.DebugLog;
import com.investigation.investigationsystem.common.utils.OkhttpUtils;
import com.investigation.investigationsystem.common.utils.ToastUtils;
import com.investigation.investigationsystem.config.ConfigFactroy;

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
 * 创建日期 ： on 2016/7/11  22:22
 * <p/>
 * 描    述 ：
 * 登录的网路操作
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class LoginHelper {

    private static final String TAG = StringConstants.TAG + LoginHelper.class.getName();

    public interface LoginCallBack {
        void error();

        void success(MyUserInfo myUserInfo);
    }

    public interface editPasswordCallback {
        void error();

        void success(MyUserInfo myUserInfo);
    }

    /**
     * 登录操作
     *
     * @param request
     * @param callback
     */
    public static void login(final String request, final LoginCallBack callback) {

        String url = ConfigFactroy.getConfig().getBaseUrl() + ConfigFactroy.url_login;
        OkhttpUtils.getInstance().AsynPostJson(url, request, new OkhttpUtils.RequestCallback() {
            @Override
            public void onTimeOut() {
                callback.error();
            }

            @Override
            public void onError() {
                callback.error();
            }

            @Override
            public void onSuccess(String result) throws IOException {
                try {
                    MyUserInfo myUserInfo = new Gson().fromJson(result, MyUserInfo.class);
                    DebugLog.d(TAG, "获取数据：" + myUserInfo.toString());
                    if (myUserInfo != null && !TextUtils.isEmpty(myUserInfo.getUserID()) && !TextUtils.isEmpty(myUserInfo.getName()) && !TextUtils.isEmpty(myUserInfo.getPassword())
                            && !"null".equals(myUserInfo.getUserID()) && !"null".equals(myUserInfo.getName()) && !"null".equals(myUserInfo.getPassword())) {
                        // 数据校验完毕，数据完整
                        callback.success(myUserInfo);
                    } else {
                        // 数据缺失，按失败出来
                        ToastUtils.showMessage(StringConstants.NET_DATAERROR);
                        callback.error();
                    }
                    myUserInfo = null;
                } catch (Exception e) {
                    e.printStackTrace();
                    ToastUtils.showMessage(StringConstants.NET_DATAERROR);
                    callback.error();
                }
            }
        });
    }

    /**
     * 修改密码操作
     *
     * @param request
     * @param callback
     */
    public static void editPassword(final String request, final editPasswordCallback callback) {

        String url = ConfigFactroy.getConfig().getBaseUrl() + ConfigFactroy.changePassword;
        OkhttpUtils.getInstance().AsynPostJson(url, request, new OkhttpUtils.RequestCallback() {
            @Override
            public void onTimeOut() {
                callback.error();
            }

            @Override
            public void onError() {
                callback.error();
            }

            @Override
            public void onSuccess(String result) throws IOException {
                try {
                    MyUserInfo myUserInfo = new Gson().fromJson(request, MyUserInfo.class);
                    callback.success(myUserInfo);
                    myUserInfo = null;
                } catch (Exception e) {
                    ToastUtils.showMessage(StringConstants.NET_DATAERROR);
                    callback.error();
                }
            }
        });
    }


}
