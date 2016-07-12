package com.investigation.investigationsystem.business.login.view;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;

import com.investigation.investigationsystem.R;
import com.investigation.investigationsystem.business.login.presenter.LoginPresenter;
import com.investigation.investigationsystem.common.base.BaseTitleFragemnt;
import com.investigation.investigationsystem.common.constants.StringConstants;
import com.investigation.investigationsystem.common.utils.DialogUtils;
import com.labo.kaji.fragmentanimations.CubeAnimation;

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

    private EditText edit_name;
    private EditText edit_password;
    private Button btn_exit;
    private Button btn_editPassword;
    private Button btn_login;
    private SweetAlertDialog dialog_loading;

    private int direction;

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
        edit_name = (EditText) rootView.findViewById(R.id.login_name);
        edit_password = (EditText) rootView.findViewById(R.id.login_password);
        btn_exit = (Button) rootView.findViewById(R.id.login_button_exit);
        btn_editPassword = (Button) rootView.findViewById(R.id.login_button_editpassword);
        btn_login = (Button) rootView.findViewById(R.id.login_button_login);
        dialog_loading = DialogUtils.getloadingDialog(rootActivity, StringConstants.MESSAGE_LOGINING);
    }

    @Override
    protected void initClick() {

        // 修改密码按钮点击事件
        btn_editPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginPresenter.getInstance().buttonEditPasswordClickByLogin();
            }
        });

        // 登陆的点击事件
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edit_name.getText().toString();
                String password = edit_password.getText().toString();
                LoginPresenter.getInstance().buttonLoginClick(username, password, dialog_loading);

                //方便测试
//                Intent it = new Intent(getActivity() , MainActivity.class);
//                getActivity().startActivity(it);

            }
        });
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        switch (direction) {
            case 1:
                return CubeAnimation.create(CubeAnimation.RIGHT, enter, StringConstants.DURATION);
        }
        return null;
    }

    @Override
    protected void onActivityCreatedByUser() {
        super.onActivityCreatedByUser();
        direction = 1;

    }

    @Override
    public void onDestroy() {
        if (dialog_loading != null && dialog_loading.isShowing()) {
            dialog_loading.dismiss();
        }
        dialog_loading = null;
        super.onDestroy();
    }
}
