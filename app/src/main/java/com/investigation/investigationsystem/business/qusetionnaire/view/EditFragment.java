package com.investigation.investigationsystem.business.qusetionnaire.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.investigation.investigationsystem.R;
import com.investigation.investigationsystem.business.login.bean.Ti;
import com.investigation.investigationsystem.common.base.BaseTitleFragemnt;

/**
 * ==========================================
 * <p/>
 * 版    权 ： 北京爱接力科技有限公司
 * <p/>
 * 作    者 ： iwen
 * <p/>
 * 版    本 ： 1.0
 * <p/>
 * 创建日期 ： on 2016/7/17  16:36
 * <p/>
 * 描    述 ：
 * 这是填空的问卷
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class EditFragment extends BaseTitleFragemnt {

    private TextView tv_title;
    private EditText ed_edit;
    private static final String TAG_TI = "ti";
    private Ti ti;

    @Override
    protected int getContentViewID() {
        return R.layout.edit_fragment;
    }

    @Override
    protected void initHeadView() {
        setTitleStyle(false);
    }

    @Override
    protected void InitHeadClick() {
        return;
    }

    @Override
    protected void analyzeBundle(Bundle bundle) {
        ti = (Ti) bundle.getSerializable(TAG_TI);
    }

    @Override
    protected void onCreateByUser() {
        return;
    }

    public static EditFragment newInstance(Ti ti) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(TAG_TI, ti);
        EditFragment editFragment = new EditFragment();
        editFragment.setArguments(bundle);
        bundle = null;
        return editFragment;
    }

    @Override
    protected void initView() {
        tv_title = (TextView) rootView.findViewById(R.id.juan_edit_title);
        ed_edit = (EditText) rootView.findViewById(R.id.juan_edit_edit);
        tv_title.setText(ti.getQuestionTitle());
    }

    @Override
    protected void initClick() {

        /**
         * 文字输入变化，添加文字到答卷的指定位置
         */
        ed_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}
