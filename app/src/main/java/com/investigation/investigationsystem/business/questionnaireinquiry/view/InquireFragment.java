package com.investigation.investigationsystem.business.questionnaireinquiry.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.investigation.investigationsystem.R;
import com.investigation.investigationsystem.business.questionnaireinquiry.presenter.InquiryPresenter;
import com.investigation.investigationsystem.common.base.BaseTitleFragemnt;
import com.investigation.investigationsystem.common.constants.StringConstants;

/**
 * Created by zero on 2016/7/3.
 */
public class InquireFragment extends BaseTitleFragemnt {

    private RecyclerView rv_show;

    public static InquireFragment newInstance() {
        return new InquireFragment();
    }


    @Override
    protected int getContentViewID() {
        return R.layout.fragment_questionnaire_inquiry;
    }

    @Override
    protected void initHeadView() {
        setTitleStyle(true, false, StringConstants.TITLE_INQUIRE);
    }

    @Override
    protected void InitHeadClick() {
        head_view_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InquiryPresenter.getInstance().goBack();
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
        rv_show = (RecyclerView) rootView.findViewById(R.id.inquire_rv_show);
        iniRecycleView();
    }

    @Override
    protected void initClick() {

    }

    //初始化recycler
    public void iniRecycleView() {
        rv_show.setLayoutManager(new LinearLayoutManager(rootActivity));
        InquiryPresenter.getInstance().getQuestionnaire(rv_show);
    }

}
