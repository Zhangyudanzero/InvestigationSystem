package com.investigation.investigationsystem.business.update.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.investigation.investigationsystem.R;
import com.investigation.investigationsystem.business.update.presenter.UpdatePresenter;
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
 * 创建日期 ： on 2016/7/3  13:44
 * <p/>
 * 描    述 ：
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class UpdateFragment extends BaseTitleFragemnt {

    // 问卷上传
    private Button btn_upload_question;
    // 反馈信息上传
    private Button btn_upload_feedback;
    // 全部上传
    private Button btn_upload_all;

    // 更新问卷
    private Button btn_update_question;
    // 更新重点监控
    private Button btn_update_emphases;
    // 更新个人信息
    private Button btn_update_my;

    public static UpdateFragment newInstance() {
        return new UpdateFragment();
    }

    @Override
    protected int getContentViewID() {
        return R.layout.fragment_updata;
    }

    @Override
    protected void initHeadView() {
        setTitleStyle(true, false, StringConstants.TITLE_UPDATE);
    }

    @Override
    protected void InitHeadClick() {
        head_view_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdatePresenter.getInstance().goBack();
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
        btn_upload_question = (Button) rootView.findViewById(R.id.update_btn_question_upload);
        btn_upload_feedback = (Button) rootView.findViewById(R.id.update_btn_feedback_upload);
        btn_upload_all = (Button) rootView.findViewById(R.id.update_btn_all_upload);
        btn_update_question = (Button) rootView.findViewById(R.id.update_btn_update_question);
        btn_update_emphases = (Button) rootView.findViewById(R.id.update_btn_update_emphases);
        btn_update_my = (Button) rootView.findViewById(R.id.update_btn_update_userinfo);
    }

    @Override
    protected void initClick() {

        // 问卷上传点击
        btn_upload_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdatePresenter.getInstance().uploadQuestionClick();
            }
        });

        // 反馈信息上传点击
        btn_upload_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdatePresenter.getInstance().uploadFeedbackClick();
            }
        });

        // 全部上传点击
        btn_upload_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdatePresenter.getInstance().uploadAllClick();
            }
        });

        // 更新问卷点击
        btn_update_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdatePresenter.getInstance().updateQuestionClick();
            }
        });

        // 更新重点监控
        btn_update_emphases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdatePresenter.getInstance().updateEmphasesClick();
            }
        });

        // 更新个人信息点击
        btn_update_my.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdatePresenter.getInstance().updateMyClick();
            }
        });
    }

}
