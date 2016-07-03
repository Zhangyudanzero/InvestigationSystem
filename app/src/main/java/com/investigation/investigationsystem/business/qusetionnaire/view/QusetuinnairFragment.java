package com.investigation.investigationsystem.business.qusetionnaire.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.investigation.investigationsystem.R;
import com.investigation.investigationsystem.business.qusetionnaire.presenter.QusetuinnairePresenter;
import com.investigation.investigationsystem.common.base.BaseTitleFragemnt;
import com.investigation.investigationsystem.common.constants.StringConstants;

/**
 * Created by zero on 2016/7/3.
 */
public class QusetuinnairFragment extends BaseTitleFragemnt {

    private EditText et_age;
    private EditText et_contact;
    private EditText et_contacttal;
    private EditText et_femalse;
    private EditText et_huji;
    private EditText et_idcard;
    private EditText et_locate;
    private EditText et_relation;
    private EditText et_tel;
    private EditText et_name;
    private Button btn_begin;
    private Button btn_scan;
    private CheckBox cb_same;
    private Spinner spinner_eare;
    private Spinner spinner_questionnaire;
    private Spinner spinner_team;

    public static QusetuinnairFragment newInstance() {
        return new QusetuinnairFragment();
    }

    @Override
    protected int getContentViewID() {
        return R.layout.fragment_questionnaire;
    }

    @Override
    protected void initHeadView() {
        setTitleStyle(true, false, StringConstants.TITLE_QUSETUINNAIR);
    }

    @Override
    protected void InitHeadClick() {
        head_view_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QusetuinnairePresenter.getInstance().goBack();
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
        et_age = (EditText) rootView.findViewById(R.id.questionnaire_et_age);//年龄
        et_contact = (EditText) rootView.findViewById(R.id.questionnaire_et_contact);//联系人
        et_contacttal = (EditText) rootView.findViewById(R.id.questionnaire_et_contacttal);//联系人电话
        et_femalse = (EditText) rootView.findViewById(R.id.questionnaire_et_femalse);//性别
        et_huji = (EditText) rootView.findViewById(R.id.questionnaire_et_huji);//户籍
        et_idcard = (EditText) rootView.findViewById(R.id.questionnaire_et_idcard);//身份证号
        et_locate = (EditText) rootView.findViewById(R.id.questionnaire_et_locate);//现居住地
        et_relation = (EditText) rootView.findViewById(R.id.questionnaire_et_relation);//与联系人的关系
        et_tel = (EditText) rootView.findViewById(R.id.questionnaire_et_tel);//被调查人电话
        et_name = (EditText) rootView.findViewById(R.id.questionnaire_et_name);//姓名

        btn_begin = (Button) rootView.findViewById(R.id.questionnaire_btn_begin);//点击开始调查问卷
        btn_scan = (Button) rootView.findViewById(R.id.questionnaire_btn_scan);//点击开始扫描问卷

        cb_same = (CheckBox) rootView.findViewById(R.id.questionnaire_cb_same);//与户籍地址相同选项
        //地域选择
        spinner_eare = (Spinner) rootView.findViewById(R.id.questionnaire_spinner_eare);
        //问卷选择
        spinner_questionnaire = (Spinner) rootView.findViewById(R.id.questionnaire_spinner_questionnaire);
        //团队选择
        spinner_team = (Spinner) rootView.findViewById(R.id.questionnaire_spinner_team);

    }

    @Override
    protected void initClick() {
        //点击开始调查问卷
        btn_begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //点击扫描身份证
        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


}
