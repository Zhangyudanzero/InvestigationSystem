package com.investigation.investigationsystem.business.suggest.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.investigation.investigationsystem.R;
import com.investigation.investigationsystem.business.suggest.presenter.SuggestPresenter;
import com.investigation.investigationsystem.common.base.BaseTitleFragemnt;
import com.investigation.investigationsystem.common.constants.StringConstants;

/**
 * Created by zero on 2016/7/3.
 */
public class SuggestFragment extends BaseTitleFragemnt {


    private EditText et_commit; //意见建议输入框
    private Button btn_commit; // 提交按钮

    public static SuggestFragment newInstance() {
        return new SuggestFragment();
    }

    @Override
    protected int getContentViewID() {
        return R.layout.fragment_suggest;
    }

    @Override
    protected void initHeadView() {
        setTitleStyle(true, false, StringConstants.TITLE_SUGGEST);
    }

    @Override
    protected void InitHeadClick() {
        head_view_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SuggestPresenter.getInstance().goBack();
            }
        });
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
        et_commit = (EditText) rootView.findViewById(R.id.suggest_et_commit);
        btn_commit = (Button) rootView.findViewById(R.id.suggest_btn_commit);
    }

    @Override
    protected void initClick() {
        //提交按钮点击事件
        btn_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
