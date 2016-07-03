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
import com.labo.kaji.fragmentanimations.CubeAnimation;


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

    private EditText edit_frist;
    private EditText edit_second;
    private Button btn_edit;

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
        edit_frist = (EditText) rootView.findViewById(R.id.edit_fristpassword);
        edit_second = (EditText) rootView.findViewById(R.id.edit_secondpassword);
        btn_edit = (Button) rootView.findViewById(R.id.edit_button_edit);
    }

    @Override
    protected void initClick() {

    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        return CubeAnimation.create(CubeAnimation.RIGHT, enter, StringConstants.DURATION);
    }

}
