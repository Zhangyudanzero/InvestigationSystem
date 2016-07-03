package com.investigation.investigationsystem.business.main.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.investigation.investigationsystem.R;
import com.investigation.investigationsystem.business.main.presenter.MainPresenter;
import com.investigation.investigationsystem.common.base.BaseTitleFragemnt;
import com.investigation.investigationsystem.common.constants.StringConstants;

/**
 * ==========================================
 * <p/>
 * 版    权 ： 北京爱接力科技有限公司
 * <p/>
 * 作    者 ： iwen
 * <p/>
 * 版    本 ： 1.0
 * <p/>
 * 创建日期 ： on 2016/7/3  11:10
 * <p/>
 * 描    述 ：
 * 这界面UI视图
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class MainFragment extends BaseTitleFragemnt {

    // 重点检测
    private Button btn_emphases;
    // 问卷查询
    private Button btn_quere;
    // 问卷调查
    private Button btn_start;
    // 意见建议
    private Button btn_suggest;
    // 数据更新
    private Button btn_update;
    // 退出系统
    private Button btn_exit;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    protected int getContentViewID() {
        return R.layout.frament_main;
    }

    @Override
    protected void initHeadView() {
        setTitleStyle(false, true, false, StringConstants.TITLE_MAIN, "血色王冠");
    }

    @Override
    protected void InitHeadClick() {
        return;
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
        btn_emphases = (Button) rootView.findViewById(R.id.main_keymonitoring);
        btn_quere = (Button) rootView.findViewById(R.id.main_questionnaire_inquiry);
        btn_start = (Button) rootView.findViewById(R.id.main_question_investigation);
        btn_suggest = (Button) rootView.findViewById(R.id.main_comments_suggestions);
        btn_update = (Button) rootView.findViewById(R.id.main_data_update);
        btn_exit = (Button) rootView.findViewById(R.id.main_exit);
    }

    @Override
    protected void initClick() {

        // 重点检测
        btn_emphases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainPresenter.getInstance().keyMonitoringClick();
            }
        });

        // 查询问卷
        btn_quere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainPresenter.getInstance().btnQuereClick();
            }
        });

        // 开始问卷
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainPresenter.getInstance().btnStartClick();
            }
        });

        // 意见建议
        btn_suggest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainPresenter.getInstance().btnSuggestClick();
            }
        });

        // 数据更新
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainPresenter.getInstance().btnUpdateClick();
            }
        });

        // 退出系统
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainPresenter.getInstance().btnExitClick();
            }
        });
    }

}
