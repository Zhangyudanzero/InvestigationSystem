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
 * 创建日期 ： on 2016/6/29  8:50
 * <p/>
 * 描    述 ：
 * 修改密码页面
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class EditPasswordFragment extends BaseTitleFragemnt {

    private EditText edit_name;
    private EditText edit_frist;
    private EditText edit_second;
    private Button btn_edit;
    private EditPasswordFragment.ViewHold viewHold;

    public static EditPasswordFragment newInstance() {
        return new EditPasswordFragment();
    }

    @Override
    protected void initHeadView() {
        setTitleStyle(true, false, StringConstants.TITLE_EDITPASSWORD);
    }

    @Override
    protected void InitHeadClick() {
        head_view_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 返回上一级
                LoginPresenter.getInstance().goBack();
            }
        });
    }

    @Override
    protected int getContentViewID() {
        return R.layout.fragment_editpassword;
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
        edit_name = (EditText) rootView.findViewById(R.id.edit_username);
        edit_frist = (EditText) rootView.findViewById(R.id.edit_fristpassword);
        edit_second = (EditText) rootView.findViewById(R.id.edit_secondpassword);
        btn_edit = (Button) rootView.findViewById(R.id.edit_button_edit);
        viewHold = new ViewHold();
        viewHold.edit_name = edit_name;
        viewHold.edit_frist = edit_frist;
        viewHold.edit_second = edit_second;
        viewHold.dialog_loading = DialogUtils.getloadingDialog(rootActivity, StringConstants.MESSAGE_LOGINING);
    }

    @Override
    protected void initClick() {
        // 修改密码
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginPresenter.getInstance().editPassword(viewHold);
            }
        });
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        return CubeAnimation.create(CubeAnimation.RIGHT, enter, StringConstants.DURATION);
    }

    @Override
    public void onDestroy() {

        if (viewHold != null) {
            if (viewHold.dialog_loading != null && viewHold.dialog_loading.isShowing()) {
                viewHold.dialog_loading.dismiss();
            }
            viewHold.dialog_loading = null;
        }
        viewHold = null;
        super.onDestroy();
    }

    public class ViewHold {
        public EditText edit_name;
        public EditText edit_frist;
        public EditText edit_second;
        public SweetAlertDialog dialog_loading;
    }

}
