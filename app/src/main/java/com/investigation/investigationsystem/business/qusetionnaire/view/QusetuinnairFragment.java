package com.investigation.investigationsystem.business.qusetionnaire.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;

import com.investigation.investigationsystem.R;
import com.investigation.investigationsystem.business.qusetionnaire.bean.qusertionnaireResult;
import com.investigation.investigationsystem.business.qusetionnaire.presenter.QusetuinnairePresenter;
import com.investigation.investigationsystem.common.base.BaseTitleFragemnt;
import com.investigation.investigationsystem.common.constants.DataConstants;
import com.investigation.investigationsystem.common.constants.StringConstants;
import com.investigation.investigationsystem.common.utils.TimeUtils;
import com.investigation.investigationsystem.common.utils.ToastUtils;

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
    private EditText et_nation;
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
        et_nation = (EditText) rootView.findViewById(R.id.questionnaire_et_nation);//民族

        btn_begin = (Button) rootView.findViewById(R.id.questionnaire_btn_begin);//点击开始调查问卷
        btn_scan = (Button) rootView.findViewById(R.id.questionnaire_btn_scan);//点击开始扫描问卷

        cb_same = (CheckBox) rootView.findViewById(R.id.questionnaire_cb_same);//与户籍地址相同选项
        //地域选择
        spinner_eare = (Spinner) rootView.findViewById(R.id.questionnaire_spinner_eare);
        //问卷选择
        spinner_questionnaire = (Spinner) rootView.findViewById(R.id.questionnaire_spinner_questionnaire);
        //团队选择
        spinner_team = (Spinner) rootView.findViewById(R.id.questionnaire_spinner_team);
        QusetuinnairePresenter.getInstance().chooseTeam(spinner_team , spinner_eare , spinner_questionnaire);
    }

    @Override
    protected void initClick() {
        //点击开始调查问卷
        btn_begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QusetuinnairePresenter.getInstance().beginQusetion(rootActivity);
            }
        });
        //点击扫描身份证
        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        cb_same.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String huji = et_huji.getText().toString();
                if (!huji.isEmpty()) {
                    et_locate.setText(huji);
                }else{
                    ToastUtils.showMessage("户籍地址没有数据");
                }
            }
        });
    }

    /**
     * 获取被调查人信息
     */
    public void getUserInfo(){
        String name = et_name.getText().toString();
        String femalse = et_femalse.getText().toString();
        int femalsez = -1;
        if (femalse.equals("男")) {
            femalsez = 1;
        }else if (femalse.equals("女")){
            femalsez = 2;
        }
        String age = et_age.getText().toString();
        String idcard = et_idcard.getText().toString();
        String huji = et_huji.getText().toString();
        String tel = et_tel.getText().toString();
        String local = et_locate.getText().toString();
        String contact = et_contact.getText().toString();
        String contacttel = et_contacttal.getText().toString();
        String relation = et_relation.getText().toString();
        String nation = et_nation.getText().toString();
        if (name.isEmpty() || femalse.isEmpty() || age.isEmpty() || idcard.isEmpty() || huji.isEmpty()
                || tel.isEmpty() || local.isEmpty() || contact.isEmpty() || contacttel.isEmpty() ||
                relation.isEmpty() || nation.isEmpty()) {
            ToastUtils.showMessage("您有信息没有填写，请填写后继续答题");
        }else{
            //保存被调查者数据
            qusertionnaireResult qusertionnaireResult =
                    new qusertionnaireResult(
                            DataConstants.juanTeamId,
                            DataConstants.JuanAreaId,
                            DataConstants.currentMyUserInfo.getUserID(),
                            DataConstants.juanJuan,
                            TimeUtils.getCurrentTiem(),
                            name,
                            idcard,
                            femalsez,
                            Integer.parseInt(age),
                            nation,
                            tel,
                            huji,
                            local,
                            contact,
                            contacttel,
                            relation
                    );
        }

    }


}
